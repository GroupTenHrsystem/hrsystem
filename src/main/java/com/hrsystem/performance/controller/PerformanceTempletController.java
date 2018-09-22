package com.hrsystem.performance.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.PerformanceTemplet;
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
	public PerformanceTemplet getPerformanceById(@PathVariable Long id) {
		return performanceTempletService.findPerformanceTempletById(id);
	}

	/**
	 * 2、增
	 * @param Performance
	 * @return
	 */
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertPerformance(PerformanceTemplet performanceTemplet) {		
		try {
			performanceTempletService.insertPerformanceTemplet(performanceTemplet);
			return "success:添加成功";
		} catch (Exception e) {
			return "success:添加失败";
		}
	}

	/**
	 * 3、删
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String deletePerformanceById(@PathVariable Long id) {
			List<Performance> performanceByPerformanceTempletId = performanceService.getPerformanceByPerformanceTempletId(id);
			if (performanceByPerformanceTempletId.size() == 0) {
				performanceTempletService.deletePerformanceTemplet(id);
				return "success:删除成功";
			}else {
				return "success:不能被删除，模板正在被使用";
			}
	}

	@GetMapping
	public Page<PerformanceTemplet> getPage(ExtjsPageRequest pageRequest) 
	{
		return performanceTempletService.findAll(null, pageRequest.getPageable());
	}
}
