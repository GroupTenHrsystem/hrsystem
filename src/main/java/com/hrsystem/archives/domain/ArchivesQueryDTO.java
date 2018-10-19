package com.hrsystem.archives.domain;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import lombok.Data;

@Data
public class ArchivesQueryDTO {

	private Long id;
	private Long archivesId;
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
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getArchivesId() {
		return archivesId;
	}

	public void setArchivesId(Long archivesId) {
		this.archivesId = archivesId;
	}

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
				if(null!=archivesQueryDTO.getArchivesId()) {
					predicate.add(criteriaBuilder.equal(root.get("archivesId").as(Long.class),
							 archivesQueryDTO.getArchivesId() ));
				}
				if (StringUtils.isNotBlank(archivesQueryDTO.getSsCard())) {
					predicate.add(criteriaBuilder.like(root.get("ssCard").as(String.class),
							archivesQueryDTO.getSsCard()));
				}
				if (StringUtils.isNotBlank(archivesQueryDTO.getBankCard())) {
					predicate.add(criteriaBuilder.like(root.get("bankCard").as(String.class),
							archivesQueryDTO.getBankCard()));
				}
				if (StringUtils.isNotBlank(archivesQueryDTO.getEducation())) {
					predicate.add(criteriaBuilder.like(root.get("education").as(String.class),
							archivesQueryDTO.getEducation()));
				}
				if (StringUtils.isNotBlank(archivesQueryDTO.getMajor())) {
					predicate.add(criteriaBuilder.like(root.get("major").as(String.class),
							archivesQueryDTO.getMajor()));
				}
				if (StringUtils.isNotBlank(archivesQueryDTO.getGraduateSchool())){
					predicate.add(criteriaBuilder.like(root.get("graduateSchool").as(String.class),
							archivesQueryDTO.getGraduateSchool()));
				}
				if (StringUtils.isNotBlank(archivesQueryDTO.getRecord())) {
					predicate.add(criteriaBuilder.like(root.get("record").as(String.class),
							archivesQueryDTO.getRecord()));
				}
				if (StringUtils.isNotBlank(archivesQueryDTO.getFamily())) {
					predicate.add(criteriaBuilder.like(root.get("family").as(String.class),
							archivesQueryDTO.getFamily()));
				}
				if (StringUtils.isNotBlank(archivesQueryDTO.getRemark())) {
					predicate.add(criteriaBuilder.equal(root.get("remark").as(String.class),
							archivesQueryDTO.getRemark()));
				}
				if (StringUtils.isNotBlank(archivesQueryDTO.getAttach())){
					predicate.add(criteriaBuilder.like(root.get("attach").as(String.class),
							archivesQueryDTO.getAttach()));
				}
				if (StringUtils.isNotBlank(archivesQueryDTO.getArstatus())){
					predicate.add(criteriaBuilder.like(root.get("arstatus").as(String.class),
							archivesQueryDTO.getArstatus()));
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}
}
