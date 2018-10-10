package com.hrsystem.performance.entity.DTO;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.performance.entity.PerformanceTemplet;

import lombok.Data;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceDTO.java
  *@Date: 2018年9月27日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Data
public class PerformanceDTO {
	private Long id;
	private String userId;
	private String performanceName;	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date startTime; 
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date endTime;  
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date applyTime;
	private Long cycle;
    private Double selfScore;
    private Double deptLeaderScore;
	private Boolean status=false;
	private Long performanceTempletId;
	private Long staffIds[];
	private ProcessStatus processStatus;//流程状态
	
	 /*销假*/
    private Date realityStartTime;
    private Date realityEndTime;
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
