package cn.segema.cloud.mail.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.segema.cloud.mail.test.domain.ActivitiUser;
import cn.segema.cloud.mail.test.repository.ActivitiUserRepository;

@Controller
@RequestMapping(value = "/test/activiti/user")
public class ActivitiUserController {
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private ActivitiUserRepository activitiUserRepository;

	/**
	 * @param id
	 * @return user信息
	 */
	@RequestMapping("/{userId}")
	@ResponseBody
	public ActivitiUser findById(@PathVariable Integer userId) {
		ActivitiUser findOne = this.activitiUserRepository.findOne(userId);
		return findOne;
	}
	
	@RequestMapping("/listUI")
	public ModelAndView listUI(ActivitiUser user, Model model) {
		ModelAndView ModelAndView = new ModelAndView("/test/activiti/user/listUI");
		return ModelAndView;
	}
	
	@RequestMapping("/modeler")
	public ModelAndView modeler(ActivitiUser user, Model model) {
		ModelAndView ModelAndView = new ModelAndView("/modeler");
		return ModelAndView;
	}

	@RequestMapping("/list")
	@ResponseBody
	public List<ActivitiUser> list(ActivitiUser user, Model model) {
		List<ActivitiUser> userList = activitiUserRepository.findAll();
		return userList;
	}

	@RequestMapping("/add")
	@ResponseBody
	public ActivitiUser add(ActivitiUser user, Model model) {
		activitiUserRepository.save(user);
		return user;
	}

	@RequestMapping(value = "edit")
	public ActivitiUser edit(ActivitiUser user, Model model) {
		// Role oldRole = roleRepository.getOne(role.getRoleId());
		// BeanUtils.copyProperties(role, oldRole);
		activitiUserRepository.save(user);
		return user;
	}

	@RequestMapping(value = "delete")
	@ResponseBody
	public ActivitiUser delete(ActivitiUser user) {
		activitiUserRepository.delete(user);
		return user;
	}

	/*
	 * @GetMapping("/listByUserName/{userName}") public List<UserPersonalVO>
	 * listByUserName(@PathVariable String userName) { List<UserPersonalVO> userList
	 * = userRepository.findByUserName(userName); return userList; }
	 */

	@RequestMapping("/listByPage/{page}/{size}")
	@ResponseBody
	public Page<ActivitiUser> listByPage(@PathVariable Integer page, @PathVariable Integer size) {
		Sort sort = new Sort(Direction.DESC, "contractId");
		Pageable pageable = new PageRequest(page, size, sort);
		return activitiUserRepository.findAll(pageable);
	}

	/**
	 * 本地服务实例的信息
	 * 
	 * @return
	 */
	@RequestMapping("/instance-info")
	@ResponseBody
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}
}
