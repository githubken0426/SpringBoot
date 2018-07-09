package chapter_02.springEL_22;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	@Value("其他类的属性")
	private String ahother;

	public String getAhother() {
		return ahother;
	}

	public void setAhother(String ahother) {
		this.ahother = ahother;
	}
}
