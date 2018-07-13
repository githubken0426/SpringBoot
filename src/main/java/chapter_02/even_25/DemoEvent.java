package chapter_02.even_25;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;
	
	public DemoEvent(Object source,String message) {
		super(source);
		this.message=message;
	}
	
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
