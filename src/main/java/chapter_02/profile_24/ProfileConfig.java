package chapter_02.profile_24;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {
	
	@Bean
	@Profile("dev")
	public DemoBean devDemoBean() {
		return new DemoBean("from devDemoBean profile");
	}
	
	@Bean
	@Profile("prod")
	public DemoBean prodDemoBean() {
		return new DemoBean("from prodDemoBean profile");
	}
}
