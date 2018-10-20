package com.hrsystem.attendance.entity.DTO;

import com.hrsystem.common.sign.Like;

import lombok.Data;

@Data
public class AttendanceDTO {

	private Long id;
	@Like
	private String employeName;
	private Long employeNum; 
	private Long totalTime;        //工作总时间
	private Long delateCount;      //迟到次数
	private Long leaveEarlyCount;  //早退次数
	private Long leaveCount;       //请假次数
	private Long absenTime;        //旷工次数
	private Long extraTime;        //加班总时间
}
