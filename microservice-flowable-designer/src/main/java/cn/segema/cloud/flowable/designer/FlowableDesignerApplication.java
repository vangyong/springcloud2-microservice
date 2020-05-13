package cn.segema.cloud.flowable.designer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@ComponentScan(basePackages = {"cn.segema.cloud.flowable.designer"})
public class FlowableDesignerApplication {
  public static void main(String[] args) {
    SpringApplication.run(FlowableDesignerApplication.class, args);
  }
  
  
}
