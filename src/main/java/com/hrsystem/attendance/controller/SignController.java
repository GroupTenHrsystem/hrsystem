package com.hrsystem.attendance.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.attendance.entity.Attendance;
import com.hrsystem.attendance.entity.Sign;
import com.hrsystem.attendance.entity.DTO.SignDTO;
import com.hrsystem.attendance.service.IAttendanceService;
import com.hrsystem.attendance.service.ISignService;
import com.hrsystem.attendance.util.JudgeState;
import com.hrsystem.common.ExtAjaxResponse;
import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.common.SessionUtil;
import com.hrsystem.common.specificationBuilder.SpecificationBuilder;

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
				Date date=new Date();
				sign.setStarTime(date);
				String name=SessionUtil.getUserName(session);
				sign.setName(name);
				JudgeState judgeState=new JudgeState();
				if(judgeState.judgeDelate(date)) {                         //判断是否迟到
					sign.setState("正常");					
				}else {
					sign.setState("迟到");
					List<Attendance>atten =attendanceService.findAttendanceByName(name);
					for (Attendance attendance : atten) {
						attendance.setDelateCount(attendance.getDelateCount()+1);
						attendanceService.insertAttendance(attendance);
					}
					
				}
				signService.insertSign(sign);
			}else {                                                          //没加班签到，有签到
				return new ExtAjaxResponse(false,"已签到");
			}
			}else {
				if(size==0) {                                                  //有加班签到，没签到
					for (Sign sign : signFind1) {
						Date date =new  Date();
					sign.setStarTime(date);
					String name=SessionUtil.getUserName(session);
					sign.setName(name);
					JudgeState judgeState=new JudgeState();
					if(judgeState.judgeDelate(date)) {                         //判断是否迟到
						sign.setState("正常");					
					}else {
						sign.setState("迟到");
						List<Attendance>atten =attendanceService.findAttendanceByName(name);
						for (Attendance attendance : atten) {
							attendance.setDelateCount(attendance.getDelateCount()+1);
							attendanceService.insertAttendance(attendance);
						}
						
					}
					signService.insertSign(sign);
					}
				}else {                                                        //有加班签到，有签到
					return new ExtAjaxResponse(false,"已签到");
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
			List<Sign> signFind1 =signService.findEndTime(endTime);
			Integer size = signFind.size();
			Integer size1 = signFind1.size();
			if(size==0) {
				return new ExtAjaxResponse(true,"没签到，签退失败！");

			}else {
				if(size1==0) {
				for (Sign sign : signFind) {
					Date date =new Date();
					sign.setEndTime(date);
					JudgeState judgeState=new JudgeState();
					if(judgeState.judgeLeaveEarly(date)) {                         //判断是否早退
						sign.setState("正常");					
					}else {
						sign.setState("早退");
						String name=SessionUtil.getUserName(session);
						List<Attendance>atten =attendanceService.findAttendanceByName(name);
						for (Attendance attendance : atten) {
							attendance.setLeaveEarlyCount(attendance.getLeaveEarlyCount()+1);
							attendanceService.insertAttendance(attendance);
						}		
					}
					String name=SessionUtil.getUserName(session);
					List<Sign>sign1 =signService.findSignByName(name);
					for (Sign sign2 : sign1) {
						long totleTime =judgeState.judgeTotalTime(sign2.getStarTime(),sign2.getEndTime());
						List<Attendance>atten =attendanceService.findAttendanceByName(name);
						for (Attendance attendance : atten) {
							attendance.setTotalTime(attendance.getTotalTime()+totleTime);
							attendanceService.insertAttendance(attendance);
						}
						
					}
					signService.insertSign(sign);
				}
				
				return new ExtAjaxResponse(true,"签退成功！");
			}else {
				return new ExtAjaxResponse(false,"已签退");
			}
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
				return new ExtAjaxResponse(false,"已签到");
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
					return new ExtAjaxResponse(false,"已签到");
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
			List<Sign> signFind1 =signService.findExtraEndTime(extraEndTime);
			Integer size = signFind.size();
			Integer size1 = signFind1.size();
			if(size==0) {
				return new ExtAjaxResponse(true,"没签到，签退失败！");

			}else {
				if(size1==0) {
				for (Sign sign : signFind) {
					sign.setExtraEndTime(new Date());
					signService.insertSign(sign);
				}
				JudgeState judgeState =new JudgeState();
				String name=SessionUtil.getUserName(session);
				List<Sign>sign1 =signService.findSignByName(name);
				for (Sign sign2 : sign1) {
					long totleTime =judgeState.judgeTotalTime(sign2.getExtraStarTime(),sign2.getExtraEndTime());
					List<Attendance>atten =attendanceService.findAttendanceByName(name);
					for (Attendance attendance : atten) {
						attendance.setExtraTime(attendance.getExtraTime()+totleTime);
						attendanceService.insertAttendance(attendance);
					}
					
				}
				return new ExtAjaxResponse(true,"签退成功！");
			}else {
				return new ExtAjaxResponse(false,"已签退！");
			}
				}
						} catch (Exception e) {
				return new ExtAjaxResponse(true,"失败！");
			}
		}
		
		
		
		
		
		
//		
//		@RequestMapping(value = "/test")
//		public void  test() 
//		{
//			JudgeState judgeState=new JudgeState();
//			
//			judgeState.judgeTotalTime();
//
//			
//		}
}
