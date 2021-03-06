package com.hrsystem.performance.listener;


import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.service.IPerformanceService;

import java.util.Date;

/**
 * 销假后处理器
 * <p>设置销假时间</p>
 * <p>使用Spring代理，可以注入Bean，管理事物</p>
 * bean  id=reportBackEndProcessor
 */
@Component
@Transactional
public class ReportBackEndProcessor implements TaskListener 
{
	private static final long serialVersionUID = -8360605214753688651L;

	@Autowired
    private IPerformanceService performanceService;

    @Autowired
    private RuntimeService runtimeService;
    
    public void notify(DelegateTask delegateTask) {
    	
        String processInstanceId = delegateTask.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        Performance performance = performanceService.findPerformanceById(new Long(processInstance.getBusinessKey()));

//        Object realityStartTime = delegateTask.getVariable("realityStartTime");
//        performance.setRealityStartTime((Date) realityStartTime);
//        Object realityEndTime = delegateTask.getVariable("realityEndTime");
//        performance.setRealityEndTime((Date) realityEndTime);
        Object confirmResult = delegateTask.getVariable("confirmResult");
        boolean flag = (boolean)confirmResult;
        if(flag) {
        	Double selfScore = performance.getSelfScore();
        	Double deptLeaderScore = performance.getDeptLeaderScore();
        	Double selfWeight = performance.getPerformanceTemplet().getSelfWeighting();
        	Double deptLeaderWeighting = performance.getPerformanceTemplet().getDeptLeaderWeighting();
        	Double resultScore = selfScore * selfWeight + deptLeaderScore * deptLeaderWeighting;
        	performance.setResultScore(resultScore);
            performance.setProcessStatus(ProcessStatus.COMPLETE);
        }
        //leaveService.save(leave);
    }
}
