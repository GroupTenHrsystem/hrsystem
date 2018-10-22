package com.hrsystem.performance.controller;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.hrsystem.log.ControllerLogs;
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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.activiti.util.WorkflowVariable;
import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtAjaxResponse;
import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.common.SessionUtil;
import com.hrsystem.common.specificationBuilder.SpecificationBuilder;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.PerformanceTemplet;
import com.hrsystem.performance.entity.DTO.PerformanceDTO;
import com.hrsystem.performance.entity.DTO.PerformanceQueryDTO;
import com.hrsystem.performance.entity.DTO.PerformanceRelateDTO;
import com.hrsystem.performance.service.IPerformanceService;
import com.hrsystem.performance.service.IPerformanceTempletService;
import com.hrsystem.user.entity.Department;
import com.hrsystem.user.entity.Role;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.service.IDepartmentService;
import com.hrsystem.user.service.IStaffService;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceController.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@RestController
@RequestMapping("/performance")
@Transactional
public class PerformanceController {
	@Autowired
	private IPerformanceService performanceService;
	
	@Autowired
	private IPerformanceTempletService performanceTempletService;

	@Autowired
	private IStaffService  staffService;
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
	@ControllerLogs(description = "绩效考核插入")
	public String insertPerformance(HttpSession session,@RequestBody PerformanceDTO performanceDTO) {		
		try {
			String userId = SessionUtil.getUserName(session);
    		if(userId!=null) {
    				performanceDTO.setUserId(userId);
					PerformanceTemplet performanceTemplet = performanceTempletService.findPerformanceTempletById(performanceDTO.getPerformanceTempletId());
					for(int i = 0; i < performanceDTO.getStaffIds().length; ++i) {
						Staff optional = staffService.findStaffById(performanceDTO.getStaffIds()[i]);
						if(optional != null) {
							Performance entity = new Performance();
							entity.setPerformanceTemplet(performanceTemplet);
							BeanUtils.copyProperties(performanceDTO, entity);
							entity.setStaff(optional);
							entity.setProcessStatus(ProcessStatus.NEW);
							entity.setStatus(true);
							performanceService.insertPerformance(entity);
						}
					}				
				
    		}
					return "success:添加成功";
		} catch (Exception e) {
			return "success:添加失败";
		}
	}
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	@ControllerLogs(description = "绩效考核更新")
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
	@ControllerLogs(description = "绩效考核删除单条")
	public String deletePerformanceById(@PathVariable Long id) {
		try {
			//performanceService.deletePerformance(id);
			Performance entity = performanceService.findPerformanceById(id);	//删除为status置false
			entity.setStatus(false);
			performanceService.insertPerformance(entity);
			return "success:删除成功";
		} catch (Exception e) {
			return "success:删除失败";
		}
	}
	
