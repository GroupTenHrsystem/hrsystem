package com.hrsystem.training.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_feedback")
public class Feedback implements Serializable{
	private Long id;
	private String feedbackId;
	private String employeeId;
	private String courseId;
	private String courseHarvest;
	private String courseEvaluate;
	private String courseOpinion;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	public String getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseHarvest() {
		return courseHarvest;
	}
	public void setCourseHarvest(String courseHarvest) {
		this.courseHarvest = courseHarvest;
	}
	public String getCourseEvaluate() {
		return courseEvaluate;
	}
	public void setCourseEvaluate(String courseEvaluate) {
		this.courseEvaluate = courseEvaluate;
	}
	public String getCourseOpinion() {
		return courseOpinion;
	}
	public void setCourseOpinion(String courseOpinion) {
		this.courseOpinion = courseOpinion;
	}
	
}
