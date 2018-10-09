package com.hrsystem.salary.entity.DTO;

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
import com.hrsystem.common.sign.Name;
import com.hrsystem.salary.entity.Salary;

import lombok.Data;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: SalaryQueryDTO.java
  *@Date: 2018年10月8日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Data
public class SalaryQueryDTO {
	private Long id;
	private Double salarySum;
	
	@Name("salaryTime")
	@GreaterThanEqual 
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date salaryTimeStart; 
	
	@Name("salaryTime")
	@LessThanEqual  
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date salaryTimeEnd; 
	
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date salaryTime;
	
	@Name("createTime")
	@GreaterThanEqual 
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date createTimeStart; 
	
	@Name("createTime")
	@LessThanEqual  
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date createTimeEnd; 
	
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date createTime;
}
