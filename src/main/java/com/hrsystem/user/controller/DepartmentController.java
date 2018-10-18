package com.hrsystem.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtAjaxResponse;
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
    //更新
    @RequestMapping(value="/update")
	public ExtAjaxResponse update(@RequestParam(name="id") Long myId,@RequestParam(name="departmentName") String departmentName,@RequestParam(name="introduce") String introduce) 
	{
		try {
			Department entity = departmentService.findDepartmentById(myId);
			if(entity!=null) {
				entity.setDepartmentName(departmentName);
				entity.setIntroduce(introduce);
				departmentService.insertDepartment(entity);
			}
			return new ExtAjaxResponse(true,"更新成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"更新失败！");
		}
	}
    @RequestMapping(value="/save")
	public ExtAjaxResponse save(@RequestParam(name="departmentName") String departmentName,@RequestParam(name="introduce") String introduce,@RequestParam(name="superId") Department superId) 
	{
		try {
			System.out.println(superId);
			System.out.println("111111111111");
            Department entity = new Department();
				entity.setDepartmentName(departmentName);
				entity.setIntroduce(introduce);
				entity.setSuperId(superId);
				departmentService.insertDepartment(entity);
			return new ExtAjaxResponse(true,"添加成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"添加失败！");
		}
	}
    @RequestMapping(value="/delete")
	public ExtAjaxResponse update(@RequestParam(name="id") Long id) 
	{
		try {
			Department entity = departmentService.findDepartmentById(id);
			entity.setSuperId(null);
			if(entity!=null) {
				departmentService.deleteDepartment(id);
			}
			return new ExtAjaxResponse(true,"删除成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"删除失败！");
		}
	}
    
}
