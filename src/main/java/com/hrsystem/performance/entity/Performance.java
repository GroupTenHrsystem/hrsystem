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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.Specification;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.user.entity.Staff;

import lombok.Data;

@Data
@Entity
@Table(name = "t_performance")
@NamedEntityGraph(name = "Performance.withStaff", attributeNodes = {@NamedAttributeNode("staff"),@NamedAttributeNode("performanceTemplet")})
public class Performance implements Serializable {
	
		// 查找performance和staff的视图
		public interface PerformanceAndStaffView{};
		// 视图2 继承视图1
		public interface TwoView extends PerformanceAndStaffView{};
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@JsonView(PerformanceAndStaffView.class)
		private Long id;
		
		@JsonView(PerformanceAndStaffView.class)
		private String performanceName;	
		
		@JsonView(PerformanceAndStaffView.class)
		@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
		private Date startTime; 
		
		@JsonView(PerformanceAndStaffView.class)
		@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
		private Date endTime; 
		
		
		@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
		private Date realityStartTime;
		
		@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	    private Date realityEndTime;
		
		@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
		private Date applyTime;
		
		@JsonView(PerformanceAndStaffView.class)
		private Long cycle;
		
		private Boolean status = false;				//true显示，flase不显示
		
		//工作流
		@Enumerated(EnumType.STRING)
		private ProcessStatus processStatus;//流程状态
	    //工作流程数据字段
	    private String userId;//启动流程的用户ID
	    //流程实例Id：用于关联流程引擎相关数据没有启动流程之前为""
	    private String processInstanceId;
	    
	   // @JsonIgnore
		@ManyToOne(cascade=CascadeType.ALL) //	使用了@NamedEntityGraph注解，避免JPA N+1 问题
		private PerformanceTemplet performanceTemplet;
		
	   // @JsonIgnore
		@ManyToOne(cascade=CascadeType.ALL)	//	使用了@NamedEntityGraph注解，避免JPA N+1 问题
		private Staff staff;
}
