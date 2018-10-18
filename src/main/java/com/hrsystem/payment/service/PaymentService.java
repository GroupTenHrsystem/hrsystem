package com.hrsystem.payment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.activiti.domain.WorkflowDTO;
import com.hrsystem.activiti.service.IWorkflowService;
import com.hrsystem.payment.entity.Payment;
import com.hrsystem.payment.entity.PaymentDTO;
import com.hrsystem.payment.repository.PaymentRepository;
@Service
@Transactional
public class PaymentService implements IPaymentService{

	@Autowired 
	private PaymentRepository paymentRepository;
	
	@Autowired 
	private IWorkflowService workflowService;
	
	@Override
	public void save(Payment payment) {
		paymentRepository.save(payment);
	}

	@Override
	public void delete(Long id) {
		Payment payment = paymentRepository.findById(id).get();
		if(payment!=null){
			paymentRepository.delete(payment);
		}
	}

	@Override
	public void deleteAll(Long[] ids) {
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		
		List<Payment> payment = (List<Payment>) paymentRepository.findAllById(idLists);
		if(payment!=null) {
			paymentRepository.deleteAll(payment);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Payment findOne(Long id) {
		return paymentRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Payment> findAll(Specification<Payment> spec, Pageable pageable) {
		return paymentRepository.findAll(spec, pageable);
	}

	@Override
	public void startWorkflow(String userId, Long paymentId, Map<String, Object> variables) {
		//1.声明流程实例
			ProcessInstance processInstance = null;
			//2.获取创建好的请假实例
			Payment payment = paymentRepository.findById(paymentId).get();
			if(payment!=null){
				try {
					processInstance = workflowService.startWorkflow(userId, "payment", payment.getId().toString(), variables);
					payment.setProcessStatus(ProcessStatus.APPROVAL);
					payment.setProcessInstanceId(processInstance.getId());
					payment.setStartTime(new Date());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	}

	@Override
	public Page<PaymentDTO> findTodoTasks(String userId, Pageable pageable) {
		List<PaymentDTO> results = null;
		List<WorkflowDTO> workflowLists = workflowService.findTodoTasks(userId);
        // 根据流程的业务ID查询实体并关联
		if(null!=workflowLists) {
			results = new ArrayList<PaymentDTO>();
			for (WorkflowDTO workflow : workflowLists) {
	        	Long businessKey = new Long(workflow.getBusinessKey());
	            if (workflow.getBusinessKey() == null) {
	                continue;
	            }
	            Payment payment = paymentRepository.findById(businessKey).get();
	            if(payment!=null){
	            	PaymentDTO paymentDTO = new PaymentDTO();
	            	BeanUtils.copyProperties(payment, paymentDTO);
	            	BeanUtils.copyProperties(workflow, paymentDTO);
	            	results.add(paymentDTO);
	            }
	        }
		}
		return new PageImpl<PaymentDTO> (results, pageable, null!=results?results.size():0);
	}

	@Override
	public void claim(String taskId, String userId) {
		workflowService.claim(taskId, userId);
	}

	@Override
	public void complete(String taskId, Map<String, Object> variables, Long id) {
		Payment payment = paymentRepository.findById(id).get();
		if(variables.containsKey("price")) {
			payment.setReason(String.valueOf(variables.get("reason")));
			payment.setEndTime(new Date());
		}
		paymentRepository.save(payment);
		workflowService.complete(taskId, variables);
	}

}
