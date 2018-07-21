package chapter_04._41;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("@RequestMapping(\"/index\")");
		return "NewFile";
	}
}
