package com.hrsystem.performance.entity;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceTemplet.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
@Entity
@Table(name = "performance_templet")
public class PerformanceTemplet implements Serializable {
	//种类 	考评内容 	考评指标 	考评分值 	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String kind;
	private String name;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date startTime; 
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date endTime;  
	private String performanceIndex;
	private String  weighting;
	private Boolean status;
}
