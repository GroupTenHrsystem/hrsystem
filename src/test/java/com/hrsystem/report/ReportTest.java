package com.hrsystem.report;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.performance.entity.PerformanceTemplet;
import com.hrsystem.report.entity.Report;
import com.hrsystem.report.service.IReportService;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: ReportTest.java
  *@Date: 2018年10月22日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ReportTest {
	@Autowired
	private IReportService reportService;
	
	@Test
	public void ReportServiceSave() {
		Report  report  = new Report();
		Date now = new Date();
		report.setTime(now);
		reportService.saveReport(report, "user1");
	}
		
	
	@Test
	public void ReportServiceFindAll() {
		ExtjsPageRequest pageRequest = new ExtjsPageRequest();
		pageRequest.setPage(1);
		reportService.findAll(null,pageRequest.getPageable());
	}
}
