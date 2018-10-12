package com.hrsystem.user.entity.DTO;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.common.sign.GreaterThanEqual;
import com.hrsystem.common.sign.LessThanEqual;
import com.hrsystem.common.sign.Like;
import com.hrsystem.common.sign.Name;
import com.hrsystem.user.entity.Role;

import lombok.Data;

@Data
public class StaffDTO {
	private Long id;
	private Long employeNum;
	
	@Like
	private String staffName;
	
	private String sex;
	private String idcard;
	private String email;
	private String phone;
	private String password;
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date birthday;
	private String address;
	private String nativePlace;
	private String status;
	
	@Name("employmentDate")
	@GreaterThanEqual 
	@DateTimeFormat(pattern="yyyy/MM/dd") 
	private Date createTimeStart;
	@Name("employmentDate")
	@LessThanEqual 
	@DateTimeFormat(pattern="yyyy/MM/dd") 
	private Date createTimeEnd;
	
	private Role role;
	
	}