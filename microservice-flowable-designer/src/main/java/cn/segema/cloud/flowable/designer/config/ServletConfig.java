package cn.segema.cloud.flowable.designer.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class ServletConfig {
	@Bean
	public ServletRegistrationBean appDispatcherServlet() {
		// 注解扫描上下文
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		// base package
		applicationContext.scan("org.flowable.modeler.rest", "org.flowable.ui.modeler");
		// 通过构造函数指定dispatcherServlet的上下文
		DispatcherServlet appdispatcherServlet = new DispatcherServlet(applicationContext);

		// 用ServletRegistrationBean包装servlet
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(appdispatcherServlet);
		registrationBean.setLoadOnStartup(2);
		// 指定urlmapping
		registrationBean.addUrlMappings("/activiti/*");
		// 指定name，如果不指定默认为dispatcherServlet
		registrationBean.setName("appDispatcherServlet");
		return registrationBean;
	}

}
