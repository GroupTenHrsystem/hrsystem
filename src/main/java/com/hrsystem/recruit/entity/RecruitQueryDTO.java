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

import com.fasterxml.jackson.annotation.JsonFormat;

public class RecruitQueryDTO 
{
	private String departmentname;
	
	private String position;
	private Long planNum;
	private float salary;
	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date startTime;
	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date endTime;
	
	private String postdesc;
	private String demand;
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Long getPlanNum() {
		return planNum;
	}
	public void setPlanNum(Long planNum) {
		this.planNum = planNum;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getPostdesc() {
		return postdesc;
	}
	public void setPostdesc(String postdesc) {
		this.postdesc = postdesc;
	}
	public String getDemand() {
		return demand;
	}
	public void setDemand(String demand) {
		this.demand = demand;
	}
	
	@SuppressWarnings({ "serial"})
	public static Specification<Recruit> getWhereClause(final RecruitQueryDTO recruitQueryDTO) {
		return new Specification<Recruit>() {
			@Override
			public Predicate toPredicate(Root<Recruit> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			
				List<Predicate> predicate = new ArrayList<>();
				
				if (StringUtils.isNotBlank(recruitQueryDTO.getDepartmentname())) {
					predicate.add(criteriaBuilder.like(root.get("departmentname").as(String.class),
							"%" + recruitQueryDTO.getDepartmentname() + "%"));
				}
				if (StringUtils.isNotBlank(recruitQueryDTO.getPosition())) {
					predicate.add(criteriaBuilder.like(root.get("position").as(String.class),
							"%" + recruitQueryDTO.getPosition() + "%"));
				}
				if(null!=recruitQueryDTO.getPlanNum()) {
					predicate.add(criteriaBuilder.equal(root.get("planNum").as(Long.class),
							recruitQueryDTO.getPlanNum()));
				}
				if (null!=recruitQueryDTO.getStartTime()) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startTime").as(Date.class),
							recruitQueryDTO.getStartTime()));
				}
				if (null!=recruitQueryDTO.getEndTime()) {
					predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("endTime").as(Date.class),
							recruitQueryDTO.getEndTime()));
				}
				
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}

}
