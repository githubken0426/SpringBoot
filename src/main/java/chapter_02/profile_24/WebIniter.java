package chapter_02.profile_24;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

public class WebIniter implements WebApplicationInitializer{

	public void onStartup(ServletContext container) throws ServletException {
		container.setInitParameter("spring.profile.default", "dev");
	}

}
