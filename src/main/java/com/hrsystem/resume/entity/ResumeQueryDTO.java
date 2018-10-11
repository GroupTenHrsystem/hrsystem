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

public class ResumeQueryDTO {

	private String name;  
	private String sex; 
	
	@JsonFormat(pattern="yyyy/MM/dd",timezone="GMT+8")
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
	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date applyTime;  
	private String restatus;   
	
	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public String getMajor() {
		return major;
	}

	public String getPoliticsStatus() {
		return politicsStatus;
	}

	public String getGraduateSchool() {
		return graduateSchool;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmployBranch() {
		return employBranch;
	}

	public String getExperience() {
		return experience;
	}

	public String getSelfEvaluation() {
		return selfEvaluation;
	}

	public boolean isIfrefer() {
		return ifrefer;
	}

	public String getReferer() {
		return referer;
	}

	public String getAttachment() {
		return attachment;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public String getRestatus() {
		return restatus;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmployBranch(String employBranch) {
		this.employBranch = employBranch;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public void setSelfEvaluation(String selfEvaluation) {
		this.selfEvaluation = selfEvaluation;
	}

	public void setIfrefer(boolean ifrefer) {
		this.ifrefer = ifrefer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public void setRestatus(String restatus) {
		this.restatus = restatus;
	}

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
