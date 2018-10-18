package com.hrsystem.resume.listener;

import java.util.Date;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.resume.entity.Resume;
import com.hrsystem.resume.service.IResumeService;

@Component
@Transactional
public class LastAuditEndProcessor implements TaskListener {

	private static final long serialVersionUID = -8360605214753688651L;

	@Autowired
    private IResumeService resumeService;

    @Autowired
    private RuntimeService runtimeService;
    
    public void notify(DelegateTask delegateTask) {
    	
        String processInstanceId = delegateTask.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        Resume resume = resumeService.findOne(new Long(processInstance.getBusinessKey()));
        resume.setCompleteTime(new Date()); 
        resume.setProcessStatus(ProcessStatus.COMPLETE);
        //leaveService.save(leave);
    }
	
}
