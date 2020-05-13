package cn.segema.cloud.system.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.segema.cloud.system.domain.Role;
import cn.segema.cloud.system.repository.RoleRepository;

/**
 * 角色Controller
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController {
	
	private static Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleRepository roleRepository;

	/**
	   * @param roleId
	   * @return Role信息
	   */
	@GetMapping("/{roleId}")
	public ResponseEntity findById(@PathVariable String roleId) {
		Optional<Role> findOne = this.roleRepository.findById(roleId);
		return new ResponseEntity(findOne.get(),HttpStatus.OK);
	}

	@GetMapping("/list")
	public List<Role> list(Role role, Model model) {
		List<Role> list = roleRepository.findAll();
		return list;
	}

	@PostMapping
	public ResponseEntity add(@RequestBody Role role) {
		if (role.getRoleId() == null || "".equals(role.getRoleId())) {
			role.setRoleId(UUID.randomUUID().toString());
		}
		
		roleRepository.save(role);
		return new ResponseEntity(role,HttpStatus.OK);
	}

	@PutMapping
	public Role edit(Role role) {
		Long a = 2L;
		roleRepository.save(role);
		return role;
	}

	@DeleteMapping("/{roleId}")
	public ResponseEntity delete(@PathVariable String roleId) {
		roleRepository.deleteById(roleId);
		return new ResponseEntity(roleId,HttpStatus.OK);
	}

}
