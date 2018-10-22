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
import com.hrsystem.performance.entity.PerformanceTemplet;
import com.hrsystem.performance.service.IPerformanceTempletService;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceTempletTest.java
  *@Date: 2018年10月22日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PerformanceTempletTest {
	@Autowired
	private IPerformanceTempletService performanceTempletService;
	
	@Test
	public void PerformanceTempletSave() {
		PerformanceTemplet  performanceTemplet  = new PerformanceTemplet();
		Date now = new Date();
		performanceTemplet.setStartTime(now);
		performanceTempletService.insertPerformanceTemplet(performanceTemplet);
	}
	
	@Test
	public void PerformanceTempletUpdata() {
		Date now = new Date();
		PerformanceTemplet  performanceTemplet  = performanceTempletService.findPerformanceTempletById(1L);
		performanceTemplet.setEndTime(now);
		performanceTempletService.insertPerformanceTemplet(performanceTemplet);
	}
	
	@Test
	public void PerformanceTempletDelete() {
		performanceTempletService.deletePerformanceTemplet(1L);
	}
	
	@Test
	public void PerformanceFindAll() {
		ExtjsPageRequest pageRequest = new ExtjsPageRequest();
		pageRequest.setPage(1);
		performanceTempletService.findAll(null,pageRequest.getPageable());
	}
}
