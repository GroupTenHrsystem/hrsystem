package com.hrsystem.training.controller;



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
import com.hrsystem.training.domain.Training;
import com.hrsystem.training.domain.TrainingQueryDTO;
import com.hrsystem.training.service.ITrainingService;

@RestController
@RequestMapping("/training")
public class TrainingController {
	@Autowired
	private ITrainingService trainingService;
	@GetMapping
	public Page<Training> getPage(TrainingQueryDTO trainingQueryDTO , ExtjsPageRequest pageRequest) 
	{
		return trainingService.findAll(TrainingQueryDTO.getWhereClause(trainingQueryDTO), pageRequest.getPageable());
	}
	
	@GetMapping(value="{id}")
	public Training getOne(@PathVariable("id") Long id) 
	{
		return trainingService.findById(id).get();
	}

	@DeleteMapping(value="{id}")
	public ExtAjaxResponse delete(@PathVariable("id") Long id) 
	{
		try {
			if(id!=null) {
				trainingService.deleteById(id);
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
				trainingService.deleteAll(ids);
			}
			return new ExtAjaxResponse(true,"批量删除成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"批量删除失败！");
		}
	}
	
	
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExtAjaxResponse update(@PathVariable("id") Long myId,@RequestBody Training dto) 
	{
		try {
			Training entity = trainingService.findById(myId).get();
			if(entity!=null) {
				BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
				trainingService.save(entity);
			}
			return new ExtAjaxResponse(true,"更新成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"更新失败！");
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExtAjaxResponse save(@RequestBody Training training) 
	{
		try {
			trainingService.save(training);
			return new ExtAjaxResponse(true,"保存成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"保存失败！");
		}
	}
	
	

	@RequestMapping("/datatest01")
	public String testData() {
		try {
			Training t1 = new Training();
			t1.setCourseCode(00001);
			t1.setCourseName("设计01");
			t1.setCourseLecturer("张三");
			t1.setPersonLiable("李四");
			t1.setCourseAuditor("王五");
			t1.setCourseAuditStatus("已审核");
			t1.setCourseAuditResult("通过");
			t1.setCourseAirtime(new Date());
			t1.setCourseAuditTime(new Date());
			t1.setCourseEndtime(new Date());
			Training t2 = new Training();
			t2.setCourseCode(00001);
			t2.setCourseName("设计02");
			t2.setCourseLecturer("张三");
			t2.setPersonLiable("李四");
			t2.setCourseAuditor("王五");
			t2.setCourseAuditStatus("未审核");
			t2.setCourseAuditResult("通过");
			t2.setCourseAirtime(new Date());
			t2.setCourseAuditTime(new Date());
			t2.setCourseEndtime(new Date());
			trainingService.save(t1);
			trainingService.save(t2);
			
			return "success:true";
		} catch (Exception e) {
			return "success:false";
		}
	}
}
