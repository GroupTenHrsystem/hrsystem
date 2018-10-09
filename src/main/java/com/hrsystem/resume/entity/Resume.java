package com.hrsystem.resume.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.interview.entity.Interview;

@Entity
@Table(name="t_resume")
public class Resume {

	private Long id;
	private String name;
	private boolean sex=true;
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
	private boolean ifrefer=false;
	private String referer;
	
	private Interview interview;  //单向一对一
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
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
	@OneToOne
	@JoinColumn(name="interview_id")
	public Interview getInterview() {
		return interview;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setInterview(Interview interview) {
		this.interview = interview;
	}
	
}
