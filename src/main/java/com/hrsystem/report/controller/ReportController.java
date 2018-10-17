package com.hrsystem.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.ExtAjaxResponse;
import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.common.specificationBuilder.SpecificationBuilder;
import com.hrsystem.log.ControllerLogs;
import com.hrsystem.report.entity.Report;
import com.hrsystem.report.service.IReportService;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: ReportController.java
  *@Date: 2018年10月17日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@RestController
@RequestMapping("/report")
public class ReportController {
	@Autowired
	private IReportService reportService;
	
	@GetMapping
	@ControllerLogs(description = "查询全部工作汇报")
	public Page<Report> getPage(ExtjsPageRequest pageRequest) 
	{
		//Specification buildSpecification = SpecificationBuilder.buildSpecification();
		return reportService.findAll(null, pageRequest.getPageable());
	}
	
	@PostMapping("/save")
	@ControllerLogs(description = "保存工作汇报")
	public ExtAjaxResponse save(Report report) 
	{
		try {
			reportService.saveReport(report);
			return new ExtAjaxResponse(true,"保存成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"保存失败！");
		}
	}	
}
