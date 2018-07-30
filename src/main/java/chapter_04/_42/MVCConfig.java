package chapter_04._42;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("chapter_04")
public class MVCConfig {
	/**
	 * 视图解析器
	 * <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
			<property name="prefix" value="/" />
			<property name="suffix" value=".jsp" />
		</bean>
	 * @return
	 * @throws 
	 * @date 2018年7月23日 下午8:33:33
	 */
	@Bean
	public InternalResourceViewResolver bireResolver() {
		//视图解析器
		InternalResourceViewResolver view =new InternalResourceViewResolver();
		view.setViewClass(JstlView.class);
		view.setPrefix("/WEB-INF/classes/views/");
		view.setSuffix(".jsp");
		return view;
	}
}
