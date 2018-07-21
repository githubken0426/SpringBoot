package chapter_04._41;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("chapter_04._41")
public class MVCConfig {
	@Bean
	public InternalResourceViewResolver bireResolver() {
		InternalResourceViewResolver view =new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/classes/views/");
		view.setSuffix(".jsp");
		view.setViewClass(JstlView.class);
		return view;
	}
}
