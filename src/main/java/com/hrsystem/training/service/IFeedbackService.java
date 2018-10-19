package com.hrsystem.training.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.archives.domain.Archives;
import com.hrsystem.training.domain.Enroll;
import com.hrsystem.training.domain.Feedback;




public interface IFeedbackService {
	public Feedback save(Feedback entity);
	public Optional<Feedback> findById(Long id);
	public boolean existsById(Long id);
	public long count();
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);
	
	public Page<Feedback> findFeedbackByEnroll(Specification<Feedback> spec, Pageable pageable);
	
	public Page<Feedback> findAll(Specification<Feedback> spec, Pageable pageable);
	public Feedback findFeedbackById(Long id);
	 
	public void insertFeedback(Feedback feedback) ;
	 
	public void deleteFeedback(Long id) ;
}
