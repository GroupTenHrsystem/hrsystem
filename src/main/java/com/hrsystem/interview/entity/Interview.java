package com.hrsystem.interview.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="t_interview")
public class Interview {

	private Long id;
	private String interviewStatus;
	private String interviewer;
	private Date faceDate;
	private String estimate;
	private String faceResult;
	
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
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	public Date getFaceDate() {
		return faceDate;
	}
	public String getEstimate() {
		return estimate;
	}
	public String getFaceResult() {
		return faceResult;
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
	
	
}
