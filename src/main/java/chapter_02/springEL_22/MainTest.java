package chapter_02.springEL_22;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
		ELConfig config=context.getBean(ELConfig.class);
		config.outputresouce();
		context.close();
	}
}
