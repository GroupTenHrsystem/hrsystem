package com.hrsystem.interview.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostRemove;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="t_interview")
@SQLDelete(sql="update t_interview set is_deleted_= true where id=?",check = ResultCheckStyle.COUNT)
@SQLDeleteAll(sql="update t_interview set is_deleted_= true where id=?",check = ResultCheckStyle.COUNT)
@Where(clause="is_deleted_ != true")
public class Interview {

	private Long id;
	private String interviewStatus;
	private String interviewer;
	private Date faceDate;
	private String estimate;
	private String faceResult;
	
	private boolean isDeleted;  //默认值为false
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
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
	@Column(name="is_deleted_")
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	@PostRemove
	public void delete() {
		this.isDeleted = true;
	}

}
