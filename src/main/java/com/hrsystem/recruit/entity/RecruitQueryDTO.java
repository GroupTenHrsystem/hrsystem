package com.hrsystem.recruit.entity;

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

import lombok.Data;

@Data
public class RecruitQueryDTO 
{
	@Like
	private String departmentname;
	
	@Like
	private String position;
	
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date startTime;
	
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date endTime;

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
	

}
