package cn.segema.cloud.flowable.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.flowable.domain.FlowableUser;
import cn.segema.cloud.flowable.repository.FlowableUserRepository;

@RestController
public class FlowableUserController {
	@Autowired
	private FlowableUserRepository activitiUserRepository;

	/**
	 * @param userId
	 * @return user信息
	 */
	@GetMapping("/{userId}")
	public ResponseEntity findById(@PathVariable Integer userId) {
		Optional<FlowableUser> findOne = this.activitiUserRepository.findById(userId);
		return new ResponseEntity(findOne.isPresent() ? findOne.get() : null, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity list(FlowableUser user) {
		List<FlowableUser> userList = activitiUserRepository.findAll();
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity add(FlowableUser user) {
		activitiUserRepository.save(user);
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity edit(FlowableUser user) {
		// Role oldRole = roleRepository.getOne(role.getRoleId());
		// BeanUtils.copyProperties(role, oldRole);
		activitiUserRepository.save(user);
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity delete(@PathVariable Integer userId) {
		activitiUserRepository.deleteById(userId);
		return new ResponseEntity(userId, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/listByUserName/{userName}") public List<UserPersonalVO>
	 * listByUserName(@PathVariable String userName) { List<UserPersonalVO> userList
	 * = userRepository.findByUserName(userName); return userList; }
	 */

	@GetMapping("/listByPage/{page}/{size}")
	public ResponseEntity listByPage(@PathVariable Integer page, @PathVariable Integer size) {
		Sort sort = Sort.by(Direction.DESC, "contractId");
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<FlowableUser> list = activitiUserRepository.findAll(pageable);
		return new ResponseEntity(list, HttpStatus.OK);
	}
}
