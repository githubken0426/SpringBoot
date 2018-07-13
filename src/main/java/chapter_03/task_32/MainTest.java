package chapter_03.task_32;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
		AsyncTaskService task=context.getBean(AsyncTaskService.class);
		for(int i=0;i<10;i++)
			task.executeAsyncTask(i);
		context.close();
	}
}
