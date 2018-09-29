package com.hrsystem.performance.controller;
import java.util.ArrayList;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceController.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.DTO.PerformanceDTO;
import com.hrsystem.performance.entity.DTO.PerformanceQueryDTO;
import com.hrsystem.performance.service.IPerformanceService;
import com.hrsystem.performance.service.IPerformanceTempletService;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.service.IStaffService;

@RestController
@RequestMapping("/performance")
public class PerformanceController {
	@Autowired
	private IPerformanceService performanceService;
	
	@Autowired
	private IPerformanceTempletService performanceTempletService;
	
	@Autowired
	private IStaffService staffService;
	/**
	 * 1、查
	 * @param id
	 * @return
	 */
//	@GetMapping("/get/{id}")
//	public Performance getPerformanceById(@PathVariable Long id) {
//		return performanceService.findPerformanceById(id);
//	}
	/**
	 * 2、增
	 * @param Performance
	 * @return
	 */
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertPerformance(@RequestBody PerformanceDTO performanceDTO) {		
		try {
			List<Staff> staff = new ArrayList();
			for(int i = 0; i < performanceDTO.getStaffIds().length; ++i) {
				Optional<Staff> optional = staffService.findStaffById(performanceDTO.getStaffIds()[i]);
				if(optional.isPresent()) {
					staff.add(optional.get());
				}
			}				
			Performance entity = new Performance();
			entity.setPerformanceTemplet(performanceTempletService.findPerformanceTempletById(performanceDTO.getPerformanceTempletId()));
			BeanUtils.copyProperties(performanceDTO, entity);
			entity.setStaff(staff);
			performanceService.insertPerformance(entity);
			return "success:添加成功";
		} catch (Exception e) {
			return "success:添加失败";
		}
	}
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String update(@PathVariable("id") Long myId,@RequestBody Performance dto) 
	{
		try {
			Performance entity = performanceService.findPerformanceById(myId);
			BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
			performanceService.insertPerformance(entity);
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
			performanceService.deletePerformance(id);
			return "success:删除成功";
		} catch (Exception e) {
			return "success:删除失败";
		}
	}

	@GetMapping
	public Page<Performance> getPage(PerformanceQueryDTO performanceQueryDTO,ExtjsPageRequest pageRequest) 
	{
		return performanceService.findAll(PerformanceQueryDTO.getWhereClause(performanceQueryDTO), pageRequest.getPageable());
	}
}
