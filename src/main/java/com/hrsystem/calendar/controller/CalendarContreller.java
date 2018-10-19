package com.hrsystem.calendar.controller;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: CalendarContreller.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.calendar.entity.Calendar;
import com.hrsystem.calendar.entity.Event;
import com.hrsystem.calendar.entity.DTO.EventQueryDTO;
import com.hrsystem.calendar.service.EventService;
import com.hrsystem.common.ExtResultJson;
import com.hrsystem.common.specificationBuilder.SpecificationBuilder;


@RestController
@RequestMapping("/calendar")
public class CalendarContreller 
{
	
	@Autowired
	private EventService eventService;
	//查找日历类型
	@RequestMapping("/findCalendars")
	public  ExtResultJson<Calendar> findCalendar()
	{
		List<Calendar>  clist = new ArrayList<Calendar>();
		

		Calendar c1 = new Calendar();
		c1.setId(1L);
		c1.setTitle("开会");
		c1.setDescription("");
		c1.setColor("");
		c1.setAssignedColor("#F44336");
		c1.setHidden(false);
		c1.setEditable(true);
	
		Calendar c2 = new Calendar();
		c2.setId(2L);
		c2.setTitle("Personal");
		c2.setDescription("");
		c2.setColor("");
		c2.setAssignedColor("#3F51B5");
		c2.setHidden(false);
		c2.setEditable(true);
				
		Calendar c3 = new Calendar();
		c3.setId(3L);
		c3.setTitle("Test");
		c3.setDescription("");
		c3.setColor("");
		c3.setAssignedColor("#DEFF88");
		c3.setHidden(false);
		c3.setEditable(true);

		clist.add(c1);
		clist.add(c2);
		clist.add(c3);
		return new ExtResultJson<Calendar>(clist);
		
	}
	@RequestMapping("/delete")
		public String delete(@RequestParam(name="id") Long id) 
		{
		try {
			eventService.deleteEvent(id);
			return "success:true";
		} catch (Exception e) {
			return "success:false";
		}
	}
	//按日历类型的id和时间区间查找对应的活动集合
	/**
	 *  calendar: Calendar类的Id
		startDate:开始时间,为UTC格式:2017-11-09T00:00:00.000Z
		endDate:结束时间:2018-03-11T00:00:00.000Z
	 *  
	 *  calendar:2
		startDate:2017-11-09T00:00:00.000Z
		endDate:2018-03-11T00:00:00.000Z
	 * @return
	 */
	 @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
		public String save(@RequestBody Event event) 
		{
			try {
				eventService.insertEvent(event);
			//	System.out.println(event.getId());
				//return "id:"+event.getId();
				return ""+event.getId();
			} catch (Exception e) {
				return "success:false";
			}
		}
	 
	 @RequestMapping("/findEvents")
		public  ExtResultJson<Event> findEvents(
				EventQueryDTO eventQueryDTO,
				@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") Date startDate,
				@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") Date endDate)
		{
			ExtResultJson<Event> json = new ExtResultJson<Event>(new ArrayList<Event>());
			Pageable pageable = PageRequest.of(0, 25);
			if(eventQueryDTO.getCalendar()==1L) {
				List<Event> list = eventService.findAll(SpecificationBuilder.buildSpecification(eventQueryDTO));
				json.setLists(list);
			}else if(eventQueryDTO.getCalendar()==2L) {
				List<Event> list = eventService.findAll(SpecificationBuilder.buildSpecification(eventQueryDTO));			
				json.setLists(list);
			}else {
				List<Event> list = eventService.findAll(SpecificationBuilder.buildSpecification(eventQueryDTO));
				json.setLists(list);
			}
			return json;
		}
	
}
