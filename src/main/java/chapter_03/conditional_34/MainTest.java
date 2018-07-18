package chapter_03.conditional_34;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chapter_03.conditional_34.service.ListService;

public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
		ListService service=context.getBean(ListService.class);
		System.out.println(context.getEnvironment().getProperty("os.name")+":"+service.showListCmd());
		context.close();
	}
}
