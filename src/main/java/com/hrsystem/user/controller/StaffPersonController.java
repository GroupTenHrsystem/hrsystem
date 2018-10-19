package com.hrsystem.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtAjaxResponse;
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
//查
	@GetMapping
	public Staff getOne(HttpSession session) 
	{
		String sessionName=SessionUtil.getUserName(session);
		Staff staff = staffService.findStaffByName(sessionName);
//		staff.setDepartment(null);
		return staff;
		
	}
//改
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExtAjaxResponse update(@PathVariable("id") Long myId,@RequestBody Staff dto) 
	{
		try {
			Staff entity = staffService.findStaffById(myId);
			if(entity!=null) {
				BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
				staffService.insertStaff(entity);
			}
			return new ExtAjaxResponse(true,"更新成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"更新失败！");
		}
	}
}
