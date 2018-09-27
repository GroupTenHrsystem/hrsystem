package com.hrsystem.training.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.training.domain.Feedback;



public interface IFeedbackService {
	public Feedback save(Feedback entity);
	public Optional<Feedback> findById(Long id);
	public boolean existsById(Long id);
	public long count();
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);

	public Page<Feedback> findAll(Specification<Feedback> spec, Pageable pageable);
}
