package com.hrsystem.calendar.entity;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: Event.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "event")
public class Event implements Serializable{
	private Long id;
	private String title;
	private Boolean allDay=false;
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private Date startDate; //2018-01-05T00:00:00.000Z,//UTC
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private Date endDate;  //2018-01-06T00:00:00.000Z,
	private Long calendarId=1L;
	private String  description;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	
	public Boolean getAllDay() {
		return allDay;
	}
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", locale = "zh", timezone="GMT+8")
	public Date getStartDate() {
		return startDate;
	}
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", locale = "zh", timezone="GMT+8")
	public Date getEndDate() {
		return endDate;
	}
	public Long getCalendarId() {
		return calendarId;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAllDay(Boolean allDay) {
		this.allDay = allDay;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
//	public void setStartDate(String startDate) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//		this.startDate = sdf.parse(startDate);
//	}
//	public void setEndDate(String endDate) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//		this.endDate = sdf.parse(endDate);
//	}
	public void setCalendarId(Long calendarId) {
		this.calendarId = calendarId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
     
     
     
}
