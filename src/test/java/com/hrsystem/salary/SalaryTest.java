package com.hrsystem.salary;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.performance.entity.PerformanceTemplet;
import com.hrsystem.salary.entity.Salary;
import com.hrsystem.salary.entity.DTO.SalaryDTO;
import com.hrsystem.salary.service.SalaryService;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: SalaryTest.java
  *@Date: 2018年10月22日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SalaryTest {
	@Autowired
	private SalaryService salaryService;
	
	@Test
	public void SalaryServiceSave() {
		SalaryDTO  salaryDTO  = new SalaryDTO();
		Date now = new Date();
		salaryDTO.setCreateTime(now);
		salaryService.insertSalary(salaryDTO);
	}
	
	@Test
	public void SalaryServiceUpdata() {
		Salary  salary  = salaryService.findSalaryById(1L);
		Date now = new Date();
		salary.setCreateTime(now);
		SalaryDTO salaryDTO = new SalaryDTO();
		BeanUtils.copyProperties(salary, salaryDTO);
		salaryService.insertSalary(salaryDTO);
	}
	
	@Test
	public void SalaryServiceDelete() {
		salaryService.deleteSalary(1L);
	}
	
	@Test
	public void PerformanceFindAll() {
		ExtjsPageRequest pageRequest = new ExtjsPageRequest();
		pageRequest.setPage(1);
		salaryService.findAll(null,pageRequest.getPageable());
	}
}
