package cn.segema.cloud.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.segema.cloud.demo.domain.DemoRole;
import cn.segema.cloud.demo.repository.RoleRepository;

/**
 * 角色Controller
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	private RoleRepository roleRepository;

	/**
	 * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
	 * 
	 * @RequestMapping(value = "/id", method = RequestMethod.GET)
	 *                       类似的注解还有@PostMapping等等
	 * @param id
	 * @return Role信息
	 */
	@GetMapping("/{id}")
	public DemoRole findById(@PathVariable String id) {
		Optional<DemoRole> findOne = this.roleRepository.findById(id);
		return findOne.get();
	}

	@GetMapping("/list")
	public List<DemoRole> list(DemoRole role, Model model) {
		List<DemoRole> list = roleRepository.findAll();
		return list;
	}

	@PostMapping("/add")
	public DemoRole add(DemoRole role, Model model) {
		if (role.getRoleId() == null || "".equals(role.getRoleId())) {
			role.setRoleId(UUID.randomUUID().toString());
		}
		roleRepository.save(role);
		return role;
	}

	@RequestMapping(value = "edit")
	public DemoRole edit(DemoRole role, Model model) {
		Long a = 2L;

		roleRepository.save(role);
		return role;
	}

	@RequestMapping(value = "delete")
	public DemoRole delete(DemoRole role) {
		roleRepository.delete(role);
		return role;
	}

}
