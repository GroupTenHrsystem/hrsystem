package com.hrsystem.report.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.report.entity.Report;
import com.hrsystem.report.repository.ReportRepository;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.service.IStaffService;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: ReportService.java
  *@Date: 2018年10月17日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Service
@Transactional
public class ReportService implements IReportService{

	
	@Autowired
	private ReportRepository reportRepository;
	
	@Autowired
	private IStaffService  staffService;
	
	@Override
	public void saveReport(Report report, String userId) {
		// TODO Auto-generated method stub
		Staff staff = staffService.findStaffByName(userId);
		report.setStaff(staff);
		reportRepository.save(report);
	}

	@Override
	public Page<Report> findAll(Specification<Report> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return reportRepository.findAll(spec, pageable);
	}

	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		reportRepository.updateAll(idLists);
	}

}
