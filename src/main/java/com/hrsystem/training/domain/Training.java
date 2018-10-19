package com.hrsystem.training.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_training")
public class Training implements Serializable{
	private Long id;
	private String courseCode;
	private String courseName;
	private String courseLecturer;
	private String personLiable;
	private String courseAuditor;
	private String courseAuditStatus;
	private String courseAuditResult;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date courseAuditTime;
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
	public String getCourseAuditor() {
		return courseAuditor;
	}
	public void setCourseAuditor(String courseAuditor) {
		this.courseAuditor = courseAuditor;
	}
	public String getCourseAuditStatus() {
		return courseAuditStatus;
	}
	public void setCourseAuditStatus(String courseAuditStatus) {
		this.courseAuditStatus = courseAuditStatus;
	}
	public String getCourseAuditResult() {
		return courseAuditResult;
	}
	public void setCourseAuditResult(String courseAuditResult) {
		this.courseAuditResult = courseAuditResult;
	}
	public Date getCourseAuditTime() {
		return courseAuditTime;
	}
	public void setCourseAuditTime(Date courseAuditTime) {
		this.courseAuditTime = courseAuditTime;
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
