package com.hrsystem.attendance.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import com.hrsystem.HrsystemApplication;
import com.hrsystem.attendance.service.ISignService;

import java.util.TimerTask;
public class JudgeState {
	
	
	public  Boolean judgeDelate(Date date)                 //迟到
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
	    String strDate = sdf.format(date);
	   try { 
			long now = sdf.parse(strDate).getTime();
	        long start1 = sdf.parse("07:00:00").getTime();
	        long end1 = sdf.parse("08:35:00").getTime();
	        if (now >= start1 && now < end1) {
	        	return true;
            } else {
            	return false;
            }
	   }catch(ParseException e) {
		   e.printStackTrace();
	        throw new IllegalArgumentException("Illegal Argument");
	   }
		
	}

	public  Boolean judgeLeaveEarly(Date date)              //早退
	{
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
	    String strDate = sdf.format(date);
	   try { 
			long now = sdf.parse(strDate).getTime();
	        long start1 = sdf.parse("17:55:00").getTime();
	        long end1 = sdf.parse("18:15:00").getTime();
	        if (now >= start1 && now < end1) {
	        	return true;
            } else {
            	return false;
            }
	   }catch(ParseException e) {
		   e.printStackTrace();
	        throw new IllegalArgumentException("Illegal Argument");
	   }
		
	}
	
//	public  void judgeAbsen()                    //旷工
//	{
//		
//		
//		 Calendar calendar = Calendar.getInstance();
//	        calendar.set(Calendar.HOUR_OF_DAY, 9);
//	        calendar.set(Calendar.MINUTE, 0);
//	        calendar.set(Calendar.SECOND, 0);
//            
//	        Date time = calendar.getTime();
//            System.out.println(time);
//	        Timer timer = new Timer();
//	        timer.scheduleAtFixedRate(new TimerTask() {
//	            public void run() {
//	               if(signService.)
//	            }
//	        }, time, 1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行
//
//	   }
		

	
	public  long judgeTotalTime(Date star ,Date end)                 //工作总时间
	{
		SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
		String s =sd.format(star);
		String e =sd.format(end);
		try {
		Date star1 = sd.parse(s);
		Date end1 = sd.parse(e);
		
		long rightTime = (long) ((end1.getTime()-star1.getTime())/(1000*60*60)); 
		
		return rightTime;
		
		}catch(ParseException e1) {
			   e1.printStackTrace();
		        throw new IllegalArgumentException("Illegal Argument");
		   }
		
		
	}
	
	public  String judgeExtraTime(Date star ,Date end)                  //加工总时间
	{
		
		
		return null;
		
	}

//	public String judgeTotalTime(Date starTime, Date endTime) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//

}
