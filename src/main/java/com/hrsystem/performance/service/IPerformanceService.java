package com.hrsystem.performance.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.performance.entity.Performance;


public interface IPerformanceService {
	public Performance findPerformanceById(Long id);
	 
	 public void insertPerformance(Performance performance) ;
	 
	 public void deletePerformance(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<Performance> findAll(Specification<Performance> spec, Pageable pageable);
}
