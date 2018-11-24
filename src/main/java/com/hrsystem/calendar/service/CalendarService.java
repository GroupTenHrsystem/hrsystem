package com.hrsystem.calendar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsystem.calendar.entity.Calendar;
import com.hrsystem.calendar.entity.Event;
import com.hrsystem.calendar.repository.CalendarRepository;
import com.hrsystem.log.ServiceLogs;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: CalendarService.java
  *@Date: 2018年10月20日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Service
public class CalendarService implements ICalendarService{

	@Autowired
	CalendarRepository calendarRepository;
	@Override
	@ServiceLogs(description = "查全部日期事件list")
	public List<Calendar> findAll(Specification<Calendar> spec) {
		// TODO Auto-generated method stub
		return calendarRepository.findAll(spec);
	}

	@Override
	@ServiceLogs(description = "保存日期事件")
	public void save(Calendar calendar) {
		// TODO Auto-generated method stub
		calendarRepository.save(calendar);
	}

	

}
