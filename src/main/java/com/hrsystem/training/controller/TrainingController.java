package com.hrsystem.training.controller;



import java.util.Date;
import java.util.List;

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

import com.hrsystem.archives.domain.Archives;
import com.hrsystem.archives.domain.ArchivesQueryDTO;
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
	/**
	 * 1、查
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public Training getTrainingById(@PathVariable Long id) {
		return trainingService.findTrainingById(id);
	}
	
	@GetMapping("/trainingpass")
	public Page<Training> getTrainingByArstatusPass(TrainingQueryDTO trainingQueryDTO,ExtjsPageRequest pageRequest) {
		System.out.println("炸了啊");
		return trainingService.findTrainingByArstatusPass(TrainingQueryDTO.getWhereClause(trainingQueryDTO), pageRequest.getPageable());
	}
	/**
	 * 2、增
	 * @param Performance
	 * @return
	 */
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertTraining(@RequestBody Training training) {		
		try {
			trainingService.insertTraining(training);
			return "success:添加成功";
		} catch (Exception e) {
			return "success:添加失败";
		}
	}
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String update(@PathVariable("id") Long myId,@RequestBody Training dto) 
	{
		try {
			Training entity = trainingService.findTrainingById(myId);
			BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
			trainingService.insertTraining(entity);
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
				Training entity = trainingService.findTrainingById(id);
				if(entity.getCourseAuditStatus().equals("作废")) {
					//archivesService.deleteById(id);
					continue;
				} else {
					return new ExtAjaxResponse(true,"只能删除作废培训");
				}
			}
			trainingService.deleteAll(ids);
			return new ExtAjaxResponse(true,"操作成功！");
			
			
		}
	 
	@GetMapping
	public Page<Training> getPage(TrainingQueryDTO trainingQueryDTO,ExtjsPageRequest pageRequest) 
	{
		return trainingService.findAll(TrainingQueryDTO.getWhereClause(trainingQueryDTO), pageRequest.getPageable());
	}
	
	
}
