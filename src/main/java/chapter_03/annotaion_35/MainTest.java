package chapter_03.annotaion_35;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		DemoService bean=context.getBean(DemoService.class);
		bean.outPrintResult();
		context.close();
	}
}
