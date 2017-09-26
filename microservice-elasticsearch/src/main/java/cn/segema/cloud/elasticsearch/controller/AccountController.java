package cn.segema.cloud.elasticsearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.elasticsearch.domain.Account;
import cn.segema.cloud.elasticsearch.repository.AccountRepository;

@RestController(value = "/account")
public class AccountController {
 /* @Autowired
  private DiscoveryClient discoveryClient;*/
  @Autowired
  private AccountRepository accountRepository;
  
  
  @PostMapping("/index") 
  public Account index() {
	  Account account = new Account();
	  account.setAccountName("wangyong");
	  Account account2 = accountRepository.index(account);
	  return account2;
	}
  
  @GetMapping("/search") 
  public List<Account> search() {
	  //List<Account> userList = accountRepository.findByAccountName(accountName);
	  List<Account> userList = new ArrayList<Account>();
	  return userList;
	}
  
  
  @GetMapping("/queryByAccountName/{accountName}") 
  public Account queryByAccountName(@PathVariable String accountName, ModelMap modelMap) {
	  
	  Account account = accountRepository.findByAccountName(accountName);
      modelMap.addAttribute("esAccount",account);
      modelMap.addAttribute("test_elastic","Test the elasticsearch");
	  
	  return account;
	}
  

  /**
   * 本地服务实例的信息
   * @return
   */
/*  @GetMapping("/instance-info")
  public ServiceInstance showInfo() {
    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
    return localServiceInstance;
  }*/
}
