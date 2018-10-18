package com.hrsystem.payment.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.payment.entity.Payment;
import com.hrsystem.payment.entity.PaymentDTO;


public interface IPaymentService {

	//请假业务
	public void save(Payment payment);
	public void delete(Long id);
	public void deleteAll(Long[] ids);
	public Payment findOne(Long id);
	
	public Page<Payment> findAll(Specification<Payment> spec, Pageable pageable);
	//可扩展:高级查询
	
	//流程业务
	//1.启动流程
	public void startWorkflow(String userId,Long paymentId, Map<String, Object> variables);//findOne(Long id);
	//2.查询流程任务
	public Page<PaymentDTO> findTodoTasks(String userId, Pageable pageable);
	//3.签收流程任务
	public void claim(String taskId,String userId);
	//4.完成流程任务
	public void complete(String taskId, Map<String, Object> variables,Long id); 
}
