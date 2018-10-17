package com.hrsystem.report.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.report.entity.Report;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: IReportService.java
  *@Date: 2018年10月17日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
public interface IReportService {
	public void saveReport(Report report,String userId);
	
	public Page<Report> findAll(Specification<Report> spec, Pageable pageable);

	public void deleteAll(Long[] ids);
}
