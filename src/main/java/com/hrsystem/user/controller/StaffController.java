package com.hrsystem.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.service.IStaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private IStaffService staffService;
	
	@GetMapping
	public Page<Staff> getPage(ExtjsPageRequest pageRequest) 
	{
		return staffService.findAll(null, pageRequest.getPageable());
	}
}
