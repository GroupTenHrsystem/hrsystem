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
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.PerformanceTemplet;

import lombok.Data;
@Data
public class PerformanceTempletQueryDTO 
{
	private String kind;
	private String name;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")  
	private Date startTimeStart; 
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")  
	private Date startTimeEnd; 
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")  
	private Date endTimeStart;  
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")  
	private Date endTimeEnd;  
	private String performanceIndex;
	private String  weighting;

	@SuppressWarnings({ "serial"})
	public static Specification<PerformanceTemplet> getWhereClause(final PerformanceTempletQueryDTO performanceTempletQueryDTO) {
		return new Specification<PerformanceTemplet>() {
			@Override
			public Predicate toPredicate(Root<PerformanceTemplet> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			
				List<Predicate> predicate = new ArrayList<>();
				if (StringUtils.isNotBlank(performanceTempletQueryDTO.getKind())) {
					predicate.add(criteriaBuilder.like(root.get("kind").as(String.class),
							"%" + performanceTempletQueryDTO.getKind() + "%"));
				}
				if (StringUtils.isNotBlank(performanceTempletQueryDTO.getName())) {
					predicate.add(criteriaBuilder.like(root.get("name").as(String.class),
							"%" + performanceTempletQueryDTO.getName() + "%"));
				}
				if (StringUtils.isNotBlank(performanceTempletQueryDTO.getPerformanceIndex())) {
					predicate.add(criteriaBuilder.like(root.get("performanceIndex").as(String.class),
							"%" + performanceTempletQueryDTO.getPerformanceIndex() + "%"));
				}
				if (StringUtils.isNotBlank(performanceTempletQueryDTO.getWeighting())) {
					predicate.add(criteriaBuilder.like(root.get("weighting").as(String.class),
							"%" + performanceTempletQueryDTO.getWeighting() + "%"));
				}
				if (null!=performanceTempletQueryDTO.getStartTimeStart()) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startTime").as(Date.class),
							performanceTempletQueryDTO.getStartTimeStart()));
				}
				if (null!=performanceTempletQueryDTO.getStartTimeEnd()) {
					predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("startTime").as(Date.class),
							performanceTempletQueryDTO.getStartTimeEnd()));
				}
				if (null!=performanceTempletQueryDTO.getEndTimeStart()) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("endTime").as(Date.class),
							performanceTempletQueryDTO.getEndTimeStart()));
				}
				if (null!=performanceTempletQueryDTO.getEndTimeEnd()) {
					predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("endTime").as(Date.class),
							performanceTempletQueryDTO.getEndTimeEnd()));
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}
}
