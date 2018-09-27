package com.hrsystem.training.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OA_FEEDBACK")
public class Feedback {
	private int feedbackId;
	private int employeeId;
	private int courseId;
	private String courseHarvest;
	private String courseEvaluate;
	private String courseOpinion;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
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
