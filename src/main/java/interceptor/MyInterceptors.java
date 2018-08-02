package interceptor;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.convert.ConversionService;
import org.springframework.ui.ModelMap;
import org.springframework.util.PathMatcher;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.ConversionServiceExposingInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.resource.ResourceUrlProvider;
import org.springframework.web.servlet.resource.ResourceUrlProviderExposingInterceptor;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.util.UrlPathHelper;

/**
 * 
 * 拦截器是动态拦截Action调用的对象，它提供了一种机制可以使开发者在一个Action执行的前后执行一段代码，
 * 也可以在一个Action执行前阻止其执行，同时也提供了一种可以提取Action中可重用部分代码的方式。
 * 在AOP中，拦截器用于在某个方法或者字段被访问之前，进行拦截然后再之前或者之后加入某些操作.
 * 拦截器是基于java反射机制来实现的(基于动态代理实现)，而过滤器是基于函数回调来实现的。
 * 
 * 拦截器、过滤器区别
 * 4.2，拦截器不依赖servlet容器，过滤器依赖于servlet容器。
 * 4.3，拦截器只对Action起作用，过滤器可以对所有请求起作用。
 * 4.4，拦截器可以访问Action上下文和值栈中的对象，过滤器不能。
 * 4.5，在Action的生命周期中，拦截器可以多次调用，而过滤器只能在容器初始化时调用一次。
 * 
 * @author ken
 * @date 2018年7月31日 上午8:48:43
 */
public class MyInterceptors {
	/**
	 * 1.HandlerInterceptorAdapter 这个是简单的实现模板，可以继承来实现自己的拦截器定义
	 * @author ken
	 */
	class MyHandler extends HandlerInterceptorAdapter {
		/**
		 * 1、拦截器的预处理。 
		 * 	在controller处理逻辑之前执行，返回true再接着执行controller中的其他业务; 
		 * 	返回false则中断返回
		 */
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			return false;
		}

