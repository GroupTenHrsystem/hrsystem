package com.hrsystem.training.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class EnrollQueryDTO {

	private Long employeeId;
	private Long courseId;
	private String auditResult;
	private String auditStatus;
	private String auditor;
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getAuditResult() {
		return auditResult;
	}
	public void setAuditResult(String auditResult) {
		this.auditResult = auditResult;
	}
	public String getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	@SuppressWarnings({ "serial"})
	public static Specification<Enroll> getWhereClause(final EnrollQueryDTO enrollQueryDTO) {
		return new Specification<Enroll>() {
			@Override
			public Predicate toPredicate(Root<Enroll> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			
				List<Predicate> predicate = new ArrayList<>();
				
				if (null!=enrollQueryDTO.getEmployeeId()) {
					predicate.add(criteriaBuilder.equal(root.get("employeeId").as(Long.class),
							enrollQueryDTO.getEmployeeId()));
				}
				if(null!=enrollQueryDTO.getCourseId())  {
					predicate.add(criteriaBuilder.equal(root.get("courseId").as(Long.class),
							enrollQueryDTO.getCourseId()));
				}
				if (StringUtils.isNotBlank(enrollQueryDTO.getAuditResult())) {
					predicate.add(criteriaBuilder.equal(root.get("auditResult").as(String.class),
							enrollQueryDTO.getAuditResult() ));
				}
				if (StringUtils.isNotBlank(enrollQueryDTO.getAuditStatus())){
					predicate.add(criteriaBuilder.equal(root.get("auditStatus").as(String.class),
							enrollQueryDTO.getAuditStatus()));
				}
				if(StringUtils.isNotBlank(enrollQueryDTO.getAuditor())) {
					predicate.add(criteriaBuilder.equal(root.get("auditor").as(String.class),
							enrollQueryDTO.getAuditor()));
				}
		
				
				
				
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}

}
