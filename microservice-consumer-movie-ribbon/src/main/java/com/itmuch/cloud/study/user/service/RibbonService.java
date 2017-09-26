package com.itmuch.cloud.study.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.study.user.entity.Contract;
import com.itmuch.cloud.study.user.entity.User;

@Service
public class RibbonService {
  @Autowired
  private RestTemplate restTemplate;

  public User findById(Long id) {
    // http://服务提供者的serviceId/url
    // return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    return this.restTemplate.getForObject("http://microservice-system/user/" + id, User.class);
  }
  
  public Contract findContractById(Long id) {
	    return this.restTemplate.getForObject("http://microservice-provider-contract/" + id, Contract.class);
	  }
}