		/**
		 * 2、拦截器的后处理 (在执行controller的处理后，在ModelAndView处理前执行)有机会修改ModelAndView
		 * 在执行controller里面的逻辑后，返回结果之前执行。
		 */
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
		}

		/**
		 * 3、在controller返回结果之后执行(在DispatchServlet执行完ModelAndView之后执行)
		 * 可以根据ex是否为null判断是否发生了异常，进行日志记录。
		 */
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
				Exception ex) throws Exception {
		}

		/**
		 * 4、这个方法会在Controller方法异步执行时开始执行，
		 * 而Interceptor的postHandle方法则是需要等到Controller的异步执行完才能执行。
		 */
		public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response,
				Object handler) throws Exception {
		}
	}
	
	/**
	 * 2.WebContentInterceptor继承了WebContentGenerator实现了HandlerInterceptor，
	 *   这个拦截器可以设置缓存及缓存时间、请求方法、url是否使用默认的iso-8859-1，及URL解析设置，
	 *   PathMatcher路径匹配器等，还有设置session是否是需要的，可以说这个拦截器功能还是很多的。
	 */
	class MyWebContent extends WebContentInterceptor {
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws ServletException {
			return super.preHandle(request, response, handler);
		}

		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			super.postHandle(request, response, handler, modelAndView);
		}

		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
				Exception ex) throws Exception {
			super.afterCompletion(request, response, handler, ex);
		}

		@Override
		public void setAlwaysUseFullPath(boolean alwaysUseFullPath) {
			super.setAlwaysUseFullPath(alwaysUseFullPath);
		}

		@Override
		public void setUrlDecode(boolean urlDecode) {
			super.setUrlDecode(urlDecode);
		}

		@Override
		public void setUrlPathHelper(UrlPathHelper urlPathHelper) {
			super.setUrlPathHelper(urlPathHelper);
		}

		@Override
		public void setCacheMappings(Properties cacheMappings) {
			super.setCacheMappings(cacheMappings);
		}

		@Override
		public void setPathMatcher(PathMatcher pathMatcher) {
			super.setPathMatcher(pathMatcher);
		}

		@Override
		protected Integer lookupCacheSeconds(String urlPath) {
			return super.lookupCacheSeconds(urlPath);
		}
	}

	/**
	 * 3.AsyncHandlerInterceptor接口继承HandlerInterceptor，用来处理异步请求，
	 *   直接返回不执行postHandle和afterCompletion的代替方法afterConcurrentHandlingStarted。
	 */
	class MyAsyncHandler implements AsyncHandlerInterceptor{

		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			return false;
		}

		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
		}

		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
				Exception ex) throws Exception {
		}
		/**
		 * 当Controller中有异步请求方法的时候会触发该方法。
		 * 每次处理程序得到正确执行时，都会调用此方法而不是调用postHandler()和afterCompletion()。
		 * 它也可以对发送请求进行异步处理。这个方法的典型的应用是可以用来清理本地线程变量。
		 */
		public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response,
				Object handler) throws Exception {
		}
		
	}
	
	/**
	 * 4、与HandlerInterceptor接口类似，区别是 WebRequestInterceptor 的 preHandle 没有返回值。
	 * WebRequestInterceptor 是针对请求的，接口方法参数中没有response
	 */
	class MyWebRequest implements WebRequestInterceptor{
		public void preHandle(WebRequest request) throws Exception {
		}

		public void postHandle(WebRequest request, ModelMap model) throws Exception {
		}

		public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		}
		
	}
	
	/**
	 * 5、WebRequestHandlerInterceptorAdapter
	 * 适配器它实现servlet HandlerInterceptor接口并封装底层WebRequestInterceptor
	 */
	class MyWebRequestHandler extends WebRequestHandlerInterceptorAdapter{
		public MyWebRequestHandler(WebRequestInterceptor requestInterceptor) {
			super(requestInterceptor);
		}

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			return super.preHandle(request, response, handler);
		}

		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			super.postHandle(request, response, handler, modelAndView);
		}

		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
				Exception ex) throws Exception {
			super.afterCompletion(request, response, handler, ex);
		}

		@Override
		public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response,
				Object handler) {
			super.afterConcurrentHandlingStarted(request, response, handler);
			/**
			 * if (this.requestInterceptor instanceof AsyncWebRequestInterceptor) {
					AsyncWebRequestInterceptor asyncInterceptor = (AsyncWebRequestInterceptor) this.requestInterceptor;
					DispatcherServletWebRequest webRequest = new DispatcherServletWebRequest(request, response);
					asyncInterceptor.afterConcurrentHandlingStarted(webRequest);
				}
			 */
		}
	}

	/**
	 * 6、默认的<annotation-driven/>标签初始化的时候会初始化ConversionServiceExposingInterceptor这个拦截器，
	 *    作用是暴露 conversionService 到请求中以便使用</spring:eval>;
	 * 
	 *   并被当做构造方法的参数来构造MappedInterceptor。
	 *   之后会被加入到AbstractHandlerMapping的mappedInterceptors集合中。
	 *   该拦截器会在每个请求之前往request中丢入ConversionService。主要用于spring:eval标签的使用。
	 */
	class MyConversionService extends ConversionServiceExposingInterceptor{
		public MyConversionService(ConversionService conversionService) {
			super(conversionService);
		}

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws ServletException, IOException {
			return super.preHandle(request, response, handler);
		}

		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			super.postHandle(request, response, handler, modelAndView);
		}

		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
				Exception ex) throws Exception {
			super.afterCompletion(request, response, handler, ex);
		}

		@Override
		public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response,
				Object handler) throws Exception {
			super.afterConcurrentHandlingStarted(request, response, handler);
		}
	}
	
	/**
	 * 7、设置国际化解析器
	 * 它会发现当前HTTP请求中出现的特殊参数。其中的参数名称可以通过拦截器的paramName属性进行自定义。
	 * 如果这种参数出现在当前请求中，拦截器就会根据参数值来改变用户的区域
	 * http://localhost:8080/court/welcome.htm?language=en_US.
	 * http://localhost:8080/court/welcome.htm?language=de.
	 */
	class MyLocaleChange extends LocaleChangeInterceptor{

		@Override
		public void setParamName(String paramName) {
			super.setParamName(paramName);
		}

		@Override
		public String getParamName() {
			return super.getParamName();
		}

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws ServletException {
			return super.preHandle(request, response, handler);
		}
	}
	
	/**
	 * 8、主题解析器
	 */
	class MyThemeChange extends ThemeChangeInterceptor{
		@Override
		public void setParamName(String paramName) {
			super.setParamName(paramName);
		}
		@Override
		public String getParamName() {
			return super.getParamName();
		}

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws ServletException {
			return super.preHandle(request, response, handler);
		}
	}

	/**
	 * 9、资源URL提供者，你可以配置好多工具来处理URL，主要是放入request的属性中
	 *    该拦截器用于静态资源访问，定义了以下的标签，在该标签初始化的时候会初始化这个拦截器
	 *    <mvc:resources location="/" mapping="/**"></mvc:resources>
	 *  @author ken
	 */
	class MyResourceUrlProvider extends ResourceUrlProviderExposingInterceptor{
		public MyResourceUrlProvider(ResourceUrlProvider resourceUrlProvider) {
			super(resourceUrlProvider);
		}

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			return super.preHandle(request, response, handler);
		}

		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			super.postHandle(request, response, handler, modelAndView);
		}

		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
				Exception ex) throws Exception {
			super.afterCompletion(request, response, handler, ex);
		}

		@Override
		public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response,
				Object handler) throws Exception {
			super.afterConcurrentHandlingStarted(request, response, handler);
		}
		
	}
	
	/**
	 * 检查用户角色授权
	 */
	class MyUserRoleAuthorization extends UserRoleAuthorizationInterceptor{

		@Override
		protected void handleNotAuthorized(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws ServletException, IOException {
			super.handleNotAuthorized(request, response, handler);
		}

		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			super.postHandle(request, response, handler, modelAndView);
		}

		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
				Exception ex) throws Exception {
			super.afterCompletion(request, response, handler, ex);
		}

		@Override
		public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response,
				Object handler) throws Exception {
			super.afterConcurrentHandlingStarted(request, response, handler);
		}
		
	}
}
