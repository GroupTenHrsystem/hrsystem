package com.hrsystem.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.ExtResultJson;
import com.hrsystem.user.entity.Department;
import com.hrsystem.user.entity.Role;
import com.hrsystem.user.service.RoleIService;

@RestController
@RequestMapping("/Role")
public class RoleController {
	
	@Autowired
	private RoleIService roleService;
	
	//查
	@GetMapping("/find/{id}")
	public Role findRole(@PathVariable Long id){
		return roleService.findRoleById(id);
    }
	

}
