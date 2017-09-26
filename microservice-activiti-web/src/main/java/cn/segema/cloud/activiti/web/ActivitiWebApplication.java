package cn.segema.cloud.activiti.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ActivitiWebApplication {
  public static void main(String[] args) {
    SpringApplication.run(ActivitiWebApplication.class, args);
  }
}
