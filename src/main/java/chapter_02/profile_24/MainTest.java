package chapter_02.profile_24;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("prod");
		context.register(ProfileConfig.class);
		context.refresh();
		DemoBean bean=context.getBean(DemoBean.class);
		System.out.println(bean.getContent());
		context.close();
	}
}
