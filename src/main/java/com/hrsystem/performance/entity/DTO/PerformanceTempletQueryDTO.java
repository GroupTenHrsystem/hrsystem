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
import com.hrsystem.performance.entity.PerformanceTemplet;

public class PerformanceTempletQueryDTO 
{
	private String kind;
	private String name;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date startTimeStart; 
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date startTimeEnd; 
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date endTimeStart;  
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date endTimeEnd;  
	private String performanceIndex;
	private String  weighting;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTimeStart() {
		return startTimeStart;
	}

	public void setStartTimeStart(Date startTimeStart) {
		this.startTimeStart = startTimeStart;
	}

	public Date getStartTimeEnd() {
		return startTimeEnd;
	}

	public void setStartTimeEnd(Date startTimeEnd) {
		this.startTimeEnd = startTimeEnd;
	}

	public Date getEndTimeStart() {
		return endTimeStart;
	}

	public void setEndTimeStart(Date endTimeStart) {
		this.endTimeStart = endTimeStart;
	}

	public Date getEndTimeEnd() {
		return endTimeEnd;
	}

	public void setEndTimeEnd(Date endTimeEnd) {
		this.endTimeEnd = endTimeEnd;
	}

	public String getPerformanceIndex() {
		return performanceIndex;
	}

	public void setPerformanceIndex(String performanceIndex) {
		this.performanceIndex = performanceIndex;
	}

	public String getWeighting() {
		return weighting;
	}

	public void setWeighting(String weighting) {
		this.weighting = weighting;
	}

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
