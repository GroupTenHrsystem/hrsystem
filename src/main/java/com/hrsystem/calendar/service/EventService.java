package com.hrsystem.calendar.service;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: EventService.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsystem.calendar.entity.Event;
import com.hrsystem.calendar.repository.EventRepository;
import com.hrsystem.log.ServiceLogs;


@Service
public class EventService implements IEventService{
	@Autowired
	EventRepository eventRepository;
	@Override
	@ServiceLogs(description = "通过id查事件类型")
	public Optional<Event> findEventById(Long id) {
		// TODO Auto-generated method stub
		return  eventRepository.findById(id);
	}

	@Override
	@ServiceLogs(description = "插入事件类型")
	public void insertEvent(Event event) {
		// TODO Auto-generated method stub
		eventRepository.save(event);     
	}

	@Override
	@ServiceLogs(description = "删除事件类型")
	public void deleteEvent(Long id) {
		// TODO Auto-generated method stub
		eventRepository.deleteById(id);
	}
 
	@Override
	@ServiceLogs(description = "删除全部事件类型")
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		
		List<Event> events = (List<Event>) eventRepository.findAllById(idLists);
		eventRepository.deleteAll(events);
	}

	@Override
	@ServiceLogs(description = "查全部类型page")
	public Page<Event> findAll(Specification<Event> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return eventRepository.findAll(spec, pageable);
	}

	@Override
	@ServiceLogs(description = "查全部类型list")
	public List<Event> findAll(Specification<Event> spec) {
		// TODO Auto-generated method stub
		return eventRepository.findAll(spec);
	}

}
