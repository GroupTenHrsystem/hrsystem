package com.hrsystem.performance.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "performance_templet")
public class PerformanceTemplet implements Serializable {
	//种类 	考评内容 	考评指标 	考评分值 	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String kind;
	private String name;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date startTime; 
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date endTime;  
	private String performanceIndex;
	private String  weighting;
	private Boolean status;
//	private List<Performance> performances = new ArrayList<Performance>();


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getPerformanceIndex() {
		return performanceIndex;
	}
	public void setPerformanceIndex(String performanceIndex) {
		this.performanceIndex = performanceIndex;
	}
	public String getWeighting() {
		return weighting;
	}
	public void setWeighting(String weighting) {
		this.weighting = weighting;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	//@OneToMany(cascade=CascadeType.REFRESH,mappedBy="performanceTemplet")
//	public List<Performance> getPerformances() {
//		return performances;
//	}
//	public void setPerformances(List<Performance> performances) {
//		this.performances = performances;
//	}



	
	
}
