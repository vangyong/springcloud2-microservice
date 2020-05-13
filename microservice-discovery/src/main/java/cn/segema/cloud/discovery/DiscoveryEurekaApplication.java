package cn.segema.cloud.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 使用Eureka做服务发现.
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryEurekaApplication {
  public static void main(String[] args) {
    SpringApplication.run(DiscoveryEurekaApplication.class, args);
  }
}
