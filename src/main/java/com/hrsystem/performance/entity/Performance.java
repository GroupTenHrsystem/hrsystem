package com.hrsystem.performance.entity;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: Performance.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.user.entity.Staff;

import lombok.Data;

@Data
@Entity
@Table(name = "t_performance")
@NamedEntityGraph(name = "Performance.withStaff", attributeNodes = {@NamedAttributeNode("staff"),@NamedAttributeNode("performanceTemplet")})
//	使用了@NamedEntityGraph注解，findAll合为一条HQL，避免JPA N+1 问题
public class Performance implements Serializable {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String performanceName;
		@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
		private Date startTime;
		@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
		private Date endTime;

		@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
		private Date applyTime;
		private Date completeTime;
		private Double selfScore;
		private Double deptLeaderScore;
		private String selfScoreReason;
		private String deptLeaderScoreReason;
		private String confirmResult;
		private Boolean status = false;				//true显示，flase不显示
//		private Long cycle;

		
		//工作流
		@Enumerated(EnumType.STRING)
		private ProcessStatus processStatus;//流程状态
	    //工作流程数据字段
	    private String userId;//启动流程的用户ID
	    //流程实例Id：用于关联流程引擎相关数据没有启动流程之前为""
	    private String processInstanceId;

		@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)			//	使用了@NamedEntityGraph注解，findAll合为一条HQL，避免JPA N+1 问题
		private PerformanceTemplet performanceTemplet;
		@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)			//	使用了@NamedEntityGraph注解，findAll合为一条HQL，避免JPA N+1 问题
		private Staff staff;
}
