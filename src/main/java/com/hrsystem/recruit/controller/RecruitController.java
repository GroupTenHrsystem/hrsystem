package com.hrsystem.recruit.controller;

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
import com.hrsystem.recruit.entity.Recruit;
import com.hrsystem.recruit.entity.RecruitQueryDTO;
import com.hrsystem.recruit.service.IRecruitService;

@RestController
@RequestMapping("/recruit")
public class RecruitController {

	@Autowired
	private IRecruitService recruitService;
	
	@GetMapping
	public Page<Recruit> getPage(RecruitQueryDTO recruitQueryDTO,ExtjsPageRequest pageRequest){
		return recruitService.findAll(RecruitQueryDTO.getWhereClause(recruitQueryDTO), pageRequest.getPageable());
	}
	
	@GetMapping(value="{id}")
	public Recruit getOne(@PathVariable("id") Long id) 
	{
		return recruitService.findById(id).get();
	}
	
	@DeleteMapping(value="{id}")
	public ExtAjaxResponse delete(@PathVariable("id") Long id) 
	{
		try {
			if(id!=null) {
				recruitService.deleteById(id);
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
				recruitService.deleteAll(ids);
			}
			return new ExtAjaxResponse(true,"批量删除成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"批量删除失败！");
		}
	}
	
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExtAjaxResponse update(@PathVariable("id") Long myId,@RequestBody Recruit dto) 
	{
		try {
			Recruit entity = recruitService.findById(myId).get();
			if(entity!=null) {
				BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
				recruitService.save(entity);
			}
			return new ExtAjaxResponse(true,"更新成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"更新失败！");
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExtAjaxResponse save(@RequestBody Recruit recruit) 
	{
		try {
			recruitService.save(recruit);
			return new ExtAjaxResponse(true,"保存成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"保存失败！");
		}
	}	
	
	@RequestMapping(value="testRecruit")
	public void testRecruit() {
		try {
			Recruit recruit = new Recruit();
			recruit.setDepartmentname("人事部");
			recruit.setPosition("经理");
			recruit.setPlanNum(3L);
			recruit.setStartTime(new Date());
			recruit.setEditName("Miette");
			
			recruitService.save(recruit);
	
		} catch (Exception e) {
		}
	}
	
}
