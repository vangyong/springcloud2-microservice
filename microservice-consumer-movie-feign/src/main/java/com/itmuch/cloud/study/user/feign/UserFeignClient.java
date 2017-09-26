package com.itmuch.cloud.study.user.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itmuch.cloud.study.user.entity.User;

/**
 * 使用@FeignClient("microservice-system")注解绑定microservice-system服务，还可以使用url参数指定一个URL。
 * @author wangyong
 */
@FeignClient(name = "microservice-system")
public interface UserFeignClient {
  @RequestMapping("/user/{id}")
  public User findByIdFeign(@RequestParam("id") String id);
}
