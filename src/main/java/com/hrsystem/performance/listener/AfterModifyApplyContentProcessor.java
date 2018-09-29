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
 * 调整请假内容处理器
 */
@Component
@Transactional
public class AfterModifyApplyContentProcessor implements TaskListener {

    private static final long serialVersionUID = 1L;

    @Autowired
    private IPerformanceService performanceService;

    @Autowired
    private RuntimeService runtimeService;
    
    public void notify(DelegateTask delegateTask) {
        String processInstanceId = delegateTask.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        Performance performance = performanceService.findPerformanceById(new Long(processInstance.getBusinessKey()));
        if(delegateTask.getVariable("reApply").toString() =="true") {
        	performance.setStartTime((Date) delegateTask.getVariable("startTime"));
        	performance.setEndTime((Date) delegateTask.getVariable("endTime"));
        }else {
        	performance.setProcessStatus(ProcessStatus.CANCEL);
        }
 

        //leaveService.save(leave);
    }

}
