package cn.segema.cloud.contract.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cn.segema.cloud.contract.web.entity.Contract;


@Service
public class WebContractService {
  
 /* @Autowired
  private RestTemplate restTemplate;*/
  
  public Contract findById(Long id) {
	    //return this.restTemplate.getForObject("http://microservice-contract/" + id, Contract.class);
	    return null;
  }
  
  public List<Contract> listByPageable(int page,int size) {
	  	/*Map<String,Integer> parameter = new HashMap<String,Integer>();
	  	parameter.put("page", page);
	  	parameter.put("size", size);
	    return (List<Contract>) this.restTemplate.getForObject("http://microservice-contract/listByPageable", Contract.class,parameter);*/
	  return null;
	  }
  
}
