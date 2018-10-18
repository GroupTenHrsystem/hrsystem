package com.hrsystem.recruit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	private Long id;
	
	//@Enumerated(EnumType.STRING)
	private String departmentname;
	
	private String position;
	
	private Long planNum;
	private float salary;
	private String contact;  //联系方式
	
	@JsonFormat(pattern="yyyy/MM/dd")
	private Date startTime;
	
	@JsonFormat(pattern="yyyy/MM/dd")
	private Date endTime;
	
	private String editName;
	private String postdesc;
	private String demand;
}
