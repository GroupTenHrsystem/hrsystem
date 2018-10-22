package com.hrsystem.salary.service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.specificationBuilder.SpecificationBuilder;
import com.hrsystem.log.ServiceLogs;
import com.hrsystem.performance.entity.DTO.PerformanceQueryDTO;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.repository.PerformanceRepository;
import com.hrsystem.salary.entity.DTO.SalaryDTO;
import com.hrsystem.salary.entity.SalaryStandard;
import com.hrsystem.salary.repository.SalaryStandardRepository;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.repository.StaffRepository;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;
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
@Transactional
public class SalaryService implements ISalaryService{
	@Autowired
	SalaryRepository salaryRepository;
	@Autowired
	SalaryStandardRepository salaryStandardRepository;
	@Autowired
	StaffRepository staffRepository;
	@Autowired
	PerformanceRepository performanceRepository;

	@ServiceLogs(description = "通过id找薪资")
	public Salary findSalaryById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Salary> salary = salaryRepository.findById(id);
		    if (!salary.isPresent()) {
		        return null;
		    }
		    return salary.get();
	}
	@Override
	@ServiceLogs(description = "插入薪资")
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
			salarySum = Double.parseDouble(df.format(salarySum));
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
	@ServiceLogs(description = "更新薪资")
	public void updataSalary(Salary Salary) {
		// TODO Auto-generated method stub
		salaryRepository.save(Salary);
	}

	@Override
	@ServiceLogs(description = "删除薪资（单个")
	public void deleteSalary(Long id) {
		// TODO Auto-generated method stub
		Optional<Salary> optional = salaryRepository.findById(id);
		if(optional.isPresent()) {
			Salary salary = optional.get();
			salary.setStatus(false);
			salaryRepository.save(salary);
		}else {
			return;
		}
		//salaryRepository.deleteById(id);
	}
 
	@Override
	@ServiceLogs(description = "删除薪资（全部")
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		salaryRepository.updateAll(idLists);
	}

	@Override
	@ServiceLogs(description = "薪资找全部")
	public Page<Salary> findAll(Specification<Salary> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return salaryRepository.findAll(spec, pageable);
	}

	@Override
	@ServiceLogs(description = "通过用户名查找薪资")
	public List<Salary> getSalaryByStaffName(String userId){
		return salaryRepository.getSalaryByStaffName(userId);
	}
	@Override
	public void DownloadExcel(Specification<Salary> spec, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//创建工作簿
		XSSFWorkbook wb = new XSSFWorkbook();
		//创建sheet
		XSSFSheet sheet = wb.createSheet();
		//设置列宽 	sheet.setColumnWidth(0, 252*width+323);//width=35
		sheet.setColumnWidth(1, 256*14+184);
		sheet.setColumnWidth(2, 256*20+184);
		sheet.setColumnWidth(3, 256*20+184);
		sheet.setColumnWidth(4, 256*20+184);
		sheet.setColumnWidth(5, 256*20+184);
		// 单元格样式
		XSSFCellStyle style =  wb.createCellStyle();

		//从数据库查找绩效
		List<Salary> salaryList = salaryRepository.findAll(spec);
		Iterator<Salary> iterator = salaryList.iterator();
		System.out.println(salaryList.size());
		int rowSum = 2 + (int)salaryList.size();
		//初始化单元格
		for (int i = 0; i < rowSum; i++) { //需要n行表格
			Row row =	sheet.createRow(i); //创建行
			for (int j = 0; j < 13; j++) {//需要列数
				row.createCell(j).setCellStyle(style);
			}
		}

		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));//合并单元格，cellRangAddress四个参数，第一个起始行，第二终止行，第三个起始列，第四个终止列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 5));
		//填入数据
		XSSFRow row = sheet.getRow(0); //获取第一行
		row.getCell(1).setCellValue("绩效考核"); //在第一行中创建一个单元格并赋值
		XSSFRow row1 = sheet.getRow(1); //获取第二行，为每一列添加字段上
		row1.getCell(1).setCellValue("员工名字");
		row1.getCell(2).setCellValue("创建日期");
		row1.getCell(3).setCellValue("开始日期");
		row1.getCell(4).setCellValue("结束日期");
		row1.getCell(5).setCellValue("薪资标准");
		row1.getCell(6).setCellValue("工资");

		Salary result;
		XSSFRow currentRow;
		CellStyle cellStyle = wb.createCellStyle();		//单元格样式
		CreationHelper creationHelper = wb.getCreationHelper();
		cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd  hh:mm:ss"));
		int i = 2;
		//保留两位小数
		DecimalFormat df = new DecimalFormat("#.00");
        while(iterator.hasNext()){
			currentRow = sheet.getRow(i);
			result = (Salary) iterator.next();
			currentRow.getCell(0).setCellValue(i - 1);
			currentRow.getCell(1).setCellValue(result.getStaff().getStaffName());
			currentRow.getCell(2).setCellStyle(cellStyle);
			currentRow.getCell(2).setCellValue(result.getCreateTime());
			currentRow.getCell(3).setCellStyle(cellStyle);
			currentRow.getCell(3).setCellValue(result.getSalaryStarTime());
			currentRow.getCell(4).setCellStyle(cellStyle);
			currentRow.getCell(4).setCellValue(result.getSalaryEndTime());
			currentRow.getCell(5).setCellValue(result.getSalaryStandard().getName());
			currentRow.getCell(6).setCellValue(result.getSalarySum());
            ++i;
        }
		response.setHeader("Content-disposition", "attachment; filename=" + java.net.URLEncoder.encode("薪资.xlsx", "UTF-8"));//默认Excel名称
		response.flushBuffer();
		wb.write(response.getOutputStream());
	}
}
