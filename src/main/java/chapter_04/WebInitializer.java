package chapter_04;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import chapter_04._42.MVCConfig;
/**
 * 实现WebApplicationInitializer接口等同于web.xml的配置
 * @ClassName: WebInitializer 
 * @Description: 
 * @author ken 
 * @date 2018年7月23日 下午8:29:58
 */
public class WebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(MVCConfig.class);
		context.setServletContext(servletContext);
		DispatcherServlet disaptcher = new DispatcherServlet(context);
		Dynamic servlet = servletContext.addServlet("dispatcher", disaptcher);
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
