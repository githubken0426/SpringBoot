package chapter_03.aware_31;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{
	private String beanName;
	private ResourceLoader resourceLoader;
	
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader=resourceLoader;
	}

	public void setBeanName(String beanName) {
		this.beanName=beanName;
	}
	
	public void outputResult() {
		System.out.println("bean name:"+beanName);
		try {
			Resource resource=resourceLoader.getResource("classpath:chapter_03/aware_31/log4j.properties");
			System.out.println("文件内容:"+IOUtils.toString(resource.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
