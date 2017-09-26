package cn.segema.cloud.shrio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShrioApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShrioApplication.class, args);
	}
}
    		 