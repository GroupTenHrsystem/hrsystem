package com.hrsystem.salary.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.specificationBuilder.SpecificationBuilder;
import com.hrsystem.performance.entity.DTO.PerformanceQueryDTO;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.repository.PerformanceRepository;
import com.hrsystem.salary.entity.DTO.SalaryDTO;
import com.hrsystem.salary.entity.SalaryStandard;
import com.hrsystem.salary.repository.SalaryStandardRepository;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.repository.StaffRepository;
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
	@Autowired
	SalaryStandardRepository salaryStandardRepository;
	@Autowired
	StaffRepository staffRepository;
	@Autowired
	PerformanceRepository performanceRepository;
	public Salary findSalaryById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Salary> Salary = salaryRepository.findById(id);
		    if (!Salary.isPresent()) {
		        return null;
		    }
		    return Salary.get();
	}
	@Override
	public void insertSalary(SalaryDTO salaryDTO) {
		// TODO Auto-generated method stub
		//批量插入，数据转换
		Date now = new Date();
		LocalDate localDate=now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Date newDate=java.sql.Date.valueOf(localDate);
		SalaryStandard salaryStandard = salaryStandardRepository.findById(salaryDTO.getSalaryStandardId()).get();
		for(int i = 0; i < salaryDTO.getStaffIds().length; ++i) {
			Staff optional = staffRepository.findById(salaryDTO.getStaffIds()[i]).get();


			/*
			 *	计算绩效工资加成
			 *
			 */
			List<Performance> performanceList = performanceRepository.getPerformanceByStaffAndTime(optional.getId(),salaryDTO.getSalaryStarTime(),salaryDTO.getSalaryEndTime());
			Iterator iter = performanceList.iterator();
			Double performancesSalary = 0.0;
			while(iter.hasNext()) {
				Performance performance=(Performance)iter.next();
				if(performance.getResultScore()!=null)
					performancesSalary += performance.getResultScore() * salaryStandard.getKpi();
			}
			Double salarySum = performancesSalary + salaryStandard.getBasis();


			/*
			 *	数据库插入工资
			 */
			if(optional != null) {
				Salary salary = new Salary();
				salary.setCreateTime(newDate);
				salary.setStaff(optional);
				salary.setSalaryStandard(salaryStandard);
				BeanUtils.copyProperties(salaryDTO, salary);
				salary.setSalarySum(salarySum);
				salaryRepository.save(salary);
			}
		}
	}
	@Override
	public void updataSalary(Salary Salary) {
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
