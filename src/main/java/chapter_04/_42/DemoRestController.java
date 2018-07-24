package chapter_04._42;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController声明控制器，返回数据不需要@ResponseBody
 * @ClassName: DemoRestController
 * @Description:
 * @author ken
 * @date 2018年7月24日 上午8:46:14
 */
@RestController
@RequestMapping("/anno")
public class DemoRestController {

	@RequestMapping(value = "/getjson", produces = "application/json;charset=UTF-8")
	public DemoObj index(HttpServletRequest reqeust) {
		DemoObj obj = new DemoObj();
		obj.setId("001");
		obj.setName("张三");
		return obj;
	}

	@RequestMapping(value = "/getxml", produces = "application/xml;charset=UTF-8")
	public DemoObj pathVar(@PathVariable("str") String param, HttpServletRequest reqeust) {
		DemoObj obj = new DemoObj();
		obj.setId("001");
		obj.setName("张三");
		return obj;
	}
}
