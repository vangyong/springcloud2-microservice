package cn.segema.cloud.performance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.segema.cloud.performance.domain.Responsibility;
import cn.segema.cloud.performance.repository.ResponsibilityRepository;
import cn.segema.cloud.performance.vo.ResponsibilityVO;

/**
 * 合同接口
 */
@RestController
public class ResponsibilityController {
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private ResponsibilityRepository responsibilityRepository;
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * @param id
	 * @return 合同信息
	 */
	@GetMapping("/{id}")
	public Responsibility findById(@PathVariable String id) {
		Responsibility findOne = this.responsibilityRepository.findOne(id);
		return findOne;
	}

	/**
	 * 本地服务实例的信息
	 * 
	 * @return
	 */
	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}

	/**
	 * 通过参数生成Pageable对象
	 * @param page
	 * @param size
	 * @return
	 */
	@GetMapping("/listByPageable")
	public Page<Responsibility> listByPageable(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "5") Integer size) {
		Sort sort = new Sort(Direction.DESC, "contractId");
		Pageable pageable = new PageRequest(page, size, sort);
		return responsibilityRepository.findAll(pageable);
	}
	
	/**
	 * 直接获取Pageable对象
	 * @param pageable
	 * @return
	 */
	@GetMapping("/listByPageableDefault")
	public Page<Responsibility> listByPageableDefault(@PageableDefault(value = 15, sort = { "contractId" }, direction = Sort.Direction.DESC) Pageable pageable) {
		return responsibilityRepository.findAll(pageable);
	}
	
	/**
	 * @param id
	 * @return 合同信息
	 */
	@GetMapping("/contractdetail/{id}/{userId}")
	public Responsibility findContractDetailById(@PathVariable String id,@PathVariable String userId) {
		ResponsibilityVO userVO = (ResponsibilityVO)restTemplate.getForObject("http://microservice-system/user/{userId}", ResponsibilityVO.class, userId);
		Responsibility findOne = this.responsibilityRepository.findOne(id);
		return findOne;
	}
	

}
