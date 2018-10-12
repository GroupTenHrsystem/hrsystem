package com.hrsystem.interview.entity;

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

public class InterviewQueryDTO {
	private String interviewStatus;
	private String interviewer;
	private Date faceDate;
	private String estimate;
	private String faceResult;
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public String getInterviewer() {
		return interviewer;
	}
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm")
	public Date getFaceDate() {
		return faceDate;
	}
	public String getEstimate() {
		return estimate;
	}
	public String getFaceResult() {
		return faceResult;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}
	public void setFaceDate(Date faceDate) {
		this.faceDate = faceDate;
	}
	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}
	public void setFaceResult(String faceResult) {
		this.faceResult = faceResult;
	}
	
	@SuppressWarnings({ "serial"})
	public static Specification<Interview> getWhereClause(final InterviewQueryDTO interviewQueryDTO) {
		return new Specification<Interview>() {
			@Override
			public Predicate toPredicate(Root<Interview> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			
				List<Predicate> predicate = new ArrayList<>();
				
				if (StringUtils.isNotBlank(interviewQueryDTO.getInterviewStatus())) {
					predicate.add(criteriaBuilder.like(root.get("interviewStatus").as(String.class),
							"%" + interviewQueryDTO.getInterviewStatus() + "%"));
				}
				if (StringUtils.isNotBlank(interviewQueryDTO.getInterviewer())) {
					predicate.add(criteriaBuilder.like(root.get("interviewer").as(String.class),
							"%" + interviewQueryDTO.getInterviewer() + "%"));
				}
				if (null!=interviewQueryDTO.getFaceDate()) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("faceDate").as(Date.class),
							interviewQueryDTO.getFaceDate()));
				}
				if (StringUtils.isNotBlank(interviewQueryDTO.getEstimate())) {
					predicate.add(criteriaBuilder.like(root.get("estimate").as(String.class),
							"%" + interviewQueryDTO.getEstimate() + "%"));
				}
				if (StringUtils.isNotBlank(interviewQueryDTO.getFaceResult())) {
					predicate.add(criteriaBuilder.like(root.get("faceResult").as(String.class),
							"%" + interviewQueryDTO.getFaceResult() + "%"));
				}

				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}

}
