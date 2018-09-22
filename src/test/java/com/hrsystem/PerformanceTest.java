package com.hrsystem;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.PerformanceTemplet;
import com.hrsystem.performance.service.IPerformanceService;
import com.hrsystem.performance.service.IPerformanceTempletService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PerformanceTest {
	@Autowired
	private IPerformanceService performanceService;
	@Autowired
	private IPerformanceTempletService performanceTempletService;
	@Test
	public void oneToManyTest() {
		Optional<PerformanceTemplet> o1 = performanceTempletService.findPerformanceTempletById(1L);
		Optional<PerformanceTemplet> o2 = performanceTempletService.findPerformanceTempletById(2L);
		Optional<PerformanceTemplet> o3 = performanceTempletService.findPerformanceTempletById(3L);
		Optional<PerformanceTemplet> o4 = performanceTempletService.findPerformanceTempletById(4L);
		Performance e1 = new Performance();
		e1.setCycle(1L);
		e1.setPerformanceTemplet(o1.get());
		
		Performance e2 = new Performance();
		e2.setCycle(2L);
		e2.setPerformanceTemplet(o1.get());
		
		Performance e3 = new Performance();
		e3.setCycle(3L);
		e3.setPerformanceTemplet(o2.get());
		
		Performance e4 = new Performance();
		e4.setCycle(4L);
		e4.setPerformanceTemplet(o2.get());
		
		
		Performance e5 = new Performance();
		e5.setCycle(5L);
		e5.setPerformanceTemplet(o4.get());
		
		Performance e6 = new Performance();
		e6.setCycle(6L);
		e6.setPerformanceTemplet(o3.get());
		
		performanceService.insertPerformance(e1);
		performanceService.insertPerformance(e2);
		performanceService.insertPerformance(e3);
		performanceService.insertPerformance(e4);
		performanceService.insertPerformance(e5);
		performanceService.insertPerformance(e6);
	}
}
