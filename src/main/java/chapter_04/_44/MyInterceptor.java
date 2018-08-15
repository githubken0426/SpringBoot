package chapter_04._44;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 继承HandlerInterceptorAdapter
 * @ClassName: MyInterceptor 
 * @Description: 
 * @author ken 
 * @date 2018年7月31日 上午8:48:43
 */
public class MyInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 拦截器的预处理
	 * 在执行action里面的处理逻辑之前执行，它返回的是boolean，如果返回true再接着执行action中的内容，如果返回false则中断返回
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SimpleDateFormat format=new SimpleDateFormat();
		Long start=System.currentTimeMillis();
		request.setAttribute("startTime",start);
		System.out.println("1、preHandle,start:"+format.format(start));
		return true;
	}
	/**
	 * 后处理（调用了Service并返回ModelAndView，但未进行页面渲染）
	 * 有机会修改ModelAndView
	 * 在执行action里面的逻辑后，返回结果之前执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		SimpleDateFormat format=new SimpleDateFormat();
		Object start=request.getAttribute("startTime");
		request.removeAttribute("startTime");
		System.out.println("2、postHandle,start:"+format.format(start)+",end:"+format.format(System.currentTimeMillis()));
	}
	/**
	 * 在action返回结果之后执行
	 * 可以根据ex是否为null判断是否发生了异常，进行日志记录
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("3、afterCompletion");
		super.afterCompletion(request, response, handler, ex);
	}
	/**
	 * 相对于HandlerInterceptor，HandlerInterceptorAdapter多了一个实现方法afterConcurrentHandlingStarted()，
	 * 它来自HandlerInterceptorAdapter的直接实现类AsyncHandlerInterceptor,
	 * AsyncHandlerInterceptor接口直接继承了HandlerInterceptor，并新添了afterConcurrentHandlingStarted()方法用于处理异步请求，
	 * 当Controller中有异步请求方法的时候会触发该方法时，
	 * 异步请求先支持preHandle、然后执行afterConcurrentHandlingStarted。
	 * 异步线程完成之后执行preHandle、postHandle、afterCompletion
	 */
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("4、afterConcurrentHandlingStarted");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
