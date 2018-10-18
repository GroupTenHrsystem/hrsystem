package com.hrsystem.user.entity.DTO;

import com.hrsystem.common.sign.Join;
import com.hrsystem.common.sign.Like;
import com.hrsystem.user.entity.Department;
import com.hrsystem.user.entity.Role;

import lombok.Data;

@Data
public class RoleQueryDTO {
	private Long id;
	@Like
	private String position;

	private Long limite;	
//	private Long departmentId;

	@Join("department")
	private String departmentName; 
}
