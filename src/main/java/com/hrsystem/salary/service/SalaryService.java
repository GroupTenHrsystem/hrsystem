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

import com.hrsystem.salary.entity.Salary;
import com.hrsystem.salary.repository.SalaryRepository;



/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: SalaryService.java
  *@Date: 2018年9月28日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Service
public class SalaryService implements ISalaryService{
	@Autowired
	SalaryRepository salaryRepository;
	public Salary findSalaryById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Salary> Salary = salaryRepository.findById(id);
		    if (!Salary.isPresent()) {
		        return null;
		    }
		    return Salary.get();
	}

	@Override
	public void insertSalary(Salary Salary) {
		// TODO Auto-generated method stub
		salaryRepository.save(Salary);     
	}

	@Override
	public void deleteSalary(Long id) {
		// TODO Auto-generated method stub
		salaryRepository.deleteById(id);
	}
 
	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		
		List<Salary> Salary = (List<Salary>) salaryRepository.findAllById(idLists);
		salaryRepository.deleteAll(Salary);
	}

	@Override
	public Page<Salary> findAll(Specification<Salary> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return salaryRepository.findAll(spec, pageable);
	}

}
