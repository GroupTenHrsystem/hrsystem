package com.hrsystem.activiti.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class WorkflowDTO 
{
	 /*任务*/
    private String taskId;
    private String taskName;
    private Date   taskCreateTime;
    private String assignee;
    private String taskDefinitionKey;
    /*流程实例*/
    private String processInstanceId;
    /*流程图定义*/
    private String processDefinitionId;
    private boolean suspended;
    private int version;
    
    private String businessKey;
    

	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	public Date getTaskCreateTime() {
		return taskCreateTime;
	}
}
