package com.hrsystem.salary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.hrsystem.salary.entity.SalaryStandard;
import com.hrsystem.salary.service.ISalaryStandardService;


/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: SalaryStandardController.java
  *@Date: 2018年9月28日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@RestController
@RequestMapping("/salaryStandard")
public class SalaryStandardController {
			@Autowired
			private ISalaryStandardService salaryStandardService;
			/**
			 * 1、查
			 * @param id
			 * @return
			 */
			@GetMapping("/get/{id}")
			public SalaryStandard getPerformanceById(@PathVariable Long id) {
				return salaryStandardService.findSalaryStandardById(id);
			}
		
			/**
			 * 2、增
			 * @param Performance
			 * @return
			 */
			@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
			public String insertPerformance(@RequestBody SalaryStandard salaryStandard) {
				System.out.println(salaryStandard.getCreateTime());
				try {
					salaryStandardService.insertSalaryStandard(salaryStandard);
					return "success:添加成功";
				} catch (Exception e) {
					return "success:添加失败";
				}
			}
		
			@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
			public String update(@PathVariable("id") Long myId,@RequestBody SalaryStandard dto) 
			{
				try {
					SalaryStandard entity = salaryStandardService.findSalaryStandardById(myId);
					BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
					salaryStandardService.insertSalaryStandard(entity);
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
			public String deletePerformanceById(@PathVariable Long id) {
				try {
						salaryStandardService.deleteSalaryStandard(id);
						return "success:true";
					} catch (Exception e) {
						return "success:false";
					}
			}
		
			 @PostMapping("/deletes")
				public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) 
				{
					try {
						if(ids!=null) {
							salaryStandardService.deleteAll(ids);
						}
						return new ExtAjaxResponse(true,"批量删除成功！");
					} catch (Exception e) {
						return new ExtAjaxResponse(true,"批量删除失败！");
					}
				}
			 
			@GetMapping
			public Page<SalaryStandard> getPage(ExtjsPageRequest pageRequest) 
			{
				return salaryStandardService.findAll(null, pageRequest.getPageable());
			}
}
