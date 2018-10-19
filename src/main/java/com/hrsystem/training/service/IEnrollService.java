package com.hrsystem.training.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.training.domain.Enroll;
import com.hrsystem.training.domain.Training;



public interface IEnrollService {
	public Enroll save(Enroll entity);
	public Optional<Enroll> findById(Long id);
	public boolean existsById(Long id);
	public long count();
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);

	public Page<Enroll> findAll(Specification<Enroll> spec, Pageable pageable);
	public Enroll findEnrollById(Long id);
	 
	public void insertEnroll(Enroll enroll) ;
	 
	public void deleteEnroll(Long id) ;
	public Page<Enroll> findEnrollByArstatusPass(Specification<Enroll> spec, Pageable pageable);
}
