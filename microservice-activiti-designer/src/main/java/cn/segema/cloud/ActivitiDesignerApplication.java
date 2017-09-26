package cn.segema.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.segema.cloud.activiti.modeler.JsonpCallbackFilter;

@SpringBootApplication
@ComponentScan({"org.activiti.rest.diagram", "cn.segema.cloud"})
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
		org.activiti.spring.boot.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class
})
//@EnableAsync
public class ActivitiDesignerApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiDesignerApplication.class, args);
	}

	@Bean
	public JsonpCallbackFilter filter(){
		return new JsonpCallbackFilter();
	}
}
