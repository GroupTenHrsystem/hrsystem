package com.hrsystem.calendar.service;
import java.util.List;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: IEventService.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.calendar.entity.Event;


public interface IEventService {
	 public Optional<Event> findEventById(Long id);
	 
	 public void insertEvent(Event event) ;
	 
	 public void deleteEvent(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<Event> findAll(Specification<Event> spec, Pageable pageable);
	 
	 public List<Event> findAll(Specification<Event> spec);
}
