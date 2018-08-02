package interceptor;

import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.PathMatcher;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.util.UrlPathHelper;

/**
 * 5.ConversionServiceExposingInterceptor 可以设置一个ConversionService
 * 
 * 6.LocaleChangeInterceptor 可以设置国际化解析器
 * 
 * 7.ThemeChangeInterceptor 可以设置主题解析器
 * 
 * 8.ResourceUrlProviderExposingInterceptor 资源URL提供者，你可以配置好多工具来处理URL，
 *   主要是放入request的属性中了。
 * 
 * 8.UserRoleAuthorizationInterceptor 用户权限拦截器
 * @ClassName: MyInterceptor
 * @Description:
 * @author ken
 * @date 2018年7月31日 上午8:48:43
 */
public class MyInterceptors {
	/**
	 * 1.HandlerInterceptorAdapter 这个是简单的实现模板，可以继承来实现自己的拦截器定义
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
	 * 4、WebRequestHandlerInterceptorAdapter
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
}
