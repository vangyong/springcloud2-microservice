package cn.segema.cloud.contract.controller;

import javax.annotation.Resource;

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

import cn.segema.cloud.contract.domain.Contract;
import cn.segema.cloud.contract.repository.ContractRepository;
import cn.segema.cloud.contract.vo.UserVO;

/**
 * 合同接口
 */
@RestController
public class ContractController {
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private ContractRepository contractRepository;
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	private UserRepository userRepository;

	/**
	 * @param id
	 * @return 合同信息
	 */
	@GetMapping("/{id}")
	public Contract findById(@PathVariable String id) {
		Contract findOne = this.contractRepository.findOne(id);
		//User user = userRepository.findOne("1");
		
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
	public Page<Contract> listByPageable(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "5") Integer size) {
		Sort sort = new Sort(Direction.DESC, "contractId");
		Pageable pageable = new PageRequest(page, size, sort);
		return contractRepository.findAll(pageable);
	}
	
	/**
	 * 直接获取Pageable对象
	 * @param pageable
	 * @return
	 */
	@GetMapping("/listByPageableDefault")
	public Page<Contract> listByPageableDefault(@PageableDefault(value = 15, sort = { "contractId" }, direction = Sort.Direction.DESC) Pageable pageable) {
		return contractRepository.findAll(pageable);
	}
	
	/**
	 * @param id
	 * @return 合同信息
	 */
	@GetMapping("/contractdetail/{id}/{userId}")
	public Contract findContractDetailById(@PathVariable String id,@PathVariable String userId) {
		UserVO userVO = (UserVO)restTemplate.getForObject("http://microservice-system/user/{userId}", UserVO.class, userId);
		Contract findOne = this.contractRepository.findOne(id);
		return findOne;
	}
	

}
