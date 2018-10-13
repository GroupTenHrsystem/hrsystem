package com.hrsystem.salary.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.hrsystem.salary.entity.DTO.SalaryDTO;
import com.hrsystem.salary.entity.SalaryStandard;
import com.hrsystem.salary.service.ISalaryStandardService;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.service.IStaffService;
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
import com.hrsystem.salary.entity.Salary;
import com.hrsystem.salary.entity.DTO.SalaryQueryDTO;
import com.hrsystem.salary.service.ISalaryService;


/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: SalaryController.java
  *@Date: 2018年9月28日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@RestController
@RequestMapping("/salary")
public class SalaryController {
	@Autowired
	private ISalaryService salaryService;

	@Autowired
	private ISalaryStandardService salaryStandardService;

	@Autowired
	private IStaffService staffService;
	/**
	 * 1、查
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public Salary getSalaryById(@PathVariable Long id) {
		return salaryService.findSalaryById(id);
	}

	/**
	 * 2、批量插入
	 * @return
	 */
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertSalary(@RequestBody SalaryDTO salaryDTO) {
		try {
			//批量插入
			salaryService.insertSalary(salaryDTO);
			return "success:添加成功";
		} catch (Exception e) {
			return "success:添加失败";
		}
	}

	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String update(@PathVariable("id") Long myId,@RequestBody Salary dto)
	{
		try {
			Salary entity = salaryService.findSalaryById(myId);
			BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
			salaryService.updataSalary(entity);
			return "success:true";
		} catch (Exception e) {
			return "success:false";
		}
	}
	/**
	 * 3、删
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="{id}")
	public String deleteSalaryById(@PathVariable Long id) {
			try {
				salaryService.deleteSalary(id);
				return "success:删除成功";
			}catch (Exception e) {
				return "success:false";
			}
	}

	 @PostMapping("/deletes")
	public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) 
	{
			try {
				if(ids!=null) {
					salaryService.deleteAll(ids);
				}
				return new ExtAjaxResponse(true,"批量删除成功！");
			} catch (Exception e) {
				return new ExtAjaxResponse(true,"批量删除失败！");
			}
	}
	 
	@GetMapping
	public Page<SalaryDTO> getPage(SalaryQueryDTO salaryQueryDTO,ExtjsPageRequest pageRequest)
	{
		Specification buildSpecification = SpecificationBuilder.buildSpecification(salaryQueryDTO);
		Page<Salary> page = salaryService.findAll(buildSpecification, pageRequest.getPageable());
		return SalaryDTO.toSalaryDTO(page, pageRequest.getPageable());
	}
}
