package com.hrsystem.resume.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.activiti.domain.ProcessStatus;

import lombok.Data;

@Data
public class ResumeDTO {

	private Long id;
	private String name;
	private String employBranch;
	private String estimate;   //评价
	private String interviewer;  //面试官
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date interviewTime;
	
	
	private ProcessStatus processStatus;  //流程状态
	private String userId;  
	
	private String resumeBackReason;
	private Double firstAuditScore;  //一面分数
	private String firstBackReason;  //一面退回原因
	private Double lastAuditScore;  //二面分数
	private String lastBackReason;  //二面退回原因
	
	
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
