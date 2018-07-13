package chapter_03.aware_31;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
		AwareService aware=context.getBean(AwareService.class);
		aware.outputResult();
		context.close();
	}
}
