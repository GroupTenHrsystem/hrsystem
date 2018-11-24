package com.hrsystem.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.attendance.entity.Attendance;
import com.hrsystem.attendance.service.IAttendanceService;
import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtAjaxResponse;
import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.common.SessionUtil;
import com.hrsystem.common.specificationBuilder.SpecificationBuilder;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.DTO.PerformanceDTO;
import com.hrsystem.training.domain.Training;
import com.hrsystem.training.domain.TrainingQueryDTO;
import com.hrsystem.user.entity.Role;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.entity.DTO.RoleDTO;
import com.hrsystem.user.entity.DTO.StaffDTO;
import com.hrsystem.user.entity.DTO.StaffQueryDTO;
import com.hrsystem.user.service.IRoleService;
import com.hrsystem.user.service.IStaffService;

@RestController
@RequestMapping("/Staff")
public class StaffController {
	@Autowired
	private IStaffService  staffService;
	
	@Autowired
	private IRoleService  roleService;
	
	@Autowired
	private IAttendanceService  attendanceService;
	
	@Autowired
	private IdentityService identityService;
	
//	/**
//	 * 1、查
//	 * @param id
//	 * @return
//	 */
//	@GetMapping("/get/{id}")
//	public Staff getStaffById(@PathVariable Long id) {
//		return staffService.findStaffById(id);
//	}
	@GetMapping
	public Page<StaffDTO> getPage(StaffQueryDTO staffDTO , ExtjsPageRequest pageRequest) 
	{
		Specification buildSpecification = SpecificationBuilder.buildSpecification(staffDTO);
		Page<Staff> page = staffService.findAll(buildSpecification, pageRequest.getPageable());
		return StaffDTO.toStaffDTO(page, pageRequest.getPageable());
	}
	@GetMapping(value="{id}")
	public Staff getOne(@PathVariable("id") Long id) 
	{
		
		return staffService.findStaffById(id);
		
	}
	
	//2、增
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertStaff(@RequestBody StaffDTO staffDTO) {		
		try {
//			roleService.findByPosition(staff.getr)
			System.out.println("1111112222222");
			System.out.println(staffDTO.getRoleName());
			Staff staff=new Staff();
			BeanUtils.copyProperties(staffDTO, staff);
			System.out.println(staff);
			List<Role> role =roleService.findByPosition(staffDTO.getRoleName());
			System.out.println(staffDTO.getRoleName());
			for (Role long1 : role) {
				staff.setRole(long1);
			}		
			staffService.insertStaff(staff);
			System.out.println("123124");
			Attendance attendance=new Attendance();
			attendance.setId(staff.getId());
			attendance.setEmployeName(staff.getStaffName());
			attendance.setAbsenTime(0L);
			attendance.setDelateCount(0L);
			attendance.setExtraTime(0L);
			attendance.setLeaveCount(0L);
			attendance.setLeaveEarlyCount(0L);
			attendance.setTotalTime(0L);
			attendanceService.insertAttendance(attendance);
			System.out.println(attendance.getEmployeName());
			User admin = identityService.newUser(staffDTO.getStaffName());
			admin.setPassword(staffDTO.getPassword());
	        identityService.saveUser(admin);
	        identityService.createMembership(staffDTO.getStaffName(), staffDTO.getRoleName());
	        System.out.println("success:添加成功");
			return "success:添加成功";
		} catch (Exception e) {
			return "success:添加失败";
		}
	}
	//3、删
	@DeleteMapping(value="{id}")
	public ExtAjaxResponse delete(@PathVariable("id") Long id) 
	{
		try {
			if(id!=null) {
				staffService.deleteStaff(id);;
			}
			return new ExtAjaxResponse(true,"删除成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"删除失败！");
		}
	}
	
	@PostMapping("/deletes")
	public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) 
	{
		try {
			if(ids!=null) {
				staffService.deleteAll(ids);
			}
			return new ExtAjaxResponse(true,"批量删除成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"批量删除失败！");
		}
	}
	//改
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExtAjaxResponse update(@PathVariable("id") Long myId,@RequestBody StaffDTO dto) 
	{
		try {
			System.out.println(dto.getEmploymentDate());
			Staff entity = staffService.findStaffById(myId);
			if(entity!=null) {
				BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
				List<Role> role =roleService.findByPosition(dto.getRoleName());
				for (Role long1 : role) {
					entity.setRole(long1);
					System.out.println(entity.getRole().getPosition());
				}
				staffService.insertStaff(entity);
			}
			return new ExtAjaxResponse(true,"更新成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"更新失败！");
		}
	}

}
