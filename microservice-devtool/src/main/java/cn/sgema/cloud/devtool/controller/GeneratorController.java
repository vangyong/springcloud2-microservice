package cn.sgema.cloud.devtool.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sgema.cloud.devtool.config.DevtoolProperties;
import cn.sgema.cloud.devtool.domain.DemoUser;
import cn.sgema.cloud.devtool.domain.Generator;
import cn.sgema.cloud.devtool.mapper.UserDao;
import cn.sgema.cloud.devtool.service.GeneratorService;
import cn.sgema.cloud.devtool.service.TableService;

import java.util.HashMap;

@RestController
@Api(value = "/generator", tags = "代码生成器接口")
@RequestMapping("/generator")
public class GeneratorController {

//	@Autowired
//	private TableRepository tableRepository;

	@Autowired
	private GeneratorService generateService;

	@Autowired
	private DevtoolProperties devtoolsProperties;
	
	@Autowired
	private TableService tableService;
	
	@Autowired
	private UserDao userDao;
	
    @Value("${spring.datasource.db-name}")
    private String dbName;

	@GetMapping("/env")
	@ApiOperation("获取代码生成器配置")
	public ResponseEntity blackboard() {
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("tables", tableService.getAllTables(dbName));
		hashMap.put("params", devtoolsProperties);
		return new ResponseEntity(hashMap,HttpStatus.OK);
	}

	@ApiOperation("生成代码")
	@PostMapping("/generate")
	public Object generate(Generator generateTask) {
		generateService.generate(generateTask);
		return new ResponseEntity(null,HttpStatus.OK);
	}
	

	@ApiOperation("测试")
	@GetMapping("/test")
	public Object test() {
		DemoUser demoUser = userDao.selectUserByName("test2");
		return new ResponseEntity(demoUser,HttpStatus.OK);
	}
}
