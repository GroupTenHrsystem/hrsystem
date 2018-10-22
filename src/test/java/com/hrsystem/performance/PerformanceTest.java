package com.hrsystem.performance;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.service.IPerformanceService;
import com.hrsystem.performance.service.IPerformanceTempletService;
import com.hrsystem.user.service.IStaffService;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceTest.java
  *@Date: 2018年10月22日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PerformanceTest {
	@Autowired
	private IPerformanceService performanceService;
	
	@Autowired
	private IPerformanceTempletService performanceTempletService;

	@Autowired
	private IStaffService  staffService;
	
	@Test
	public void PerformanceSave() {
		Performance  performance  = new Performance();
		Date now = new Date();
		performance.setApplyTime(now);
		performanceService.insertPerformance(performance);
	}
	
	@Test
	public void PerformanceUpdata() {
		Date now = new Date();
		Performance performance = performanceService.findPerformanceById(1L);
		performance.setApplyTime(now);
		performanceService.insertPerformance(performance);
	}
	
	@Test
	public void PerformanceDelete() {
		performanceService.deletePerformance(1L);
	}
	
	@Test
	public void PerformanceFindAll() {
		ExtjsPageRequest pageRequest = new ExtjsPageRequest();
		pageRequest.setPage(1);
		performanceService.findAll(null,pageRequest.getPageable());
	}
}
