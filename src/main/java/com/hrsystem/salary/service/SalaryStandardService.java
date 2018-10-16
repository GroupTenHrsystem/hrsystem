package com.hrsystem.salary.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.hrsystem.log.ServiceLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.salary.entity.Salary;
import com.hrsystem.salary.entity.SalaryStandard;
import com.hrsystem.salary.repository.SalaryStandardRepository;


/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: SalaryStandardService.java
  *@Date: 2018年9月28日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Service
@Transactional
public class SalaryStandardService implements ISalaryStandardService{
	@Autowired
	SalaryStandardRepository salaryStandardRepository;
	@ServiceLogs(description = "查找薪资模板通过id")
	public SalaryStandard findSalaryStandardById(Long id) {
		// TODO Auto-generated method stub
		 Optional<SalaryStandard> salaryStandard = salaryStandardRepository.findById(id);
		    if (!salaryStandard.isPresent()) {
		        return null;
		    }
		    return salaryStandard.get();
	}

	@Override
	@ServiceLogs(description = "插入薪资模板")
	public void insertSalaryStandard(SalaryStandard salaryStandard) {
		// TODO Auto-generated method stub
		salaryStandardRepository.save(salaryStandard);     
	}

	@Override
	@ServiceLogs(description = "删除薪资模板（单个")
	public void deleteSalaryStandard(Long id) {
		// TODO Auto-generated method stub
		
		Optional<SalaryStandard> optional = salaryStandardRepository.findById(id);
		if(optional.isPresent()) {
			SalaryStandard salaryStandard = optional.get();
			salaryStandard.setStatus(false);
			salaryStandardRepository.save(salaryStandard);
		}else {
			return;
		}
		//salaryStandardRepository.deleteById(id);
	}
 
	@Override
	@ServiceLogs(description = "删除薪资模板（多个")
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		salaryStandardRepository.updateAll(idLists);
	}

	@Override
	@ServiceLogs(description = "薪资模板找全部")
	public Page<SalaryStandard> findAll(Specification<SalaryStandard> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return salaryStandardRepository.findAll(spec, pageable);
	}

}
