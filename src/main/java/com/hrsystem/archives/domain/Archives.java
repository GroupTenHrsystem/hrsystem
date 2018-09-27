package com.hrsystem.archives.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OA_ARCHIVES")
public class Archives implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//使用的数据字段
	private int archivesId;
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
	public int getArchiveId() {
		return archivesId;
	}
	public void setArchiveId(int archiveId) {
		this.archivesId = archiveId;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
