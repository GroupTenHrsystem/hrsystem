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
	private boolean sex;
	private String idCard;
	private String email;
	private String phone;
	private String address;
	private String nativePlace;
	private Date applyTime;
	private String education;
	private String attachment;
	private String experience;
	private String restatus;
	private boolean ifrefer;
	private String referer;
	public String getName() {
		return name;
	}
	public boolean isSex() {
		return sex;
	}
	public String getIdCard() {
		return idCard;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	public Date getApplyTime() {
		return applyTime;
	}
	public String getEducation() {
		return education;
	}
	public String getAttachment() {
		return attachment;
	}
	public String getExperience() {
		return experience;
	}
	public String getRestatus() {
		return restatus;
	}
	public boolean isIfrefer() {
		return ifrefer;
	}
	public String getReferer() {
		return referer;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public void setRestatus(String restatus) {
		this.restatus = restatus;
	}
	public void setIfrefer(boolean ifrefer) {
		this.ifrefer = ifrefer;
	}
	public void setReferer(String referer) {
		this.referer = referer;
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
				if(true!=resumeQueryDTO.isSex()) {
					predicate.add(criteriaBuilder.equal(root.get("sex").as(Boolean.class),
							resumeQueryDTO.isSex()));
				}
				if (StringUtils.isNotBlank(resumeQueryDTO.getIdCard())) {
					predicate.add(criteriaBuilder.like(root.get("idCard").as(String.class),
							"%" + resumeQueryDTO.getIdCard() + "%"));
				}
				if (StringUtils.isNotBlank(resumeQueryDTO.getEmail())) {
					predicate.add(criteriaBuilder.like(root.get("email").as(String.class),
							"%" + resumeQueryDTO.getEmail() + "%"));
				}
				if (StringUtils.isNotBlank(resumeQueryDTO.getPhone())) {
					predicate.add(criteriaBuilder.like(root.get("phone").as(String.class),
							"%" + resumeQueryDTO.getPhone() + "%"));
				}
				if (StringUtils.isNotBlank(resumeQueryDTO.getAddress())) {
					predicate.add(criteriaBuilder.like(root.get("address").as(String.class),
							"%" + resumeQueryDTO.getAddress() + "%"));
				}
				if (StringUtils.isNotBlank(resumeQueryDTO.getNativePlace())) {
					predicate.add(criteriaBuilder.like(root.get("nativePlace").as(String.class),
							"%" + resumeQueryDTO.getNativePlace() + "%"));
				}
				if (null!=resumeQueryDTO.getApplyTime()) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("applyTime").as(Date.class),
							resumeQueryDTO.getApplyTime()));
				}
				if (StringUtils.isNotBlank(resumeQueryDTO.getEducation())) {
					predicate.add(criteriaBuilder.like(root.get("education").as(String.class),
							"%" + resumeQueryDTO.getEducation() + "%"));
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
				if(false!=resumeQueryDTO.isSex()) {
					predicate.add(criteriaBuilder.equal(root.get("ifrefer").as(Boolean.class),
							resumeQueryDTO.isSex()));
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
