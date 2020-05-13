package cn.segema.cloud.flowable.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowableService {

	// 注入为我们自动配置好的服务
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private RepositoryService repositoryService;
	
	
	// 开始流程，传入申请者的id以及公司的id
	public ProcessInstance startProcess( Long personId, Long compId){
	 Map<String, Object> variables = new HashMap<String, Object>();
	 variables.put("personId", personId);
	 variables.put("compId", compId);
	 return runtimeService.startProcessInstanceByKey("joinProcess", variables);
	}

	// 获得某个人的任务别表
	public List<org.flowable.task.api.Task> getTasks(String assignee) {
		return taskService.createTaskQuery().taskCandidateUser(assignee).list();
	}

	// 完成任务
	public void completeTasks(Boolean joinApproved, String taskId) {
		Map<String, Object> taskVariables = new HashMap<String, Object>();
		taskVariables.put("joinApproved", joinApproved);
		taskService.complete(taskId, taskVariables);
	}

}
