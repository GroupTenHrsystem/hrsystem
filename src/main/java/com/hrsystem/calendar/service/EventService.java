package com.hrsystem.calendar.service;

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


@Service
public class EventService implements IEventService{
	@Autowired
	EventRepository eventRepository;
	@Override
	public Optional<Event> findEventById(Long id) {
		// TODO Auto-generated method stub
		return  eventRepository.findById(id);
	}

	@Override
	public void insertEvent(Event event) {
		// TODO Auto-generated method stub
		eventRepository.save(event);     
	}

	@Override
	public void deleteEvent(Long id) {
		// TODO Auto-generated method stub
		eventRepository.deleteById(id);
	}
 
	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		
		List<Event> events = (List<Event>) eventRepository.findAllById(idLists);
		eventRepository.deleteAll(events);
	}

	@Override
	public Page<Event> findAll(Specification<Event> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return eventRepository.findAll(spec, pageable);
	}

}
