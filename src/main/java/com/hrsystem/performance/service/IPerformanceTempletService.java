package com.hrsystem.performance.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.performance.entity.PerformanceTemplet;

public interface IPerformanceTempletService {
	public Optional<PerformanceTemplet> findPerformanceTempletById(Long id);
	 
	 public void insertPerformanceTemplet(PerformanceTemplet performanceTemplet) ;
	 
	 public void deletePerformanceTemplet(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<PerformanceTemplet> findAll(Specification<PerformanceTemplet> spec, Pageable pageable);
}
