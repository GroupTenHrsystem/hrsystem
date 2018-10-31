package com.hrsystem.user.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtAjaxResponse;
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
import com.hrsystem.user.entity.DTO.StaffQueryDTO;
import com.hrsystem.user.service.IDepartmentService;
import com.hrsystem.user.service.IRoleService;

@RestController
@RequestMapping("/Role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IDepartmentService departmentService;

	@Autowired
	private IdentityService identityService;
	
	//查
	@GetMapping
	public Page<RoleDTO> getPage(RoleQueryDTO roleQueryDTO , ExtjsPageRequest pageRequest) 
	{
		Specification buildSpecification = SpecificationBuilder.buildSpecification(roleQueryDTO);
		Page<Role> page =roleService.findAll(buildSpecification, pageRequest.getPageable());
		
	      return RoleDTO.toRoleDTO(page, pageRequest.getPageable());
	}
//	@RequestMapping("/findOne")
//	public List<Staff> getOne(@RequestParam(name="id")  Long id) 
//	{
//		
//		return roleService.findStaffByRole(id);
//		
//	}
//	 @RequestMapping(value = "/saveDepartmentInRole")
//	    public Role saveDepartmentInRole(@RequestParam(name="id") Long id,@RequestParam(name="departmentName") String departmentName){
//		 departmentService.findDepartmentById(id);
//		 
//	    	
//			return departmentService.findNoParent();
//	    }
	//2、增
		@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
		public String insertRole(@RequestBody RoleDTO role) {		
			try {
				Role  role1 =new Role();
				role1.setLimite(role.getLimite());
				role1.setPosition(role.getPosition());
				Department department=departmentService.findDepartmentById(role.getDepartmentId());
				role1.setDepartment(department);
				roleService.insertRole(role1);
				Group group =identityService.newGroup(role.getPosition());
				identityService.saveGroup(group);
//				System.out.println(role.getSex());
				return "success:添加成功";
			} catch (Exception e) {
				return "success:添加失败";
			}
		}
		//删
		@DeleteMapping(value="{id}")
		public ExtAjaxResponse delete(@PathVariable("id") Long id) 
		{
			
			try {
				if(id!=null) {
					
					Role role=roleService.findRoleById(id);
					role.setStatus(false);
					role.setDepartment(null);
					roleService.insertRole(role);
				
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
				for (Long long1 : ids) {
				if(ids!=null) {
					Role role = roleService.findRoleById(long1);
					role.setStatus(false);
					roleService.insertRole(role);
				}
				}
				return new ExtAjaxResponse(true,"批量删除成功！");
			} catch (Exception e) {
				return new ExtAjaxResponse(true,"批量删除失败！");
			}
		}
		//所有部门组成的树
	    @RequestMapping(value = "/findNoParent")
	    public List<Role> getFindNoParentList(){
			return roleService.findNoParent();
	    }
}
