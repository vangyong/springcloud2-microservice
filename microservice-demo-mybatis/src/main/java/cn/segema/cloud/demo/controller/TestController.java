package cn.segema.cloud.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.demo.domain.User;
import cn.segema.cloud.demo.vo.UserVO;

@RestController
@RequestMapping(value = "/test")
public class TestController {
  @Autowired
  private DiscoveryClient discoveryClient;
  
  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private RedisTemplate redisTemplate;
 
  
  @GetMapping("/redis")
	public List<UserVO> redis(User user, Model model) {
	  	UserVO user1 = new UserVO();
	  	user1.setUserId("1");
	  	user1.setUserName("a1");
	  	UserVO user2 = new UserVO();
	  	user2.setUserId("2");
	  	user2.setUserName("a2");
		List<UserVO> userList = new ArrayList<UserVO>();
		userList.add(user1);
		userList.add(user2);
		String key ="123456";
		Set<UserVO> userSet = new HashSet<UserVO>();
		Set<TypedTuple<UserVO>> userzSet = new HashSet<TypedTuple<UserVO>>();
		
		HashOperations<String,String, UserVO> hashOps =  redisTemplate.opsForHash();
		ValueOperations<String, UserVO> valueOps = redisTemplate.opsForValue();
		ListOperations<String, UserVO> listOps =redisTemplate.opsForList();
		SetOperations<String, UserVO> setOps = redisTemplate.opsForSet();
		ZSetOperations<String, UserVO> zSetOps = redisTemplate.opsForZSet();
		
		String returnString =  (String) redisTemplate.opsForValue().get(key);
	
		valueOps.set(key, user1);
		listOps.set(key, 0, user1);
		listOps.set(key, 1, user2);
		setOps.add(key, user1);
		zSetOps.add(key, userzSet);
		
		UserVO returnUser =  valueOps.get(key);
		
		UserVO returnUser2 =  listOps.index(key, 0);
		
		UserVO returnUser3 =  setOps.pop(key);
		
		
		return userList;
	}

	
 

  /**
   * 本地服务实例的信息
   * @return
   */
  @GetMapping("/instance-info")
  public ServiceInstance showInfo() {
    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
    return localServiceInstance;
  }
}
