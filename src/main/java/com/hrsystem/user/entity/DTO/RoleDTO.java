package com.hrsystem.user.entity.DTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.sign.Like;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.DTO.PerformanceRelateDTO;
import com.hrsystem.user.entity.Department;
import com.hrsystem.user.entity.Role;

import lombok.Data;

@Data
public class RoleDTO {
	private Long id;
	private String position;

	private Long limite;	
	private Long departmentId;

	private String departmentName; 
	
	public static Page<RoleDTO> toRoleDTO(Page<Role> page, Pageable pageable) {
		List<RoleDTO> results = new ArrayList<RoleDTO>();
		Iterator iter = page.iterator();
	      while(iter.hasNext()){
	    	  RoleDTO roleDTO1 = new RoleDTO();
	    	  Role role=(Role)iter.next();
	         BeanUtils.copyProperties(role,roleDTO1);
	         roleDTO1.setDepartmentId(role.getDepartment().getId());
	         roleDTO1.setDepartmentName(role.getDepartment().getDepartmentName());

	         
	         results.add(roleDTO1);
	      }
	      return new PageImpl<RoleDTO> (results, pageable, null!=results?page.getTotalElements():0);
	}
}
