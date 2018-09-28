package com.hrsystem.salary.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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
public class SalaryStandardService implements ISalaryStandardService{
	@Autowired
	SalaryStandardRepository salaryStandardRepository;
	public SalaryStandard findSalaryStandardById(Long id) {
		// TODO Auto-generated method stub
		 Optional<SalaryStandard> salaryStandard = salaryStandardRepository.findById(id);
		    if (!salaryStandard.isPresent()) {
		        return null;
		    }
		    return salaryStandard.get();
	}

	@Override
	public void insertSalaryStandard(SalaryStandard salaryStandard) {
		// TODO Auto-generated method stub
		salaryStandardRepository.save(salaryStandard);     
	}

	@Override
	public void deleteSalaryStandard(Long id) {
		// TODO Auto-generated method stub
		salaryStandardRepository.deleteById(id);
	}
 
	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		
		List<SalaryStandard> salaryStandard = (List<SalaryStandard>) salaryStandardRepository.findAllById(idLists);
		salaryStandardRepository.deleteAll(salaryStandard);
	}

	@Override
	public Page<SalaryStandard> findAll(Specification<SalaryStandard> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return salaryStandardRepository.findAll(spec, pageable);
	}

}
