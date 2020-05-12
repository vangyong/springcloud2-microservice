package cn.segema.cloud.monitor;

/**
 * 通过@EnableTurbine接口，激活对Turbine的支持。
 * @author eacdy
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableTurbine
public class TurbineApplication {
  public static void main(String[] args) {
    SpringApplication.run(TurbineApplication.class, args);
  }
}
