package com.hrsystem.training.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
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
import com.hrsystem.training.domain.Enroll;
import com.hrsystem.training.domain.EnrollQueryDTO;
import com.hrsystem.training.domain.Feedback;
import com.hrsystem.training.domain.Training;
import com.hrsystem.training.domain.TrainingQueryDTO;
import com.hrsystem.training.service.IEnrollService;
import com.hrsystem.user.entity.Staff;

@RestController
@RequestMapping("/enroll")
public class EnrollController {
	@Autowired
	private IEnrollService enrollService;
	/**
	 * 1、查
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public Enroll getEnrollById(@PathVariable Long id) {
		return enrollService.findEnrollById(id);
	}
	
	/**
	 * 2、增
	 * @param Performance
	 * @return
	 */
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertEnroll(@RequestBody Enroll enroll) {		
		try {
				//if{存在课程ID/enrollService.insertEnroll(enroll);return "success:添加成功";}else{return "success:添加失败";}
				enrollService.insertEnroll(enroll);
				return "success:添加成功";
		} catch (Exception e) {
			return "success:添加失败";
		}
	}
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String update(@PathVariable("id") Long myId,@RequestBody Enroll dto) 
	{
		try {
			Enroll entity = enrollService.findEnrollById(myId);
			BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
			enrollService.insertEnroll(entity);
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

	 @PostMapping("/deletes")
		public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) 
		{
		 for (Long id : ids) {
				Enroll entity = enrollService.findEnrollById(id);
				if(entity.getAuditStatus().equals("作废")) {
					//archivesService.deleteById(id);
					continue;
				} else {
					return new ExtAjaxResponse(true,"只能删除作废的报名");
				}
			}
		 		enrollService.deleteAll(ids);
			return new ExtAjaxResponse(true,"操作成功！");
		}


	    
	@GetMapping
	public Page<Enroll> getPage(EnrollQueryDTO enrollQueryDTO,ExtjsPageRequest pageRequest) 
	{
		return enrollService.findAll(EnrollQueryDTO.getWhereClause(enrollQueryDTO), pageRequest.getPageable());
	}
	@GetMapping("/enrollpass")
	public Page<Enroll> getEnrollByArstatusPass(EnrollQueryDTO enrollQueryDTO,ExtjsPageRequest pageRequest) {
		System.out.println("炸了啊");
		return enrollService.findEnrollByArstatusPass(EnrollQueryDTO.getWhereClause(enrollQueryDTO), pageRequest.getPageable());
	}
	
	@GetMapping("/enrollfind")
	public Page<Enroll> getEnrollByArstatusPassfind(EnrollQueryDTO enrollQueryDTO,ExtjsPageRequest pageRequest) {
		System.out.println("炸了啊");
		System.out.println(enrollQueryDTO.getCourseId());
		return enrollService.findEnrollByArstatusEmployeeId(enrollQueryDTO.getCourseId(),EnrollQueryDTO.getWhereClause(enrollQueryDTO), pageRequest.getPageable());
	}
	
}
