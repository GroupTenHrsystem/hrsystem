package com.hrsystem.leave.listener;

import java.util.Date;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.leave.entity.Leave;
import com.hrsystem.leave.service.ILeaveService;



/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: AfterModifyApplyContentProcessor.java
  *@Date: 2018年9月27日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Component
@Transactional
public class AfterModifyApplyContentProcessor implements TaskListener {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ILeaveService leaveService;

    @Autowired
    private RuntimeService runtimeService;
    
    public void notify(DelegateTask delegateTask) {
        String processInstanceId = delegateTask.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        Leave leave = leaveService.findOne(new Long(processInstance.getBusinessKey()));
        if(delegateTask.getVariable("reApply").toString() =="true") {
            leave.setLeaveType((String) delegateTask.getVariable("leaveType"));
            leave.setStartTime((Date) delegateTask.getVariable("startTime"));
            leave.setEndTime((Date) delegateTask.getVariable("endTime"));
            leave.setReason((String) delegateTask.getVariable("reason"));
        }else {
        	leave.setProcessStatus(ProcessStatus.CANCEL);
        }
 

        //leaveService.save(leave);
    }

}

