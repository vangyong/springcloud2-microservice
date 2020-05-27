package cn.sgema.cloud.devtool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.segema.devtool.mapper")
public class DevToolApplication {

    public static void main(String[] args){
        SpringApplication.run(DevToolApplication.class,args);
    }
}
