package chapter_02.even_25;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoLisnter implements ApplicationListener<DemoEvent> {

	public void onApplicationEvent(DemoEvent event) {
		String message=event.getMessage();
		System.out.println("DemoLisnter收到了"+event.getClass().getName()+"的消息:"+message);
	}
}
