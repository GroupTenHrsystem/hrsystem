package com.hrsystem.performance.controller;
import java.util.ArrayList;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceTempletController.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.List;

import javax.validation.Valid;

import com.hrsystem.log.ControllerLogs;
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
import com.hrsystem.performance.entity.PerformanceTemplet;
import com.hrsystem.performance.entity.DTO.PerformanceTempletQueryDTO;
import com.hrsystem.performance.service.IPerformanceService;
import com.hrsystem.performance.service.IPerformanceTempletService;

@RestController
@RequestMapping("/performanceTemplet")
public class PerformanceTempletController {
	@Autowired
	private IPerformanceTempletService performanceTempletService;
	
	@Autowired
	private IPerformanceService performanceService;
	/**
	 * 1、查
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	@ControllerLogs(description = "通过ID查绩效模板")
	public PerformanceTemplet getPerformanceById(@PathVariable Long id) {
		return performanceTempletService.findPerformanceTempletById(id);
	}

	/**
	 * 2、增
	 * @param Performance
	 * @return
	 */
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	@ControllerLogs(description = "插入绩效模板")
	public String insertPerformance(@RequestBody PerformanceTemplet performanceTemplet) {		
		try {
			performanceTemplet.setStatus(true);
			performanceTempletService.insertPerformanceTemplet(performanceTemplet);
			return "success:添加成功";
		} catch (Exception e) {
			return "success:添加失败";
		}
	}

	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	@ControllerLogs(description = "更新绩效模板")
	public String update(@PathVariable("id") Long myId,@RequestBody PerformanceTemplet dto) 
	{
		try {
			PerformanceTemplet entity = performanceTempletService.findPerformanceTempletById(myId);
			BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
			performanceTempletService.insertPerformanceTemplet(entity);
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
	@ControllerLogs(description = "通过id删除绩效模板")
	public String deletePerformanceById(@PathVariable Long id) {
			List<Performance> performanceByPerformanceTempletId = performanceService.getPerformanceByPerformanceTempletId(id);
			if (performanceByPerformanceTempletId.size() == 0) {
				//performanceTempletService.deletePerformanceTemplet(id);
				PerformanceTemplet entity = performanceTempletService.findPerformanceTempletById(id);
				entity.setStatus(false);
				performanceTempletService.insertPerformanceTemplet(entity);
				return "success:删除成功";
			}else {
				return "success:不能被删除，模板正在被使用";
			}
	}

	@PostMapping("/deletes")
	@ControllerLogs(description = "批量删除绩效模板")
	public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) 
	{
		try {
			if(ids!=null) {
				performanceTempletService.deleteAll(ids);
			}
			return new ExtAjaxResponse(true,"批量删除成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"批量删除失败！");
		}
	}
	 
	@GetMapping
	@ControllerLogs(description = "查询绩效模板")
	public Page<PerformanceTemplet> getPage(PerformanceTempletQueryDTO performanceTempletQueryDTO,ExtjsPageRequest pageRequest) 
	{
		Specification buildSpecification = SpecificationBuilder.buildSpecification(performanceTempletQueryDTO);
		return performanceTempletService.findAll(buildSpecification, pageRequest.getPageable());
	}
	
	
//	@RequestMapping("/findAll")
//	public List<PerformanceTemplet> findAll(){
//		List<PerformanceTemplet> list = new ArrayList();
//		list.add(performanceTempletService.findPerformanceTempletById(2L));
//		return list;
//	}
}
