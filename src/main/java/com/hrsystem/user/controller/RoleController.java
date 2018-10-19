package com.hrsystem.user.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtResultJson;
import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.common.specificationBuilder.SpecificationBuilder;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.DTO.PerformanceRelateDTO;
import com.hrsystem.user.entity.Department;
import com.hrsystem.user.entity.Role;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.entity.DTO.RoleDTO;
import com.hrsystem.user.entity.DTO.RoleQueryDTO;
import com.hrsystem.user.entity.DTO.StaffDTO;
import com.hrsystem.user.service.IRoleService;

@RestController
@RequestMapping("/Role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	//查
	@GetMapping
	public Page<RoleDTO> getPage(RoleQueryDTO roleQueryDTO , ExtjsPageRequest pageRequest) 
	{
		System.out.println(roleQueryDTO.getLimite());
		Specification buildSpecification = SpecificationBuilder.buildSpecification(roleQueryDTO);
		Page<Role> page =roleService.findAll(buildSpecification, pageRequest.getPageable());
		
	      return RoleDTO.toRoleDTO(page, pageRequest.getPageable());
	}
//	@GetMapping(value="{id}")
//	public Role getOne(@PathVariable("id") Long id) 
//	{
//		
//		return roleService.findRoleById(id);
//		
//	}

}
