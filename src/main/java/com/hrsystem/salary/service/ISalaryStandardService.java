package com.hrsystem.salary.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.salary.entity.SalaryStandard;


/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: ISalaryStandardService.java
  *@Date: 2018年9月28日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
public interface ISalaryStandardService {
	public SalaryStandard findSalaryStandardById(Long id);
	 
	 public void insertSalaryStandard(SalaryStandard salaryStandard) ;
	 
	 public void deleteSalaryStandard(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<SalaryStandard> findAll(Specification<SalaryStandard> spec, Pageable pageable);
}
