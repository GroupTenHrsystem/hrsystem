package com.hrsystem.performance.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "performance")
public class Performance implements Serializable {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String performanceName;	
		private Date startTime; 
		private Date endTime;  
		private Long cycle;
		private Boolean status=false;
		@ManyToOne(cascade=CascadeType.ALL)
		PerformanceTemplet performanceTemplet;
		
			public Long getId() { 
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getPerformanceName() {
			return performanceName;
		}
		public void setPerformanceName(String performanceName) {
			this.performanceName = performanceName;
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
		public Long getCycle() {
			return cycle;
		}
		public void setCycle(Long cycle) {
			this.cycle = cycle;
		}
		public Boolean getStatus() {
			return status;
		}
		public void setStatus(Boolean status) {
			this.status = status;
		}
	
		public PerformanceTemplet getPerformanceTemplet() {
			return performanceTemplet;
		}
		public void setPerformanceTemplet(PerformanceTemplet performanceTemplet) {
			this.performanceTemplet = performanceTemplet;
		}
		
}
