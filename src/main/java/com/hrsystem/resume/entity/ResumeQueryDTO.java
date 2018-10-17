package com.hrsystem.resume.entity;

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
import com.hrsystem.activiti.domain.ProcessStatus;

import lombok.Data;

@Data
public class ResumeQueryDTO {

	private String name;  
	private String sex; 
	
	@JsonFormat(pattern="yyyy/MM/dd")
	private Date birthday;   //出生年月
	private String nativePlace;   //籍贯
	private String major;   //专业
	private String politicsStatus;  //政治面貌
	private String graduateSchool;  //毕业学校
	private String email;    //邮箱
	private String phone;    //手机
	private String employBranch;  //求职意向
	private String experience;   //工作经历
	private String selfEvaluation;  //自我评价
	private boolean ifrefer;   //是否推荐
	private String referer;   //推荐人
	private String attachment;   //附件
	
	@JsonFormat(pattern="yyyy/MM/dd")
	private Date applyTime;  
	private String restatus;   

	@SuppressWarnings({ "serial"})
	public static Specification<Resume> getWhereClause(final ResumeQueryDTO resumeQueryDTO) {
		return new Specification<Resume>() {
			@Override
			public Predicate toPredicate(Root<Resume> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			
				List<Predicate> predicate = new ArrayList<>();
				
				if (StringUtils.isNotBlank(resumeQueryDTO.getName())) {
					predicate.add(criteriaBuilder.like(root.get("name").as(String.class),
							"%" + resumeQueryDTO.getName() + "%"));
				}
				if (StringUtils.isNotBlank(resumeQueryDTO.getEmail())) {
					predicate.add(criteriaBuilder.like(root.get("email").as(String.class),
							"%" + resumeQueryDTO.getEmail() + "%"));
				}
				if (StringUtils.isNotBlank(resumeQueryDTO.getPhone())) {
					predicate.add(criteriaBuilder.like(root.get("phone").as(String.class),
							"%" + resumeQueryDTO.getPhone() + "%"));
				}
				if (StringUtils.isNotBlank(resumeQueryDTO.getNativePlace())) {
					predicate.add(criteriaBuilder.like(root.get("nativePlace").as(String.class),
							"%" + resumeQueryDTO.getNativePlace() + "%"));
				}
				if (null!=resumeQueryDTO.getApplyTime()) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("applyTime").as(Date.class),
							resumeQueryDTO.getApplyTime()));
				}
				if (StringUtils.isNotBlank(resumeQueryDTO.getAttachment())) {
					predicate.add(criteriaBuilder.like(root.get("attachment").as(String.class),
							"%" + resumeQueryDTO.getAttachment() + "%"));
				}
				if (StringUtils.isNotBlank(resumeQueryDTO.getExperience())) {
					predicate.add(criteriaBuilder.like(root.get("experience").as(String.class),
							"%" + resumeQueryDTO.getExperience() + "%"));
				}
				if (StringUtils.isNotBlank(resumeQueryDTO.getRestatus())) {
					predicate.add(criteriaBuilder.like(root.get("restatus").as(String.class),
							"%" + resumeQueryDTO.getRestatus() + "%"));
				}
				if (StringUtils.isNotBlank(resumeQueryDTO.getReferer())) {
					predicate.add(criteriaBuilder.like(root.get("referer").as(String.class),
							"%" + resumeQueryDTO.getReferer() + "%"));
				}
				
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}
	
}
