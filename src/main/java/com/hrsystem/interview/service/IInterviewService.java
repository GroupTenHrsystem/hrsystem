package com.hrsystem.interview.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.interview.entity.Interview;

public interface IInterviewService {

	public Interview save(Interview interview);
	public Optional<Interview> findById(Long id);
	public boolean existsById(Long id);
	public long count();
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);
	
	public Page<Interview> findAll(Specification<Interview> spec,Pageable pageable);
}
