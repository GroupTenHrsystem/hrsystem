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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.user.entity.Staff;

import lombok.Data;

@Data
@Entity
@Table(name = "t_performance")
public class Performance implements Serializable {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String performanceName;	
		@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
		private Date startTime; 
		@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
		private Date endTime;  
		private Long cycle;
		private Boolean status=false;
		@ManyToOne(cascade=CascadeType.ALL) 
		PerformanceTemplet performanceTemplet;
		@ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "performance_staff",
		joinColumns = {@JoinColumn(name = "performance_id")},
		inverseJoinColumns = {@JoinColumn(name = "employee_id")}) 
		private List<Staff> staff;
}
