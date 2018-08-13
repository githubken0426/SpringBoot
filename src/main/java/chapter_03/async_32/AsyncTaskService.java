package chapter_03.async_32;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
	
	//声明异步方法，如果在calss级别声明，标识此class下所有方法都是async
	@Async 
	public void executeAsyncTask(int i) {
		System.out.println("执行异步任务："+i);
	}
	
	@Async 
	public void executeAsyncTaskPlus(int i) {
		System.out.println("执行异步任务+1："+(i+1));
	}
}
