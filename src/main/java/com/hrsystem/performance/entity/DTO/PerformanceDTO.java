package com.hrsystem.performance.entity.DTO;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	private String performanceName;	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date startTime; 
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date endTime;  
	private Long cycle;
	private Boolean status=false;
	private Long performanceTempletId;
	private Long staffIds[];
}
