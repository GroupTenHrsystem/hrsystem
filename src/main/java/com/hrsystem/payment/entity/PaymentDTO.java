package com.hrsystem.payment.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.activiti.domain.ProcessStatus;

import lombok.Data;

@Data
public class PaymentDTO {

	private Long id;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date startTime;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date endTime;
	private String reason;
	private String backReason;
	
	private Double price;
	
	private ProcessStatus processStatus;
    private String userId;
    
    /**------------流程数据--------------**/
    /*任务*/
    private String taskId;
    private String taskName;
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date   taskCreateTime;
    private String assignee;
    private String taskDefinitionKey;
    /*流程实例*/
    private String processInstanceId;
    /*流程图定义*/
    private String processDefinitionId;
    private boolean suspended;
    private int version;
	
}
