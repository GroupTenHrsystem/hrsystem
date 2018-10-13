package com.hrsystem.performance.entity.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.hrsystem.common.sign.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.performance.entity.Performance;


import lombok.Data;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceQueryDTO.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Data
public class PerformanceQueryDTO {
	private Long id;
	
	private String userId;
	
	@Like
	private String performanceName;	
	
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date startTime;
	
	@Name("startTime")
	@GreaterThanEqual 
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date startTimeStart; 
	
	@Name("startTime")
	@LessThanEqual 
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date startTimeEnd; 
	
	@Name("endTime")
	@GreaterThanEqual 
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date endTimeStart;  
	
	@Name("endTime")
	@LessThanEqual 
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date endTimeEnd;

	private Double selfScore;
	private Double deptLeaderScore;
	private Double resultScore;
	//private Long cycle;
	private Boolean status=true;

	private Long performanceTempletId;
}
