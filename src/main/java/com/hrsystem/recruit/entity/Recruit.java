package com.hrsystem.recruit.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name="t_recruit")
public class Recruit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long recruitId;
	
	//@Enumerated(EnumType.STRING)
	private String departmentname;
	
	private String position;
	
	private Long planNum;
	private float salary;
	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date startTime;
	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date endTime;
	
	private String editName;
	private String postdesc;
	private String demand;
}
