package chapter_04._42;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/anno")
public class AnnoController {
	
	//produces设置返回的response媒体类型和字符集
	@ResponseBody
	@RequestMapping(produces = "text/plain;charset=UTF-8")
	public String index(HttpServletRequest reqeust) {
		return "url" + reqeust.getRequestURI();
	}

	@ResponseBody
	@RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
	public String pathVar(@PathVariable("str") String param, HttpServletRequest reqeust) {
		return "url" + reqeust.getRequestURI() + ",参数:" + param;
	}
	
	@ResponseBody
	@RequestMapping(value = "/reqeustParam", produces = "text/plain;charset=UTF-8")
	public String reqeustParam(Long id, HttpServletRequest reqeust) {
		return "url" + reqeust.getRequestURI() + ",参数:" + id;
	}
	
	@ResponseBody
	@RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
	public String obj(Long id, HttpServletRequest reqeust) {
		return "url" + reqeust.getRequestURI() + ",参数:" + id;
	}
}
