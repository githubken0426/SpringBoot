package chapter_03.conditional_34;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import chapter_03.conditional_34.service.LinuxListServiceImpl;
import chapter_03.conditional_34.service.ListService;
import chapter_03.conditional_34.service.WinListServiceImpl;

@Configuration
public class ConditionConfig {
	@Bean
	@Conditional(WinCondition.class)
	public ListService windowsListService() {
		return new WinListServiceImpl();
	}
	
	@Bean
	@Conditional(LinuxCondition.class)
	public ListService linuxListService() {
		return new LinuxListServiceImpl();
	}
}
