package com.hrsystem.performance.controller;
import java.io.IOException;
import java.util.ArrayList;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceController.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.DTO.PerformanceDTO;
import com.hrsystem.performance.entity.DTO.PerformanceQueryDTO;
import com.hrsystem.performance.service.IPerformanceService;
import com.hrsystem.performance.service.IPerformanceTempletService;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.service.IStaffService;

@RestController
@RequestMapping("/performance")
public class PerformanceController {
	@Autowired
	private IPerformanceService performanceService;
	
	@Autowired
	private IPerformanceTempletService performanceTempletService;
	
	@Autowired
	private IStaffService staffService;
	/**
	 * 1、查
	 * @param id
	 * @return
	 */
//	@GetMapping("/get/{id}")
//	public Performance getPerformanceById(@PathVariable Long id) {
//		return performanceService.findPerformanceById(id);
//	}
	/**
	 * 2、增
	 * @param Performance
	 * @return
	 */
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertPerformance(@RequestBody PerformanceDTO performanceDTO) {		
		try {
			List<Staff> staff = new ArrayList();
			for(int i = 0; i < performanceDTO.getStaffIds().length; ++i) {
				Optional<Staff> optional = staffService.findStaffById(performanceDTO.getStaffIds()[i]);
				if(optional.isPresent()) {
					staff.add(optional.get());
				}
			}				
			Performance entity = new Performance();
			entity.setPerformanceTemplet(performanceTempletService.findPerformanceTempletById(performanceDTO.getPerformanceTempletId()));
			BeanUtils.copyProperties(performanceDTO, entity);
			entity.setStaff(staff);
			performanceService.insertPerformance(entity);
			return "success:添加成功";
		} catch (Exception e) {
			return "success:添加失败";
		}
	}
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String update(@PathVariable("id") Long myId,@RequestBody Performance dto) 
	{
		try {
			Performance entity = performanceService.findPerformanceById(myId);
			BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
			performanceService.insertPerformance(entity);
			return "success:true";
		} catch (Exception e) {
			return "success:false";
		}
	}
	/**
	 * 3、删 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="{id}")
	public String deletePerformanceById(@PathVariable Long id) {
		try {
			performanceService.deletePerformance(id);
			return "success:删除成功";
		} catch (Exception e) {
			return "success:删除失败";
		}
	}

	@GetMapping
	public Page<Performance> getPage(PerformanceQueryDTO performanceQueryDTO,ExtjsPageRequest pageRequest) 
	{
		return performanceService.findAll(PerformanceQueryDTO.getWhereClause(performanceQueryDTO), pageRequest.getPageable());
	}

	/*导出excel文档*/
	@RequestMapping("/downloadExcel")
	public void downloadExcel(HttpServletRequest request, HttpServletResponse response)throws IOException
	{
		//创建工作簿
		XSSFWorkbook wb = new XSSFWorkbook();
		//创建sheet
		XSSFSheet sheet = wb.createSheet();
		//设置列宽 	sheet.setColumnWidth(0, 252*width+323);//width=35
		sheet.setColumnWidth(1, 256*14+184);
		sheet.setColumnWidth(2, 256*20+184);
		sheet.setColumnWidth(3, 256*20+184);
		// 单元格样式
		XSSFCellStyle style =  wb.createCellStyle();

		//从数据库查找绩效
		Pageable pageable = PageRequest.of(0, 25);
		Page<Performance> performancePage = performanceService.findAll(null,pageable);
		Iterator<Performance> iterator = performancePage.iterator();
		System.out.println(performancePage.getTotalElements());
		int rowSum = 2 + (int)performancePage.getTotalElements();
		//初始化单元格
		for (int i = 0; i < rowSum; i++) { //需要6行表格
			Row row =	sheet.createRow(i); //创建行
			for (int j = 0; j < 10; j++) {//需要6列
				row.createCell(j).setCellStyle(style);
			}
		}

		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));//合并单元格，cellRangAddress四个参数，第一个起始行，第二终止行，第三个起始列，第四个终止列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 5));
		//tian入数据
		XSSFRow row = sheet.getRow(0); //获取第一行
		row.getCell(1).setCellValue("绩效考核"); //在第一行中创建一个单元格并赋值
		XSSFRow row1 = sheet.getRow(1); //获取第二行，为每一列添加字段上
		row1.getCell(1).setCellValue("绩效考核名字");
		row1.getCell(2).setCellValue("开始时间");
		row1.getCell(3).setCellValue("结束时间");
		row1.getCell(4).setCellValue("考核周期");
		row1.getCell(5).setCellValue("待归档人数");

        Performance result;
		XSSFRow currentRow;
		CellStyle cellStyle = wb.createCellStyle();		//单元格样式
		CreationHelper creationHelper = wb.getCreationHelper();
		cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd  hh:mm:ss"));
		int i = 2;
        while(iterator.hasNext()){
			currentRow = sheet.getRow(i);
			result = (Performance) iterator.next();
			currentRow.getCell(0).setCellValue(i - 1);
			currentRow.getCell(1).setCellValue(result.getPerformanceName());
			currentRow.getCell(2).setCellStyle(cellStyle);
			currentRow.getCell(2).setCellValue(result.getStartTime());
			currentRow.getCell(3).setCellStyle(cellStyle);
			currentRow.getCell(3).setCellValue(result.getEndTime());
			currentRow.getCell(4).setCellValue(result.getCycle());
			currentRow.getCell(5).setCellValue(result.getStaff().size());
            ++i;
        }
		response.setHeader("Content-disposition", "attachment; filename=" + java.net.URLEncoder.encode("等死.xlsx", "UTF-8"));//默认Excel名称
		response.flushBuffer();
		wb.write(response.getOutputStream());
	}
}
