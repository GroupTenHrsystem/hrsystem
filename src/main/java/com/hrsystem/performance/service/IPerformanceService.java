package com.hrsystem.performance.service;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: IPerformanceService.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.DTO.PerformanceDTO;


public interface IPerformanceService {
	public Performance findPerformanceById(Long id);
	 
	 public void insertPerformance(Performance performance) ;
	 
	 public void deletePerformance(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<Performance> findAll(Specification<Performance> spec, Pageable pageable);
	 
	 public List<Performance> getPerformanceByPerformanceTempletId(Long id);
	 
	 public Page<Performance> getMyPerformanceByStaffName(String userId, Pageable pageable);
	//流程业务
	//1.启动流程
	public void startWorkflow(String userId,Long performanceId, Map<String, Object> variables);//findOne(Long id);
	//2.查询流程任务
	public Page<PerformanceDTO> findTodoTasks(String userId, Pageable pageable);
	//3.签收流程任务
	public void claim(String taskId,String userId);
	//4.完成流程任务
	public void complete(String taskId, Map<String, Object> variables);  
}
