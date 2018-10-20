package com.hrsystem.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.attendance.entity.Attendance;
import com.hrsystem.attendance.service.IAttendanceService;
import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.common.specificationBuilder.SpecificationBuilder;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.entity.DTO.StaffDTO;

@RestController
@RequestMapping("/Attendance")
public class AttendanceController {
	
	@Autowired
	IAttendanceService attendanceService;

	//查
	@GetMapping
	public Page<Attendance> getPage(Attendance attendance , ExtjsPageRequest pageRequest) 
	{
		Specification buildSpecification = SpecificationBuilder.buildSpecification(attendance);
		System.out.println(attendance.getEmployeName());
		System.out.println(attendance.getEmployeNum());
		return attendanceService.findAll(buildSpecification, pageRequest.getPageable());
		
	}

}
