package chapter_03.task_33;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTaskService {
	private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate=5000)
	public void reportCurrentDate() {
		System.out.println("每5秒执行一次:"+format.format(new Date()));
	}
	
	@Scheduled(cron="0 28 11 ? * *")
	public void fixTimeExecution() {
		System.out.println("指定时间:"+format.format(new Date())+"执行！");
	}
}
