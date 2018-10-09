package com.hrsystem.resume.controller;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtAjaxResponse;
import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.interview.entity.Interview;
import com.hrsystem.interview.service.IInterviewService;
import com.hrsystem.resume.entity.Resume;
import com.hrsystem.resume.entity.ResumeQueryDTO;
import com.hrsystem.resume.service.IResumeService;

@Component
@RestController
@RequestMapping("/resume")
public class ResumeController {

	@Autowired
	private IResumeService resumeService;
	@Autowired
	private IInterviewService interviewService;
	
	@GetMapping
	public Page<Resume> getPage(ResumeQueryDTO resumeQueryDTO,ExtjsPageRequest pageRequest){
		return resumeService.findAll(ResumeQueryDTO.getWhereClause(resumeQueryDTO), pageRequest.getPageable());
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
	
	//@Test
	@RequestMapping(value="/testResume")
	public void testResume() {
		try {
			
			Interview interview = new Interview();
			interview.setInterviewer("Alica Hong");
			interview.setFaceResult("pass");
			interview.setEstimate("优秀");
			interview.setFaceDate(new Date());
			interview.setInterviewStatus("一面");
			
			Resume resume = new Resume();
			resume.setName("miete");
			resume.setIdCard("125635625586696596");
			resume.setEmail("819934639@qq.com");
			resume.setAddress("广东深圳");
			resume.setNativePlace("茂名");
			resume.setEducation("本科");
			resume.setReferer("12");
			
			resume.setInterview(interview);
			interviewService.save(interview);
			resumeService.save(resume);
	
		} catch (Exception e) {
		}
	}
	
}
