package chapter_04._41;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

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
