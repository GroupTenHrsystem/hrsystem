package com.hrsystem.performance.service;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceService.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.activiti.domain.WorkflowDTO;
import com.hrsystem.activiti.service.IWorkflowService;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.DTO.PerformanceDTO;
import com.hrsystem.performance.repository.PerformanceRepository;
@Service
public class PerformanceService implements IPerformanceService{
	@Autowired
	PerformanceRepository performanceRepository;
	@Autowired 
	private IWorkflowService workflowService;
	public Performance findPerformanceById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Performance> performance = performanceRepository.findById(id);
		    if (!performance.isPresent()) {
		        return null;
		    }
		    return performance.get();
	}

	@Override
	public void insertPerformance(Performance Performance) {
		// TODO Auto-generated method stub
		performanceRepository.save(Performance);     
	}

	@Override
	public void deletePerformance(Long id) {
		// TODO Auto-generated method stub
		performanceRepository.deleteById(id);
	}
 
	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));	
		List<Performance> Performances = (List<Performance>) performanceRepository.findAllById(idLists);
		performanceRepository.deleteAll(Performances);
	}

	@Override
	public Page<Performance> findAll(Specification<Performance> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return performanceRepository.findAll(spec, pageable);
	}
	
	@Override
	 public List<Performance> getPerformanceByPerformanceTempletId(Long id){
		return performanceRepository.getPerformanceByPerformanceTempletId(id);
	 }
	
	/*----------------------------------------------流程业务--------------------------------------------*/
	 /**
    * 开始请假流程
    *
    * @param userId 用户ID
    * @param pageable 分页条件
    * @return
    */
	@Override
	public void startWorkflow(String userId ,Long performanceId, Map<String, Object> variables) 
	{
		//1.声明流程实例
		ProcessInstance processInstance = null;
		//2.获取创建好的请假实例
		Performance performance = performanceRepository.findById(performanceId).get();
		if(performance!=null){
			try {
				processInstance = workflowService.startWorkflow(userId, "performance", performance.getId().toString(), variables);
				performance.setProcessStatus(ProcessStatus.APPROVAL);
				performance.setProcessInstanceId(processInstance.getId());
				performance.setApplyTime(new Date());
				performanceRepository.save(performance);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	 /**
    * 查询待办任务
    *
    * @param userId 用户ID
    * @param pageable 分页条件
    * @return
    */
	@Override
	public Page<PerformanceDTO> findTodoTasks(String userId, Pageable pageable) 
	{
		List<PerformanceDTO> results = null;
		List<WorkflowDTO> workflowLists = workflowService.findTodoTasks(userId);
       // 根据流程的业务ID查询实体并关联
		if(null!=workflowLists) {
			results = new ArrayList<PerformanceDTO>();
			for (WorkflowDTO workflow : workflowLists) {
	        	Long businessKey = new Long(workflow.getBusinessKey());
	            if (workflow.getBusinessKey() == null) {
	                continue;
	            }
	            Performance performance = performanceRepository.findById(businessKey).get();
	            if(performance!=null){
	            	PerformanceDTO performanceDTO = new PerformanceDTO();
	            	BeanUtils.copyProperties(performance, performanceDTO);
	            	BeanUtils.copyProperties(workflow, performanceDTO);
	            	results.add(performanceDTO);
	            }
	        }
		}
		return new PageImpl<PerformanceDTO> (results, pageable, null!=results?results.size():0);
	}

   /**
    * 签收流程任务
    *
    * @param taskId 任务ID
    * @param userId 签收人用户ID
    * @return
    */
	public void claim(String taskId, String userId) {
		workflowService.claim(taskId, userId);
	}

	 /**
    * 完成流程任务
    *
    * @param taskId 任务ID
    * @param variables 流程变量
    * @return
    */
	public void complete(String taskId, Map<String, Object> variables) {
		workflowService.complete(taskId, variables);
	}
}
