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
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date interviewTime;
	
	
	private ProcessStatus processStatus;  //流程状态
	private String userId;  
	
	private String resumeBackReason;
	private Double firstAuditScore;  //一面分数
	private String firstBackReason;  //一面退回原因
	private Double lastAuditScore;  //二面分数
	private String lastBackReason;  //二面退回原因
	
	private String firstarr;  //一面面试官
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date firstTime;   //一面时间
	private String lastarr;   //二面面试官
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date lastTime;   //二面时间
	
	
	/**------------流程数据--------------**/
    /*任务*/
    private String taskId;
    private String taskName;
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
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
