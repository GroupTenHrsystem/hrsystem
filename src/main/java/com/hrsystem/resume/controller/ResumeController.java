package com.hrsystem.resume.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
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
import com.hrsystem.resume.entity.Resume;
import com.hrsystem.resume.entity.ResumeDTO;
import com.hrsystem.resume.entity.ResumeIntoStaffDTO;
import com.hrsystem.resume.entity.ResumeQueryDTO;
import com.hrsystem.resume.service.IResumeService;
import com.hrsystem.salary.entity.Salary;

//@Component
@RestController
@RequestMapping("/resume")
@Transactional
public class ResumeController {

	@Autowired
	private IResumeService resumeService;
	
	@GetMapping
	public Page<Resume> getPage(ResumeQueryDTO resumeQueryDTO,ExtjsPageRequest pageRequest){
		return resumeService.findAll(ResumeQueryDTO.getWhereClause(resumeQueryDTO), pageRequest.getPageable());
	}
	
	@GetMapping("/employ")
	public Page<Resume> getPage2(ResumeQueryDTO resumeQueryDTO,ExtjsPageRequest pageRequest){
		return resumeService.findAll("COMPLETE", ResumeQueryDTO.getWhereClause(resumeQueryDTO),pageRequest.getPageable());
		//return resumeService.findAll(ResumeQueryDTO.getWhereClause(resumeQueryDTO), pageRequest.getPageable());
	}
	
	@RequestMapping("/getEduation")
	public Map<String, Long> getEduationPage(){
		Map<String, Long> map =  new HashMap<String,Long>(); 
		map.put("博士",resumeService.count("博士"));
		map.put("硕士",resumeService.count("硕士"));
		map.put("本科",resumeService.count("本科"));
		map.put("教授",resumeService.count("教授"));
		map.put("专科",resumeService.count("专科"));
		map.put("专科以下",resumeService.count("专科以下"));
		//System.out.println(boshi);
		//return resumeService.count("博士");
		return map;
	}
	
	@GetMapping(value="{id}")
	public Resume getOne(@PathVariable("id") Long id) 
	{
		return resumeService.findById(id).get();
	}

	@DeleteMapping(value="{id}")
	public ExtAjaxResponse delete(@PathVariable("id") Long id) 
	{
		try {
			if(id!=null) {
				resumeService.deleteById(id);
			}
			return new ExtAjaxResponse(true,"删除成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"删除失败！");
		}
	}
	
	@PostMapping("/deletes")
	public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) 
	{
		try {
			if(ids!=null) {
				resumeService.deleteAll(ids);
			}
			return new ExtAjaxResponse(true,"批量删除成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"批量删除失败！");
		}
	}
	
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExtAjaxResponse update(@PathVariable("id") Long myId,@RequestBody Resume dto) 
	{
		try {
			Resume entity = resumeService.findById(myId).get();
			if(entity!=null) {
				BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
				resumeService.save(entity);
			}
			return new ExtAjaxResponse(true,"更新成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"更新失败！");
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExtAjaxResponse save(@RequestBody Resume resume) 
	{
		try {
			resumeService.save(resume);
			return new ExtAjaxResponse(true,"保存成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"保存失败！");
		}
	}

	@PostMapping("/employ")
	public ExtAjaxResponse saveIntoUser(ResumeIntoStaffDTO resumeIntoStaffDTO) 
	{
		try {
			resumeService.saveIntoUser(resumeIntoStaffDTO);
			return new ExtAjaxResponse(true,"保存成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"保存失败！");
		}
	}
	
/*-------------------------------------流程引擎web层------------------------------------------*/
	
	/**
	 * 启动流程
	 * @param leaveId	请假信息Id
	 * @param session	通过会话获取登录用户(请假人)
	 * @return
	 */
	@RequestMapping(value = "/start")
    public @ResponseBody ExtAjaxResponse start(@RequestParam(name="id") Long resumeId,HttpSession session) {
    	try {
    		String userId = SessionUtil.getUserName(session);
    		//System.out.println(resumeId);
    		Map<String, Object> variables = new HashMap<String, Object>();
    		variables.put("deptLeader", "financeClerk");
    		variables.put("hrClerk", "financeManager");
    		variables.put("applyUserId", userId);
    		resumeService.startWorkflow(userId,resumeId, variables);
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
    public @ResponseBody Page<ResumeDTO> findTodoTasks(HttpSession session, ExtjsPageRequest pageable) {
		Page<ResumeDTO> page = new PageImpl<ResumeDTO>(new ArrayList<ResumeDTO>(), pageable.getPageable(), 0);
    	try {
    		page = resumeService.findTodoTasks(SessionUtil.getUserName(session), pageable.getPageable());
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
    	
    	return page;
    }
	
	/**
     * 签收任务
     */
    @RequestMapping(value = "claim/{id}")
    public @ResponseBody ExtAjaxResponse claim(@PathVariable("id") String taskId, HttpSession session) {
    	try{
    		resumeService.claim(taskId, SessionUtil.getUserName(session));
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
    public @ResponseBody ExtAjaxResponse complete(@PathVariable("taskId") String taskId, WorkflowVariable var,Long id) {
    	try{
    		Map<String, Object> variables = var.getVariableMap();
    		resumeService.complete(taskId, variables,id);
	    	return new ExtAjaxResponse(true,"审批成功!");
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return new ExtAjaxResponse(false,"审批失败!");
	    }
    }

}
