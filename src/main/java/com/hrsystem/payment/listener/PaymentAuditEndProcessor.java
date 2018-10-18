package com.hrsystem.payment.listener;

import java.util.Date;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.payment.entity.Payment;
import com.hrsystem.payment.service.IPaymentService;

@Component
@Transactional
public class PaymentAuditEndProcessor implements TaskListener {

	private static final long serialVersionUID = -8360605214753688651L;

	@Autowired
    private IPaymentService paymentService;

    @Autowired
    private RuntimeService runtimeService;
    
    public void notify(DelegateTask delegateTask) {
    	
        String processInstanceId = delegateTask.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        Payment payment = paymentService.findOne(new Long(processInstance.getBusinessKey()));
        payment.setEndTime(new Date());
        payment.setProcessStatus(ProcessStatus.COMPLETE);
        //leaveService.save(leave);
    }
}
