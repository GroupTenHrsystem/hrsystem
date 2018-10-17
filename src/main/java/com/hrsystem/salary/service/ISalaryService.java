package com.hrsystem.salary.service;

import com.hrsystem.salary.entity.DTO.SalaryDTO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.salary.entity.Salary;


/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: ISalaryService.java
  *@Date: 2018年9月28日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
public interface ISalaryService {
	 public Salary findSalaryById(Long id);
	 
	 public void insertSalary(SalaryDTO salaryDTO) ;

	 public void updataSalary(Salary Salary);
	
	 public void deleteSalary(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<Salary> findAll(Specification<Salary> spec, Pageable pageable);
	 
	 public List<Salary> getSalaryByStaffName(String userId);
}
