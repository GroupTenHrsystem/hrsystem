package com.hrsystem.calendar.service;

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
}
