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

public class FeedbackQueryDTO {
	private String feedbackId;
	private String employeeId;
	private String courseId;
	private String courseHarvest;
	private String courseEvaluate;
	private String courseOpinion;
	public String getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseHarvest() {
		return courseHarvest;
	}
	public void setCourseHarvest(String courseHarvest) {
		this.courseHarvest = courseHarvest;
	}
	public String getCourseEvaluate() {
		return courseEvaluate;
	}
	public void setCourseEvaluate(String courseEvaluate) {
		this.courseEvaluate = courseEvaluate;
	}
	public String getCourseOpinion() {
		return courseOpinion;
	}
	public void setCourseOpinion(String courseOpinion) {
		this.courseOpinion = courseOpinion;
	}
	@SuppressWarnings({ "serial"})
	public static Specification<Feedback> getWhereClause(final FeedbackQueryDTO feedbackQueryDTO) {
		return new Specification<Feedback>() {
			@Override
			public Predicate toPredicate(Root<Feedback> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			
				List<Predicate> predicate = new ArrayList<>();
				
				if (StringUtils.isNotBlank(feedbackQueryDTO.getFeedbackId())) {
					predicate.add(criteriaBuilder.equal(root.get("feedbackId").as(String.class),
							feedbackQueryDTO.getFeedbackId()));
				}
				if (StringUtils.isNotBlank(feedbackQueryDTO.getEmployeeId()))  {
					predicate.add(criteriaBuilder.equal(root.get("employeeId").as(String.class),
							feedbackQueryDTO.getEmployeeId()));
				}
				if(StringUtils.isNotBlank(feedbackQueryDTO.getCourseId()))  {
					predicate.add(criteriaBuilder.equal(root.get("courseId").as(String.class),
							feedbackQueryDTO.getCourseId()));
				}
				if (StringUtils.isNotBlank(feedbackQueryDTO.getCourseHarvest())) {
					predicate.add(criteriaBuilder.equal(root.get("courseHarvest").as(String.class),
							feedbackQueryDTO.getCourseHarvest() ));
				}
				if (StringUtils.isNotBlank(feedbackQueryDTO.getCourseEvaluate())){
					predicate.add(criteriaBuilder.equal(root.get("courseEvaluate").as(String.class),
							feedbackQueryDTO.getCourseEvaluate()));
				}
				if(StringUtils.isNotBlank(feedbackQueryDTO.getCourseOpinion())) {
					predicate.add(criteriaBuilder.equal(root.get("courseOpinion").as(String.class),
							feedbackQueryDTO.getCourseOpinion()));
				}
		
				
				
				
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}
}
