package com.hrsystem.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
import com.hrsystem.training.domain.FeedbackQueryDTO;
import com.hrsystem.training.service.IFeedbackService;


@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	private IFeedbackService feedbackService;
	/**
	 * 1、查
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public Feedback getFeedbackById(@PathVariable Long id) {
		return feedbackService.findFeedbackById(id);
	}
	
	/**
	 * 2、增
	 * @param Performance
	 * @return
	 */
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertFeedback(@RequestBody Feedback feedback) {		
		try {
			
			feedbackService.insertFeedback(feedback);
			return "success:添加成功";
		} catch (Exception e) {
			return "success:添加失败";
		}
	}
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String update(@PathVariable("id") Long myId,@RequestBody Feedback dto) 
	{
		try {
			Feedback entity = feedbackService.findFeedbackById(myId);
			BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
			feedbackService.insertFeedback(entity);
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
			try {
				if(ids!=null) {
					feedbackService.deleteAll(ids);
				}
				return new ExtAjaxResponse(true,"批量删除成功！");
			} catch (Exception e) {
				return new ExtAjaxResponse(true,"批量删除失败！");
			}
		}
	 
	@GetMapping
	public Page<Feedback> getPage(FeedbackQueryDTO feedbackQueryDTO,ExtjsPageRequest pageRequest) 
	{
		return feedbackService.findAll(FeedbackQueryDTO.getWhereClause(feedbackQueryDTO), pageRequest.getPageable());
	}
	
	@GetMapping("/feedbackpass")
	public Page<Feedback> getFeedbackByEnroll(FeedbackQueryDTO feedbackQueryDTO,ExtjsPageRequest pageRequest) {
		System.out.println("炸了啊");
		return feedbackService.findFeedbackByEnroll(FeedbackQueryDTO.getWhereClause(feedbackQueryDTO), pageRequest.getPageable());
	}
	
	
}

