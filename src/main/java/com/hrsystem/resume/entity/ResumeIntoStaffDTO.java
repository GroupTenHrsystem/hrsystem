package com.hrsystem.resume.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.common.sign.Like;

import lombok.Data;

@Data
public class ResumeIntoStaffDTO {
	private Long id;
	private Long employeNum;
	@Like
	private String departmentName;
	@JsonFormat(pattern="yyyy/MM/dd")
	private Date employmentDate;
}
