package cn.segema.cloud.system.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.segema.cloud.system.web.service.UserWebService;
import cn.segema.cloud.system.web.vo.UserVO;

@Controller
@RequestMapping(value = "/user/web")
public class UserWebController {
	
	@Autowired
	private UserWebService userWebService;
    
	@RequestMapping("/getTableData") 
    @ResponseBody
    public Page<UserVO> getTableData() {
  	  try { 
  		  int pageNum=1;
  		  int pageSize=20;
  		  String username="A";
  		  Page<UserVO> userList = userWebService.listByPageable(pageNum,pageSize);
  		  System.out.println("this is userList:");
  		  return userList;
  	  } catch (Exception e) { 
  		  e.printStackTrace(); 
  	  } return null; 
  	}
    
    @RequestMapping("/listByPageable")
    @ResponseBody
	public Page<UserVO> listByPageable(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "5") Integer size) {
		Sort sort = Sort.by(Direction.DESC, "userId");
		Pageable pageable = PageRequest.of(page, size, sort);
		return userWebService.listByPageable(page,size);
	}
    
    @RequestMapping("/findById/{userId}")
    @ResponseBody
    public UserVO findById(@PathVariable String userId) {
    	UserVO findOne = this.userWebService.findById(userId);
      return findOne;
    }
}
