package com.hrsystem.leave.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.leave.entity.Leave;
import com.hrsystem.leave.entity.LeaveDTO;



/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: ILeaveService.java
  *@Date: 2018年9月27日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
public interface ILeaveService 
{
	//请假业务
	public void save(Leave leave);
	public void delete(Long id);
	public void deleteAll(Long[] ids);
	public Leave findOne(Long id);
	
	public Page<Leave> findAll(Specification<Leave> spec, Pageable pageable);
	//可扩展:高级查询
	
	//流程业务
	//1.启动流程
	public void startWorkflow(String userId,Long leaveId, Map<String, Object> variables);//findOne(Long id);
	//2.查询流程任务
	public Page<LeaveDTO> findTodoTasks(String userId, Pageable pageable);
	//3.签收流程任务
	public void claim(String taskId,String userId);
	//4.完成流程任务
	public void complete(String taskId, Map<String, Object> variables);  
	//5.结束(终止)流程实例
	//6.查询运行中的流程
	//public Page<LeaveDTO> findRunningProcessInstaces(Page<Leave> page, int[] pageParams);
	//7.查询已结束的流程
	//public Page<LeaveDTO> findFinishedProcessInstaces(Page<Leave> page, int[] pageParams);
	//8.查询流程定义对象
	//protected ProcessDefinition getProcessDefinition(String processDefinitionId);
}
