package chapter_04._41;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
/**
 * logback + slf4j 配置日志
 * @ClassName: IndexController 
 * @Description: 
 * @author ken 
 * @date 2018年7月23日 下午8:28:56
 */
@Controller
public class IndexController {
	Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping("/index")
	public String index() {
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);
		
		logger.debug("@RequestMapping(\"/index\")");
		return "NewFile";
	}
}
