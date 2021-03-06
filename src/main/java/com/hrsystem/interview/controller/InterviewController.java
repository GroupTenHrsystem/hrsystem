package com.hrsystem.interview.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
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
import com.hrsystem.interview.entity.InterviewQueryDTO;
import com.hrsystem.interview.service.IInterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {
	@Autowired
	private IInterviewService interviewService;
	
	@GetMapping
	public Page<Interview> getPage(InterviewQueryDTO interviewQueryDTO,ExtjsPageRequest pageRequest){
		return interviewService.findAll(interviewQueryDTO.getWhereClause(interviewQueryDTO), pageRequest.getPageable());
	}
	
	@GetMapping(value="{id}")
	public Interview getOne(@PathVariable("id") Long id) 
	{
		return interviewService.findById(id).get();
	}
	
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExtAjaxResponse update(@PathVariable("id") Long myId,@RequestBody Interview dto) 
	{
		try {
			Interview entity = interviewService.findById(myId).get();
			if(entity!=null) {
				BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
				interviewService.save(entity);
			}
			return new ExtAjaxResponse(true,"更新成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"更新失败！");
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExtAjaxResponse save(@RequestBody Interview interview) 
	{
		try {
			interviewService.save(interview);
			return new ExtAjaxResponse(true,"保存成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"保存失败！");
		}
	}	

}
