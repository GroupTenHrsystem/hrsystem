package com.hrsystem.user.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtAjaxResponse;
import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.common.specificationBuilder.SpecificationBuilder;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.DTO.PerformanceDTO;
import com.hrsystem.training.domain.Training;
import com.hrsystem.training.domain.TrainingQueryDTO;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.entity.DTO.StaffDTO;
import com.hrsystem.user.service.IStaffService;

@RestController
@RequestMapping("/Staff")
public class StaffController {
	@Autowired
	private IStaffService  staffService;
	
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
	public Page<Staff> getPage(StaffDTO staffDTO , ExtjsPageRequest pageRequest) 
	{
		Specification buildSpecification = SpecificationBuilder.buildSpecification(staffDTO);
		return staffService.findAll(buildSpecification, pageRequest.getPageable());
	}
	@GetMapping(value="{id}")
	public Staff getOne(@PathVariable("id") Long id) 
	{
		
		return staffService.findStaffById(id);
		
	}

	//2、增
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertStaff(@RequestBody Staff staff) {		
		try {
			staffService.insertStaff(staff);
			System.out.println(staff.getSex());
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
