package com.hrsystem.training.domain;

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

public class TrainingQueryDTO {
	private double courseCode;
	private String courseName;
	private String courseLecturer;
	private String personLiable;
	private String courseAuditor;
	private String courseAuditStatus;
	private String courseAuditResult;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date courseAuditTime;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date courseAirtime;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date courseEndtime;
	public double getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(double courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseLecturer() {
		return courseLecturer;
	}
	public void setCourseLecturer(String courseLecturer) {
		this.courseLecturer = courseLecturer;
	}
	public String getPersonLiable() {
		return personLiable;
	}
	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
	}
	public String getCourseAuditor() {
		return courseAuditor;
	}
	public void setCourseAuditor(String courseAuditor) {
		this.courseAuditor = courseAuditor;
	}
	public String getCourseAuditStatus() {
		return courseAuditStatus;
	}
	public void setCourseAuditStatus(String courseAuditStatus) {
		this.courseAuditStatus = courseAuditStatus;
	}
	public String getCourseAuditResult() {
		return courseAuditResult;
	}
	public void setCourseAuditResult(String courseAuditResult) {
		this.courseAuditResult = courseAuditResult;
	}
	public Date getCourseAuditTime() {
		return courseAuditTime;
	}
	public void setCourseAuditTime(Date courseAuditTime) {
		this.courseAuditTime = courseAuditTime;
	}
	public Date getCourseAirtime() {
		return courseAirtime;
	}
	public void setCourseAirtime(Date courseAirtime) {
		this.courseAirtime = courseAirtime;
	}
	public Date getCourseEndtime() {
		return courseEndtime;
	}
	public void setCourseEndtime(Date courseEndtime) {
		this.courseEndtime = courseEndtime;
	}
	@SuppressWarnings({ "serial"})
	public static Specification<Training> getWhereClause(final TrainingQueryDTO trainingQueryDTO) {
		return new Specification<Training>() {
			@Override
			public Predicate toPredicate(Root<Training> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			
				List<Predicate> predicate = new ArrayList<>();
				if (StringUtils.isNotBlank(trainingQueryDTO.getCourseName())) {
					predicate.add(criteriaBuilder.equal(root.get("courseName").as(String.class),
							"%" + trainingQueryDTO.getCourseName() + "%"));
				}
				if (0!=trainingQueryDTO.getCourseCode()) {
					predicate.add(criteriaBuilder.equal(root.get("courseCode").as(double.class),
							trainingQueryDTO.getCourseCode()));
				}
				if (null!=trainingQueryDTO.getCourseLecturer()) {
					predicate.add(criteriaBuilder.equal(root.get("courseLecturer").as(String.class),
							trainingQueryDTO.getCourseLecturer()));
				}
				if (null!=trainingQueryDTO.getPersonLiable()) {
					predicate.add(criteriaBuilder.equal(root.get("personLiable").as(String.class),
							trainingQueryDTO.getPersonLiable()));
				}
				if (null!=trainingQueryDTO.getCourseAuditor()) {
					predicate.add(criteriaBuilder.equal(root.get("courseAuditor").as(String.class),
							trainingQueryDTO.getCourseAuditor()));
				}
				if (null!=trainingQueryDTO.getCourseAuditStatus()) {
					predicate.add(criteriaBuilder.equal(root.get("courseAuditStatus").as(String.class),
							trainingQueryDTO.getCourseAuditStatus()));
				}
				if (null!=trainingQueryDTO.getCourseAuditResult()) {
					predicate.add(criteriaBuilder.equal(root.get("courseAuditResult").as(String.class),
							trainingQueryDTO.getCourseAuditResult()));
				}
				if (null!=trainingQueryDTO.getCourseAuditTime()) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("courseAuditTime").as(Date.class),
							trainingQueryDTO.getCourseAuditTime()));
				}
				if (null!=trainingQueryDTO.getCourseAirtime()) {
					predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("courseAirtime").as(Date.class),
							trainingQueryDTO.getCourseAirtime()));
				}
				if (null!=trainingQueryDTO.getCourseEndtime()) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("courseEndtime").as(Date.class),
							trainingQueryDTO.getCourseEndtime()));
				}
				
				
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}
}
