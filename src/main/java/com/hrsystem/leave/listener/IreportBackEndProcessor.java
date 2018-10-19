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
import com.hrsystem.leave.domain.Leave;
import com.hrsystem.leave.service.ILeaveService;

@Component
@Transactional
public class IreportBackEndProcessor implements TaskListener{

	private static final long serialVersionUID = -8360605214753688651L;

	@Autowired
    private ILeaveService leaveService;

    @Autowired
    private RuntimeService runtimeService;
    
    public void notify(DelegateTask delegateTask) {
    	
        String processInstanceId = delegateTask.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        Leave leave = leaveService.findOne(new Long(processInstance.getBusinessKey()));

        Object realityStartTime = delegateTask.getVariable("realityStartTime");
        leave.setRealityStartTime((Date) realityStartTime);
        Object realityEndTime = delegateTask.getVariable("realityEndTime");
        leave.setRealityEndTime((Date) realityEndTime);
        
        leave.setProcessStatus(ProcessStatus.COMPLETE);
        //leaveService.save(leave);
    }
}
