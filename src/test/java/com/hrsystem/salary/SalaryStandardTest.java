package com.hrsystem.salary;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.salary.entity.SalaryStandard;
import com.hrsystem.salary.service.SalaryService;
import com.hrsystem.salary.service.SalaryStandardService;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: SalaryStandardTest.java
  *@Date: 2018年10月22日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SalaryStandardTest {
	@Autowired
	private SalaryStandardService salaryStandardService;
	
	@Test
	public void SalaryStandardServiceSave() {
		SalaryStandard  salaryStandard  = new SalaryStandard();
		Date now = new Date();
		salaryStandard.setCreateTime(now);
		salaryStandardService.insertSalaryStandard(salaryStandard);
	}
	
	@Test
	public void SalaryStandardServiceUpdata() {
		Date now = new Date();
		SalaryStandard  salaryStandard = salaryStandardService.findSalaryStandardById(1L);
		salaryStandard.setCreateTime(now);
		salaryStandardService.insertSalaryStandard(salaryStandard);
	}
	
	@Test
	public void SalaryStandardServiceDelete() {
		salaryStandardService.deleteSalaryStandard(1L);
	}
	
	@Test
	public void SalaryStandardServiceFindAll() {
		ExtjsPageRequest pageRequest = new ExtjsPageRequest();
		pageRequest.setPage(1);
		salaryStandardService.findAll(null,pageRequest.getPageable());
	}
}
