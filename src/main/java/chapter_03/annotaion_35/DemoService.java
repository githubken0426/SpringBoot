package chapter_03.annotaion_35;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
	public void outPrintResult() {
		System.out.println("从组合注解获取bean!");
	}
}
