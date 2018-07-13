package chapter_02.even_25;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
		DemoPublisher publisher=context.getBean(DemoPublisher.class);
		publisher.publish("this is the test");
		context.close();
	}
}
