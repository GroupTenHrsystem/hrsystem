package com.hrsystem.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.user.entity.Department;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.service.IDepartmentService;
import com.hrsystem.user.service.IStaffService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private IStaffService  staffService;
	@Autowired
	private IDepartmentService  departmentService;
	
	@GetMapping("/get/{id}")
	public Department getPerformanceById(@PathVariable Long id) {
		return departmentService.findDepartmentById(id);
	}
	//通过部门得到直属员工
	@RequestMapping(value = "/staff")
    public List<Staff> getStaffList(@RequestParam(name="departmentId") Long departmentId){
		return staffService.getStaffList(departmentId);
    }
	//所有部门组成的树
    @RequestMapping(value = "/findNoParent")
    public List<Department> getFindNoParentList(){
    	
		return departmentService.findNoParent();
    }
    //获得所有部门
    @RequestMapping(value = "/department")
    public List<Department> getDepartmentList(){
		return departmentService.getDepartmentList(null);
    }
    //所有子部门的ID
    @RequestMapping(value = "/departmentAllId")
    public List<Long> getDepartmentAllIdList(@RequestParam(name="departmentId") Long departmentId){
    	List<Long> lists = new ArrayList<Long>();
    	lists.add(departmentId);
		return departmentService.findAllSubChildrensIds(lists,departmentId);
    }
    //部门的子部门的所有员工
    @RequestMapping(value = "/departmentAllStaff")
    public List<Staff> getDepartmentAllStaffList(@RequestParam(name="departmentId") Long departmentId){
    	List<Long> lists = new ArrayList<Long>();
    	lists.add(departmentId);
		return departmentService.findAllSubChildrensStaffs(lists,departmentId);
    }
}
