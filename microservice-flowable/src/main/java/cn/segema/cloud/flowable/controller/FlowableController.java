package cn.segema.cloud.flowable.controller;

import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.flowable.service.FlowableService;

@RestController
@RequestMapping(value = "/flowable")
public class FlowableController {
	@Autowired
	private FlowableService flowableService;

	@GetMapping(value = "/startProcess/{personId}/{compId}")
	public ProcessInstance startProcess(@PathVariable Long personId,@PathVariable Long compId) {
		ProcessInstance processInstance = flowableService.startProcess(personId, compId);
		return processInstance;
	}

}
