package com.hrsystem.calendar.service;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: ICalendarService.java
  *@Date: 2018年10月20日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.calendar.entity.Calendar;
import com.hrsystem.calendar.entity.Event;

public interface ICalendarService {
	public List<Calendar> findAll(Specification<Calendar> spec);
	
	public void save(Calendar calendar) ;
	 
}
