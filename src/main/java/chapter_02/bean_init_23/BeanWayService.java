package chapter_02.bean_init_23;

public class BeanWayService {
	public void init() {
		System.out.println("@Bean-init-method!");
	}
	
	public BeanWayService() {
		super();
		System.out.println("初始化构造函数BeanWayService。");
	}
	public void destory() {
		System.out.println("@Bean-destory-method!");
	}
}
