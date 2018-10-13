package com.hrsystem.salary.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.user.entity.Staff;

import lombok.Data;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: t_salary.java
  *@Date: 2018年9月28日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Data
@Entity
@Table(name = "t_salary")
@NamedEntityGraph(name = "Salary.withStaff", attributeNodes = {@NamedAttributeNode("staff"),@NamedAttributeNode("salaryStandard")})
//	使用了@NamedEntityGraph注解，findAll合为一条HQL，避免JPA N+1 问题
public class Salary {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date salaryStarTime; 
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date salaryEndTime; 
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date createTime; 
	private Double salarySum;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private SalaryStandard salaryStandard;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Staff staff;
}
