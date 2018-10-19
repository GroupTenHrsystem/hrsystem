package com.hrsystem.training.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TrainingDTO {
	private Long id;
	private String courseCode;
	private String courseName;
	private String courseLecturer;
	private String personLiable;
	private String courseAuditStatus;
	@JsonFormat(pattern="yyyy/MM/dd",timezone="GMT+8")
	private Date courseAirtime;
	@JsonFormat(pattern="yyyy/MM/dd",timezone="GMT+8")
	private Date courseEndtime;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseLecturer() {
		return courseLecturer;
	}
	public void setCourseLecturer(String courseLecturer) {
		this.courseLecturer = courseLecturer;
	}
	public String getPersonLiable() {
		return personLiable;
	}
	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
	}
	
	public String getCourseAuditStatus() {
		return courseAuditStatus;
	}
	public void setCourseAuditStatus(String courseAuditStatus) {
		this.courseAuditStatus = courseAuditStatus;
	}
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "courseAirtime")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	public Date getCourseAirtime() {
		return courseAirtime;
	}
	public void setCourseAirtime(Date courseAirtime) {
		this.courseAirtime = courseAirtime;
	}
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "courseEndtime")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	public Date getCourseEndtime() {
		return courseEndtime;
	}
	public void setCourseEndtime(Date courseEndtime) {
		this.courseEndtime = courseEndtime;
	}
}
