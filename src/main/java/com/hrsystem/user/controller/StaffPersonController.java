package com.hrsystem.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.SessionUtil;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.service.IStaffService;

@RestController
@RequestMapping("/person")
public class StaffPersonController {
	@Autowired
	private IStaffService  staffService;
	
//	@GetMapping
//	 public @ResponseBody List<Staff> check(HttpSession session) {	 
//
//				
//			String sessionName=SessionUtil.getUserName(session);
//			Staff staff=staffService.findStaffByName(sessionName);
//			System.out.println(staff);
//			List<Staff> list = new ArrayList<>();
//			list.add(staff);
//			return list;
//				
//	 }

	@GetMapping
	public Staff getOne(HttpSession session) 
	{
		String sessionName=SessionUtil.getUserName(session);
		System.out.println(staffService.findStaffByName(sessionName));
		return staffService.findStaffByName(sessionName);
		
	}
}
