package com.hrsystem.attendance.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="t_attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String employeName;
	private Long employeNum; 
	private Long totalTime;        //工作总时间
	private Long delateCount;      //迟到次数
	private Long leaveEarlyCount;  //早退次数
	private Long leaveCount;       //请假次数
	private Long absenTime;        //旷工次数
	private Long extraTime;        //加班总时间
}
