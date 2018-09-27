package com.hrsystem.archives.domain;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;


public class ArchivesQueryDTO {
	
	private String ssCard;
	private String bankCard;
	private String education;
	private String major;
	private String graduateSchool;
	private String record;
	private String family;
	private String remark;
	private String attach;
	private String arstatus;
	
	public String getSsCard() {
		return ssCard;
	}
	public void setSsCard(String ssCard) {
		this.ssCard = ssCard;
	}
	public String getBankCard() {
		return bankCard;
	}
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGraduateSchool() {
		return graduateSchool;
	}
	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getArstatus() {
		return arstatus;
	}
	public void setArstatus(String arstatus) {
		this.arstatus = arstatus;
	}
	@SuppressWarnings({ "serial"})
	public static Specification<Archives> getWhereClause(final ArchivesQueryDTO archivesQueryDTO) {
		return new Specification<Archives>() {
			@Override
			public Predicate toPredicate(Root<Archives> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			
				List<Predicate> predicate = new ArrayList<>();
				if (StringUtils.isNotBlank(archivesQueryDTO.getSsCard())) {
					predicate.add(criteriaBuilder.equal(root.get("ssCard").as(String.class),
							"%" + archivesQueryDTO.getSsCard() + "%"));
				}
				if (null!=archivesQueryDTO.getBankCard()) {
					predicate.add(criteriaBuilder.equal(root.get("bankCard").as(String.class),
							archivesQueryDTO.getBankCard()));
				}
				if (null!=archivesQueryDTO.getEducation()) {
					predicate.add(criteriaBuilder.equal(root.get("education").as(String.class),
							archivesQueryDTO.getEducation()));
				}
				if (null!=archivesQueryDTO.getMajor()) {
					predicate.add(criteriaBuilder.equal(root.get("major").as(String.class),
							archivesQueryDTO.getMajor()));
				}
				if (null!=archivesQueryDTO.getGraduateSchool()) {
					predicate.add(criteriaBuilder.equal(root.get("graduateSchool").as(String.class),
							archivesQueryDTO.getGraduateSchool()));
				}
				if (null!=archivesQueryDTO.getRecord()) {
					predicate.add(criteriaBuilder.equal(root.get("record").as(String.class),
							archivesQueryDTO.getRecord()));
				}
				if (null!=archivesQueryDTO.getFamily()) {
					predicate.add(criteriaBuilder.equal(root.get("family").as(String.class),
							archivesQueryDTO.getFamily()));
				}
				if (null!=archivesQueryDTO.getRemark()) {
					predicate.add(criteriaBuilder.equal(root.get("remark").as(String.class),
							archivesQueryDTO.getRemark()));
				}
				if (null!=archivesQueryDTO.getAttach()) {
					predicate.add(criteriaBuilder.equal(root.get("attach").as(String.class),
							archivesQueryDTO.getAttach()));
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}
}
