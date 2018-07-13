package chapter_03.task_33;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("chapter_03.task_33")
@EnableScheduling //开启对计划任务的支持
public class TaskSchedulerConfig {

}
