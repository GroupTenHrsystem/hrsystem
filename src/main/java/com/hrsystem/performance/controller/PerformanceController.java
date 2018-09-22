package com.hrsystem.performance.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.service.IPerformanceService;

@RestController
@RequestMapping("/performance")
public class PerformanceController {
	@Autowired
	private IPerformanceService performanceService;
	
	/**
	 * 1、查
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public Performance getPerformanceById(@PathVariable Long id) {
		return performanceService.findPerformanceById(id);
	}

	/**
	 * 2、增
	 * @param Performance
	 * @return
	 */
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertPerformance(Performance Performance) {		
		try {
			performanceService.insertPerformance(Performance);
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
	@DeleteMapping("/delete/{id}")
	public String deletePerformanceById(@PathVariable Long id) {
		try {
			performanceService.deletePerformance(id);
			return "success:true";
		} catch (Exception e) {
			return "success:false";
		}
	}

	@GetMapping
	public Page<Performance> getPage(ExtjsPageRequest pageRequest) 
	{
		return performanceService.findAll(null, pageRequest.getPageable());
	}
}
