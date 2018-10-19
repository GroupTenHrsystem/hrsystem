package com.hrsystem.report.entity.DTO;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrsystem.common.sign.GreaterThanEqual;
import com.hrsystem.common.sign.Join;
import com.hrsystem.common.sign.LessThanEqual;
import com.hrsystem.common.sign.Like;
import com.hrsystem.common.sign.Name;
import com.hrsystem.user.entity.Staff;

import lombok.Data;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: ReportQueryDTO.java
  *@Date: 2018年10月17日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Data
public class ReportQueryDTO {
	
	private Long id;
	
	@Like
	private String title;
	
	@Like
	private String messages;
	
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date time;
	
	@Name("time")
	@GreaterThanEqual 
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date timeStart;
	
	@Name("salaryEndTime")
	@LessThanEqual  
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date timeEnd;
	
	private Boolean status = true;
			
	@Join("staff")
	private String staffName;
}
