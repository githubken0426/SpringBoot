package chapter_02.scope_21;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
		SingletonService singleton_1=context.getBean(SingletonService.class);
		SingletonService singleton_2=context.getBean(SingletonService.class);
		System.out.println("singleton_1等于singleton_2："+singleton_1.equals(singleton_2));
		
		PrototypeService prototype_1=context.getBean(PrototypeService.class);
		PrototypeService prototype_2=context.getBean(PrototypeService.class);
		
		System.out.println("prototype_1等于prototype_2："+prototype_1.equals(prototype_2));
		context.close();
	}
}
