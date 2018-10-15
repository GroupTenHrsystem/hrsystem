package com.hrsystem.salary.service;

import java.text.DecimalFormat;
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
		SalaryStandard salaryStandard = salaryStandardRepository.findById(salaryDTO.getSalaryStandardId()).get();	//查出薪资计算标准
		//保留两位小数
		DecimalFormat df = new DecimalFormat("#.00");
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
			Double basis = salaryStandard.getBasis();
			performancesSalary = Double.parseDouble(df.format(performancesSalary));

			Double salarySum = performancesSalary + basis;

			/*
			 *	扣除五险一金
			 *
			 */
			//养老保险
			 Double pension 	= salarySum * salaryStandard.getPensionBenefits();
			pension = Double.parseDouble(df.format(pension));

			//生育保险比例
			Double maternity 	= salarySum * salaryStandard.getMaternityBenefits();
			maternity = Double.parseDouble(df.format(maternity));

			//医疗保险
			Double medicare		= salarySum * salaryStandard.getMedicareBenefits();
			medicare = Double.parseDouble(df.format(medicare));

			//失业保险
			Double unemployment = salarySum * salaryStandard.getUnemploymentBenefits();
			unemployment = Double.parseDouble(df.format(unemployment));

			//工伤保险
			Double injury 		= salarySum * salaryStandard.getInjuryBenefits();
			injury = Double.parseDouble(df.format(injury));

			//住房公积金
			Double house 		= salarySum * salaryStandard.getHouseFund();
			house = Double.parseDouble(df.format(house));

			salarySum = salarySum - pension - medicare - maternity - unemployment - injury - house;
			/*
			 *	数据库插入工资
			 */
			if(optional != null) {
				Salary salary = new Salary();
				BeanUtils.copyProperties(salaryDTO, salary);
				salary.setCreateTime(newDate);
				salary.setStaff(optional);
				salary.setSalaryStandard(salaryStandard);
				salary.setPension(pension);
				salary.setMedicare(medicare);
				salary.setMaternity(maternity);
				salary.setInjury(injury);
				salary.setUnemployment(unemployment);
				salary.setHouse(house);
				salary.setPerformancesSalary(performancesSalary);
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
