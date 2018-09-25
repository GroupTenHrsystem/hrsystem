package com.hrsystem.performance.entity;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: Performance.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "performance")
public class Performance implements Serializable {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String performanceName;	
		private Date startTime; 
		private Date endTime;  
		private Long cycle;
		private Boolean status=false;
		@ManyToOne(cascade=CascadeType.ALL)
		PerformanceTemplet performanceTemplet;
}
