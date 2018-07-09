package chapter_02.scope_21;

import org.springframework.stereotype.Service;

/**
 * Singleton:Spring默认配置,全容器共享一个实例。
 * Prototype: 每次调用创建一个新的实例。
 * Request: Web中，为每一个HttpRequest创建新的实例。
 * Session: Web中，为每一个HttpSession创建新的实例。
 * GlobalSession:只在protal应用中有用，为每一个GlobalHttpSession创建新的实例。
 * 
 * @author ken
 *
 */
@Service
public class SingletonService {
	
}
