package chapter_04._44;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@ComponentScan("chapter_04")
@Configuration
@EnableWebMvc
public class MVCConfig extends WebMvcConfigurerAdapter{
	//WebMvcConfigurationSupport
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver view=new InternalResourceViewResolver();
		view.setPrefix("");
		view.setSuffix(".jsp");
		view.setViewClass(JstlView.class);
		return view;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
	}
}
