package cn.segema.cloud.flowable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FlowableApplication {
	
  public static void main(String[] args) {
    SpringApplication.run(FlowableApplication.class, args);
  }
  
//  @Bean  
//  public ServletListenerRegistrationBean<org.flowable.app.servlet.WebConfigurer> webConfigurerRegistration(){  
//      ServletListenerRegistrationBean<org.flowable.app.servlet.WebConfigurer> registration = new ServletListenerRegistrationBean<org.flowable.app.servlet.WebConfigurer>(new org.flowable.app.servlet.WebConfigurer());  
//      return registration;  
//  }  
  
}
