package com.hrsystem.payment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.hrsystem.common.SessionUtil;
import com.hrsystem.common.specificationBuilder.SpecificationBuilder;
import com.hrsystem.payment.entity.Payment;
import com.hrsystem.payment.entity.PaymentDTO;
import com.hrsystem.payment.entity.PaymentQueryDTO;
import com.hrsystem.payment.service.IPaymentService;

import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.activiti.util.WorkflowVariable;
import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtAjaxResponse;
import com.hrsystem.common.ExtjsPageRequest;

@RestController
@RequestMapping(value="/payment")
public class PaymentController {

	@Autowired
	private IPaymentService paymentService;
	
	@PostMapping
    public ExtAjaxResponse save(HttpSession session,@RequestBody Payment payment) {
		
    	try {
    		String userId = SessionUtil.getUserName(session);
    		if(userId!=null) {
    			payment.setUserId(userId);
    			payment.setProcessStatus(ProcessStatus.NEW);
    			paymentService.save(payment);
    		}
    		return new ExtAjaxResponse(true,"保存成功!");
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return new ExtAjaxResponse(false,"保存失败!");
	    }
    }
	
	@PutMapping(value="{id}")
    public @ResponseBody ExtAjaxResponse update(@PathVariable("id") Long id,@RequestBody Payment payment) {
    	try {
    		Payment entity = paymentService.findOne(id);
			if(entity!=null) {
				BeanUtils.copyProperties(payment, entity);//使用自定义的BeanUtils
				paymentService.save(entity);
			}
    		return new ExtAjaxResponse(true,"更新成功!");
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return new ExtAjaxResponse(false,"更新失败!");
	    }
    }
	
	@DeleteMapping(value="{id}")
    public @ResponseBody ExtAjaxResponse delete(@PathVariable("id") Long id) {
    	try {
    		Payment entity = paymentService.findOne(id);
			if(entity!=null) {
				paymentService.delete(id);
			}
    		return new ExtAjaxResponse(true,"删除成功!");
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return new ExtAjaxResponse(false,"删除失败!");
	    }
    }
	
	@PostMapping("/deletes")
	public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) 
	{
		try {
			if(ids!=null) {
				paymentService.deleteAll(ids);
			}
			return new ExtAjaxResponse(true,"批量删除成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"批量删除失败！");
		}
	}
	
	@GetMapping
    public Page<Payment> findPaymentByUserId(PaymentQueryDTO paymentQueryDTO,HttpSession session,ExtjsPageRequest pageable) 
	{
		Page<Payment> page;
		String userId = SessionUtil.getUserName(session);
		if(userId!=null) {
			paymentQueryDTO.setUserId(SessionUtil.getUserName(session));
			page = paymentService.findAll(SpecificationBuilder.buildSpecification(paymentQueryDTO), pageable.getPageable());
		}else {
			page = new PageImpl<Payment>(new ArrayList<Payment>(),pageable.getPageable(),0);
		}
		return page;
    }
	
	
	
	@RequestMapping(value = "/start")
    public @ResponseBody ExtAjaxResponse start(@RequestParam(name="id") Long paymentId,HttpSession session,double price) {
    	try {
    		Payment entity = paymentService.findOne(paymentId);
    		String userId = SessionUtil.getUserName(session);
    		//double price = entity.getPrice();
    		System.out.println(price);
    		Map<String, Object> variables = new HashMap<String, Object>();
    		variables.put("payLeader", "financeClerk");
    		variables.put("paymanagerLeader", "financeManager");
    		variables.put("applyUserId", userId);
    		variables.put("price", price);
    		paymentService.startWorkflow(userId,paymentId, variables);
    		return new ExtAjaxResponse(true,"操作成功!");
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return new ExtAjaxResponse(false,"操作失败!");
	    }
    }
	
	@RequestMapping(value = "/tasks")
    public @ResponseBody Page<PaymentDTO> findTodoTasks(HttpSession session,ExtjsPageRequest pageable) {
		Page<PaymentDTO> page = new PageImpl<PaymentDTO>(new ArrayList<PaymentDTO>(), pageable.getPageable(), 0);
    	try {
    		page = paymentService.findTodoTasks(SessionUtil.getUserName(session), pageable.getPageable());
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
    	
    	return page;
    }
	
	@RequestMapping(value = "claim/{id}")
    public @ResponseBody ExtAjaxResponse claim(@PathVariable("id") String taskId, HttpSession session) {
    	try{
    		paymentService.claim(taskId, SessionUtil.getUserName(session));
	    	return new ExtAjaxResponse(true,"任务签收成功!");
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return new ExtAjaxResponse(false,"任务签收失败!");
	    }
    }
	 
	@RequestMapping(value = "complete/{taskId}")
    public @ResponseBody ExtAjaxResponse complete(@PathVariable("taskId") String taskId, WorkflowVariable var,Long id) {
    	try{
    		Map<String, Object> variables = var.getVariableMap();
    		paymentService.complete(taskId, variables,id);
	    	return new ExtAjaxResponse(true,"审批成功!");
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return new ExtAjaxResponse(false,"审批失败!");
	    }
    }

}
