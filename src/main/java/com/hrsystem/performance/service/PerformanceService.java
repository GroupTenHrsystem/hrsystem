package com.hrsystem.performance.service;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceService.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.hrsystem.log.ServiceLogs;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.activiti.domain.WorkflowDTO;
import com.hrsystem.activiti.service.IWorkflowService;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.DTO.PerformanceDTO;
import com.hrsystem.performance.repository.PerformanceRepository;
@Service
@Transactional
public class PerformanceService implements IPerformanceService{
	@Autowired
	PerformanceRepository performanceRepository;
	@Autowired 
	private IWorkflowService workflowService;


	@ServiceLogs(description = "通过id查绩效")
	public Performance findPerformanceById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Performance> performance = performanceRepository.findById(id);
		    if (!performance.isPresent()) {
		        return null;
		    }
		    return performance.get();
	}

	@Override
	@ServiceLogs(description = "插入绩效")
	public void insertPerformance(Performance Performance) {
		// TODO Auto-generated method stub
		performanceRepository.save(Performance);     
	}

	@Override
	@ServiceLogs(description = "删除绩效")
	public void deletePerformance(Long id) {
		// TODO Auto-generated method stub
		performanceRepository.deleteById(id);
	}
 
	@Override
	@ServiceLogs(description = "删除全部绩效")
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		performanceRepository.updateAll(idLists);
	}

	@Override
	@ServiceLogs(description = "绩效找全部")
	public Page<Performance> findAll(Specification<Performance> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return performanceRepository.findAll(spec, pageable);
	}
	
	@Override
	@ServiceLogs(description = "通过模板id找绩效")
	 public List<Performance> getPerformanceByPerformanceTempletId(Long id){
		return performanceRepository.getPerformanceByPerformanceTempletId(id);
	 }
	
	@Override
	@ServiceLogs(description = "通过用户名找绩效")
	public Page<Performance> getMyPerformanceByStaffName(String userId, Pageable pageable){
		return performanceRepository.getMyPerformanceByStaffName(userId, pageable);
	}
	
	@Override
	@ServiceLogs(description = "导出excel")
	public void DownloadExcel(Specification<Performance> spec,HttpServletResponse response) throws IOException {
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
				List<Performance> performancePage = performanceRepository.findAll(spec);
				Iterator<Performance> iterator = performancePage.iterator();
				System.out.println(performancePage.size());
				int rowSum = 2 + (int)performancePage.size();
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
				row1.getCell(1).setCellValue("绩效考核名字");
				row1.getCell(2).setCellValue("绩效开始时间");
				row1.getCell(3).setCellValue("绩效结束时间");
				row1.getCell(4).setCellValue("发起时间");
				row1.getCell(5).setCellValue("完成时间");
				row1.getCell(6).setCellValue("被考核用户");
				row1.getCell(7).setCellValue("考核模板");
				row1.getCell(8).setCellValue("自评");
				row1.getCell(9).setCellValue("他评");
				row1.getCell(10).setCellValue("最终分数");

		        Performance result;
				XSSFRow currentRow;
				CellStyle cellStyle = wb.createCellStyle();		//单元格样式
				CreationHelper creationHelper = wb.getCreationHelper();
				cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd  hh:mm:ss"));
				int i = 2;
				//保留两位小数
				DecimalFormat df = new DecimalFormat("#.00");
		        while(iterator.hasNext()){
					currentRow = sheet.getRow(i);
					result = (Performance) iterator.next();
					currentRow.getCell(0).setCellValue(i - 1);
					currentRow.getCell(1).setCellValue(result.getPerformanceName());
					currentRow.getCell(2).setCellStyle(cellStyle);
					currentRow.getCell(2).setCellValue(result.getStartTime());
					currentRow.getCell(3).setCellStyle(cellStyle);
					currentRow.getCell(3).setCellValue(result.getEndTime());
					currentRow.getCell(4).setCellValue(result.getApplyTime());
					currentRow.getCell(4).setCellStyle(cellStyle);
					currentRow.getCell(5).setCellValue(result.getCompleteTime());
					currentRow.getCell(5).setCellStyle(cellStyle);
					currentRow.getCell(6).setCellValue(result.getStaff().getStaffName());
					currentRow.getCell(7).setCellValue(result.getPerformanceTemplet().getName());
					currentRow.getCell(8).setCellValue(result.getSelfScore());
					currentRow.getCell(9).setCellValue(result.getDeptLeaderScore());
					if(result.getResultScore()!=null)
					currentRow.getCell(10).setCellValue(Double.parseDouble(df.format(result.getResultScore())));
		            ++i;
		        }
				response.setHeader("Content-disposition", "attachment; filename=" + java.net.URLEncoder.encode("绩效考核.xlsx", "UTF-8"));//默认Excel名称
				response.flushBuffer();
				wb.write(response.getOutputStream());
	}
	/*----------------------------------------------流程业务--------------------------------------------*/
	 /**
    * 开始请假流程
    *
    * @param userId 用户ID
    * @param pageable 分页条件
    * @return
    */
	@Override
	@ServiceLogs(description = "开始绩效的工作流")
	public void startWorkflow(String userId ,Long performanceId, Map<String, Object> variables) 
	{
		//1.声明流程实例
		ProcessInstance processInstance = null;
		//2.获取创建好的请假实例
		Performance performance = performanceRepository.findById(performanceId).get();
		if(performance!=null){
			try {
				processInstance = workflowService.startWorkflow(userId, "performance", performance.getId().toString(), variables);
				performance.setProcessStatus(ProcessStatus.APPROVAL);
				performance.setProcessInstanceId(processInstance.getId());
				
				Date now = new Date();
				LocalDate localDate=now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				Date applyTime=java.sql.Date.valueOf(localDate);
				performance.setApplyTime(applyTime);
				
				performanceRepository.save(performance);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	 /**
    * 查询待办任务
    *
    * @param userId 用户ID
    * @param pageable 分页条件
    * @return
    */
	@Override
	@ServiceLogs(description = "查询待办任务")
	public Page<PerformanceDTO> findTodoTasks(String userId, Pageable pageable) 
	{
		List<PerformanceDTO> results = null;
		List<WorkflowDTO> workflowLists = workflowService.findTodoTasks(userId);
       // 根据流程的业务ID查询实体并关联
		if(null!=workflowLists) {
			results = new ArrayList<PerformanceDTO>();
			for (WorkflowDTO workflow : workflowLists) {
	        	Long businessKey = new Long(workflow.getBusinessKey());
	            if (workflow.getBusinessKey() == null) {
	                continue;
	            }
	            Performance performance = performanceRepository.findById(businessKey).get();
	            if(performance!=null){
	            	PerformanceDTO performanceDTO = new PerformanceDTO();
	            	BeanUtils.copyProperties(performance, performanceDTO);
	            	BeanUtils.copyProperties(workflow, performanceDTO);
	            	performanceDTO.setStaffName(performance.getStaff().getStaffName());
	            	results.add(performanceDTO);
	            }
	        }
		}
		return new PageImpl<PerformanceDTO> (results, pageable, null!=results?results.size():0);
	}

   /**
    * 签收流程任务
    *
    * @param taskId 任务ID
    * @param userId 签收人用户ID
    * @return
    */
    @ServiceLogs(description = "签收绩效流程任务")
	public void claim(String taskId, String userId) {
		workflowService.claim(taskId, userId);
	}

	 /**
    * 完成流程任务
    *
    * @param taskId 任务ID
    * @param variables 流程变量
    * @return
    */
	 @ServiceLogs(description = "完成绩效流程任务")
	public void complete(String taskId, Map<String, Object> variables, Long id) {
		
		Performance performance = performanceRepository.findById(id).get();
		if(variables.containsKey("selfScore")) {
			performance.setSelfScore(Double.parseDouble(String.valueOf(variables.get("selfScore"))));
			performance.setSelfScoreReason(String.valueOf(variables.get("selfScoreReason")));
		}else if(variables.containsKey("deptLeaderScore")) {
			performance.setDeptLeaderScore(Double.parseDouble(String.valueOf(variables.get("deptLeaderScore"))));
			performance.setDeptLeaderScoreReason(String.valueOf(variables.get("deptLeaderScoreReason")));
		}
		if(variables.containsKey("confirmResult")) {
			if((boolean)variables.get("confirmResult")) {
				Date now = new Date();
				LocalDate localDate=now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				Date completeTime=java.sql.Date.valueOf(localDate);
				performance.setCompleteTime(completeTime);
			}else {
				performance.setConfirmResult(String.valueOf(variables.get("resultReason")));
			}    		
		}
		performanceRepository.save(performance);
		
		workflowService.complete(taskId, variables);
	}

	@Override
	public List<Performance> findAll(Specification<Performance> spec) {
		// TODO Auto-generated method stub
		return performanceRepository.findAll(spec);
	}
}
