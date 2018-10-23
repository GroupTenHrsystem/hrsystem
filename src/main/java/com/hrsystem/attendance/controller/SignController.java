package com.hrsystem.attendance.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.attendance.entity.Attendance;
import com.hrsystem.attendance.entity.Sign;
import com.hrsystem.attendance.entity.DTO.SignDTO;
import com.hrsystem.attendance.service.IAttendanceService;
import com.hrsystem.attendance.service.ISignService;
import com.hrsystem.common.ExtAjaxResponse;
import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.common.SessionUtil;
import com.hrsystem.common.specificationBuilder.SpecificationBuilder;
import com.hrsystem.user.entity.Staff;

@RestController
@RequestMapping("/Sign")
public class SignController {

	@Autowired
	ISignService signService;
	
	@Autowired
	IAttendanceService attendanceService;
	
	//查
		@GetMapping
		public Page<Sign> getPage(SignDTO signDTO, ExtjsPageRequest pageRequest, HttpSession session  ) 
		{
			String name=SessionUtil.getUserName(session);
				signDTO.setName(name);
			Specification buildSpecification = SpecificationBuilder.buildSpecification(signDTO);
			return signService.findAll(buildSpecification, pageRequest.getPageable());
			
		}
		@RequestMapping(value = "/getOne")
		public List<Attendance> getOne(HttpSession session) 
		{
			String name=SessionUtil.getUserName(session);
			return attendanceService.findAttendanceByName(name);
			
		}
		//签到
		@RequestMapping(value = "/signIn")
		public ExtAjaxResponse  signIn(@RequestParam(name="starTime") String starTime,HttpSession session) 
		{

			try {
			List<Sign> signFind =signService.findStarTime(starTime);//签到
			
			List<Sign> signFind1 =signService.findExtraStarTime(starTime);//加班签到
			Integer size1 = signFind1.size();  
			
			Integer size = signFind.size();
			if(size1==0) {
			if(size==0) {                                                   //没有加班签到，也没签到
				Sign sign = new Sign();
				sign.setStarTime(new Date());
				String name=SessionUtil.getUserName(session);
				sign.setName(name);
				signService.insertSign(sign);
			}else {                                                          //没加班签到，有签到
				for (Sign sign : signFind) {
					sign.setStarTime(new Date());
					signService.insertSign(sign);
				}
			}
			}else {
				if(size==0) {                                                  //有加班签到，没签到
					for (Sign sign : signFind1) {
					sign.setStarTime(new Date());
					String name=SessionUtil.getUserName(session);
					sign.setName(name);
					signService.insertSign(sign);
					}
				}else {                                                        //有加班签到，有签到
					for (Sign sign : signFind) {
						sign.setStarTime(new Date());
						signService.insertSign(sign);
					}
				}
			}
			return new ExtAjaxResponse(true,"签到成功！");
			} catch (Exception e) {
				return new ExtAjaxResponse(true,"签到失败！");
			}
		}
		//签退
		@RequestMapping(value = "/signBack")
		public ExtAjaxResponse  signBack(@RequestParam(name="endTime") String endTime,HttpSession session) 
		{

			try {
			List<Sign> signFind =signService.findStarTime(endTime);
			Integer size = signFind.size();
			if(size==0) {
				return new ExtAjaxResponse(true,"没签到，签退失败！");

			}else {
				for (Sign sign : signFind) {
					sign.setEndTime(new Date());
					signService.insertSign(sign);
				}
				return new ExtAjaxResponse(true,"签退成功！");
			}
						} catch (Exception e) {
				return new ExtAjaxResponse(true,"失败！");
			}
		}
		//加班签到
		@RequestMapping(value = "/extraSignIn")
		public ExtAjaxResponse  extraSignIn(@RequestParam(name="extraStarTime") String extraStarTime,HttpSession session) 
		{

			try {
			List<Sign> signFind1 =signService.findStarTime(extraStarTime);
			Integer size1 = signFind1.size();			                      //判断是否已经签到了
			
			List<Sign> signFind =signService.findExtraStarTime(extraStarTime);
			Integer size = signFind.size();                                   //判断是否已经加班签到了
			if(size1==0) {
			if(size==0) {                                                //没签到，没加班签到
				Sign sign = new Sign();
				sign.setExtraStarTime(new Date());            
				String name=SessionUtil.getUserName(session);
				sign.setName(name);
				signService.insertSign(sign);

			}else {                                                        //没签到，有加班签到
				for (Sign sign : signFind) {
					sign.setExtraStarTime(new Date());
					signService.insertSign(sign);
				}
			}
			}else {
				if(size==0) {                                               //有签到，没加班签到
					for (Sign sign : signFind1) {
					
					sign.setExtraStarTime(new Date());
					String name=SessionUtil.getUserName(session);
					sign.setName(name);
					signService.insertSign(sign);
					}
				}else {                                                      //有签到，有加班签到
					for (Sign sign : signFind) {
						sign.setExtraStarTime(new Date());
						signService.insertSign(sign);
					}
				}
			}
			return new ExtAjaxResponse(true,"加班签到成功！");
						} catch (Exception e) {
				return new ExtAjaxResponse(true,"加班签到失败！");
			}
		}
		//加班签退
		@RequestMapping(value = "/extraSignBack")
		public ExtAjaxResponse  extraSignBack(@RequestParam(name="extraEndTime") String extraEndTime,HttpSession session) 
		{

			try {
			List<Sign> signFind =signService.findExtraStarTime(extraEndTime);
			Integer size = signFind.size();
			if(size==0) {
				return new ExtAjaxResponse(true,"没签到，签退失败！");

			}else {
				for (Sign sign : signFind) {
					sign.setExtraEndTime(new Date());
					signService.insertSign(sign);
				}
				return new ExtAjaxResponse(true,"签退成功！");
			}
						} catch (Exception e) {
				return new ExtAjaxResponse(true,"失败！");
			}
		}
}
