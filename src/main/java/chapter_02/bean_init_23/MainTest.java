package chapter_02.bean_init_23;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);
		context.getBean(BeanWayService.class);
		context.getBean(JSR250WayService.class);
		context.close();
	}
}