	@PostMapping("/deletes")
	@ControllerLogs(description = "绩效考核批量删除")
	public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) 
	{
		try {
			if(ids!=null) {
				performanceService.deleteAll(ids);
			}
			return new ExtAjaxResponse(true,"批量删除成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"批量删除失败！");
		}
	}
	
	@GetMapping
	@ControllerLogs(description = "绩效考核查询")
	public Page<PerformanceRelateDTO> getPage(PerformanceQueryDTO performanceQueryDTO,HttpSession session,ExtjsPageRequest pageRequest)
	{
	   Page<Performance> page;
	   String userId = SessionUtil.getUserName(session);
	   if(userId!=null) {
	      performanceQueryDTO.setUserId(SessionUtil.getUserName(session));
	      Specification buildSpecification = SpecificationBuilder.buildSpecification(performanceQueryDTO);
	      page = performanceService.findAll(buildSpecification, pageRequest.getPageable());
	      return PerformanceRelateDTO.toPerformanceRelateDTO(page, pageRequest.getPageable());
	   }else {
	      return new PageImpl<PerformanceRelateDTO>(new ArrayList<PerformanceRelateDTO>(),pageRequest.getPageable(),0);
	   }
	   //return performanceService.findAll(PerformanceQueryDTO.getWhereClause(performanceQueryDTO), pageRequest.getPageable());
	}
	/*查看参与的绩效考核*/
	@RequestMapping("/myPage")
	@ControllerLogs(description = "查看个人绩效")
	public Page<PerformanceRelateDTO> getMyPage(PerformanceQueryDTO performanceQueryDTO,HttpSession session,ExtjsPageRequest pageRequest)
	{
		Page<Performance> page;
		String userId = SessionUtil.getUserName(session);
		if(userId!=null) {
			page = performanceService.getMyPerformanceByStaffName(userId, pageRequest.getPageable());
			return PerformanceRelateDTO.toPerformanceRelateDTO(page, pageRequest.getPageable());
		}else {
			return new PageImpl<PerformanceRelateDTO>(new ArrayList<PerformanceRelateDTO>(),pageRequest.getPageable(),0);
		}
	}
	/*导出excel文档*/
	@RequestMapping("/downloadExcel")
	@ControllerLogs(description = "导出Excel")
	public void downloadExcel(HttpServletRequest request, HttpServletResponse response)throws IOException
	{
		performanceService.DownloadExcel(null,response);
	}
	
	
/*-------------------------------------流程引擎web层------------------------------------------*/
	
	/**
	 * 启动流程
	 * @param leaveId	请假信息Id
	 * @param session	通过会话获取登录用户(请假人)
	 * @return
	 */
	@RequestMapping(value = "/start")
	@ControllerLogs(description = "绩效考核工作流启动")
    public @ResponseBody ExtAjaxResponse start(@RequestParam(name="id") Long performanceId,HttpSession session) {
    	try {
    		String userId = SessionUtil.getUserName(session);
    		Map<String, Object> variables = new HashMap<String, Object>();
    		Performance performance = performanceService.findPerformanceById(performanceId);
    		Role role = staffService.findStaffByName(userId).getRole().getRole();
    		variables.put("deptLeader", role.getPosition());
    		variables.put("applyUserId", performance.getStaff().getStaffName());
    		performanceService.startWorkflow(userId,performanceId, variables);
    		return new ExtAjaxResponse(true,"操作成功!");
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return new ExtAjaxResponse(false,"操作失败!");
	    }
    }
	
	/**
	 * 查询待处理流程任务
	 * @param pageable	分页对象
	 * @param session	通过会话获取登录用户(请假人)
	 * @return
	 */
	@RequestMapping(value = "/tasks")
	@ControllerLogs(description = "查询待处理流程任务")
    public @ResponseBody Page<PerformanceDTO> findTodoTasks(HttpSession session,ExtjsPageRequest pageable) {
		Page<PerformanceDTO> page = new PageImpl<PerformanceDTO>(new ArrayList<PerformanceDTO>(), pageable.getPageable(), 0);
    	try {
    		page = performanceService.findTodoTasks(SessionUtil.getUserName(session), pageable.getPageable());
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
    	
    	return page;
    }
	
	/**
     * 签收任务
     */
    @RequestMapping(value = "claim/{id}")
	@ControllerLogs(description = "签收任务")
    public @ResponseBody ExtAjaxResponse claim(@PathVariable("id") String taskId, HttpSession session) {
    	try{
    		performanceService.claim(taskId, SessionUtil.getUserName(session));
	    	return new ExtAjaxResponse(true,"任务签收成功!");
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return new ExtAjaxResponse(false,"任务签收失败!");
	    }
    }
    
    /**
     * 完成任务
     * @param id
     * @return
     */
    @RequestMapping(value = "complete/{taskId}")
	@ControllerLogs(description = "完成任务")
    public @ResponseBody ExtAjaxResponse complete(@PathVariable("taskId") String taskId, Long id, WorkflowVariable var) {
    	try{
    		Map<String, Object> variables = var.getVariableMap();
    		performanceService.complete(taskId, variables, id);   		
	    	return new ExtAjaxResponse(true,"提交成功!");
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return new ExtAjaxResponse(false,"提交失败!");
	    }
    }
    
    
    
    /**
     * 下拉框选部门员工
     * @param id
     * @return
     */
    
//    @Autowired
//	private IStaffService  staffService;
//    @Autowired
//	private IDepartmentService  departmentService;
//    
//    @RequestMapping(value = "/staff")
//    public List<Staff> getStaffList(@RequestParam(name="departmentId") Long departmentId){
//		return staffService.getStaffList(departmentId);
//    }
//    
//    @RequestMapping(value = "/department")
//    public List<Department> getDepartmentList(){
//		return departmentService.getDepartmentList(null);
//    }
//    //所有子部门的ID
//    @RequestMapping(value = "/departmentAllId")
//    public List<Long> getDepartmentAllIdList(@RequestParam(name="departmentId") Long departmentId){
//    	List<Long> lists = new ArrayList<Long>();
//    	lists.add(departmentId);
//		return departmentService.findAllSubChildrensIds(lists,departmentId);
//    }
//    //部门的子部门的所有员工
//    @RequestMapping(value = "/departmentAllStaff")
//    public List<Staff> getDepartmentAllStaffList(@RequestParam(name="departmentId") Long departmentId){
//    	List<Long> lists = new ArrayList<Long>();
//    	lists.add(departmentId);
//		return departmentService.findAllSubChildrensStaffs(lists,departmentId);
//    }
    
}
