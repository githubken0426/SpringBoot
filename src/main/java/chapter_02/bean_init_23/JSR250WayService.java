package chapter_02.bean_init_23;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {
	@PostConstruct
	public void init() {
		System.out.println("JSR250-init-method");
	}
	
	public JSR250WayService() {
		super();
		System.out.println("初始化构造函数JSR250WayService");
	}
	
	@PreDestroy
	public void destory() {
		System.out.println("jsr250-destory-method");
	}
}
