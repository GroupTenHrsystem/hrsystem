package com.hrsystem.performance.entity.DTO;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceTempletQueryDTO.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.common.sign.GreaterThanEqual;
import com.hrsystem.common.sign.LessThanEqual;
import com.hrsystem.common.sign.Like;
import com.hrsystem.common.sign.Name;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.PerformanceTemplet;

import lombok.Data;
@Data
public class PerformanceTempletQueryDTO 
{
	@Like
	private String kind;
	
	@Like
	private String name;
	
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
	
	@Like
	private String performanceIndex;
	
	private String  weighting;

	private Boolean status=true;
	
}
