package com.hrsystem.performance.entity.DTO;

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
	private String performanceName;	
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date startTime;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date startTimeStart; 
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date startTimeEnd; 
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date endTimeStart;  
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date endTimeEnd;  
	private Long cycle;
	private Boolean status=false;
	private Long performanceTempletId;
	
	@SuppressWarnings({ "serial"})
	public static Specification<Performance> getWhereClause(final PerformanceQueryDTO performanceQueryDTO) {
		return new Specification<Performance>() {
			@Override
			public Predicate toPredicate(Root<Performance> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			
				List<Predicate> predicate = new ArrayList<>();
				
				if (null!=performanceQueryDTO.getUserId()) {
					predicate.add(criteriaBuilder.equal(root.get("userId").as(String.class),
							performanceQueryDTO.getUserId()));
				}
				
				if (StringUtils.isNotBlank(performanceQueryDTO.getPerformanceName())) {
					predicate.add(criteriaBuilder.like(root.get("performanceName").as(String.class),
							"%" + performanceQueryDTO.getPerformanceName() + "%"));
				}
				if (null !=performanceQueryDTO.getCycle()) {
					predicate.add(criteriaBuilder.equal(root.get("cycle").as(Long.class),
								performanceQueryDTO.getCycle()));
				}
				if (null !=performanceQueryDTO.getStartTime()) {
					predicate.add(criteriaBuilder.equal(root.get("startTime").as(Date.class),
								performanceQueryDTO.getStartTime()));
				}
				if (null!=performanceQueryDTO.getStartTimeStart()) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startTime").as(Date.class),
							performanceQueryDTO.getStartTimeStart()));
				}
				if (null!=performanceQueryDTO.getStartTimeEnd()) {
					predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("startTime").as(Date.class),
							performanceQueryDTO.getStartTimeEnd()));
				}
				if (null!=performanceQueryDTO.getEndTimeStart()) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("endTime").as(Date.class),
							performanceQueryDTO.getEndTimeStart()));
				}
				if (null!=performanceQueryDTO.getEndTimeEnd()) {
					predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("endTime").as(Date.class),
							performanceQueryDTO.getEndTimeEnd()));
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}
}
