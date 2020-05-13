package cn.segema.cloud.system.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.system.domain.User;
import cn.segema.cloud.system.repository.UserRepository;
import cn.segema.cloud.system.vo.UserPersonalVO;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	/**
	 * @param userId
	 * @return user信息
	 */
	@GetMapping("/{userId}")
	public ResponseEntity findById(@PathVariable String userId) {
		Optional<User> findOne = this.userRepository.findById(userId);
		return new ResponseEntity(findOne.get(),HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity list(User user) {
		List<User> userList = userRepository.findAll();
		return new ResponseEntity(user,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity add(@RequestBody User user) {
		if (user.getUserId() == null || "".equals(user.getUserId())) {
			user.setUserId(UUID.randomUUID().toString());
		}
		userRepository.save(user);
		return new ResponseEntity(user,HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity edit(@RequestBody User user) {
		// Role oldRole = roleRepository.getOne(role.getRoleId());
		// BeanUtils.copyProperties(role, oldRole);
		userRepository.save(user);
		return new ResponseEntity(user,HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity delete(@PathVariable String roleId) {
		userRepository.deleteById(roleId);
		return new ResponseEntity(roleId,HttpStatus.OK);
	}

	@GetMapping("/listUserPersonalByUserName/{userName}")
	public ResponseEntity listUserPersonalByUserName(@PathVariable String userName) {
		List<UserPersonalVO> userList = userRepository.findUserPersonalByUserName(userName);
		return new ResponseEntity(userList,HttpStatus.OK);
	}

	@GetMapping("/listByPage")
	public ResponseEntity listByPage() {
		Sort sort = Sort.by(Direction.DESC, "userId");
		Pageable pageable = PageRequest.of(0, 30, sort);
		Page<User> page = userRepository.findAll(pageable);
		return new ResponseEntity(page,HttpStatus.OK);
	}
}
