package com.hrsystem.recruit.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.recruit.entity.Recruit;


public interface IRecruitService {
	public Recruit save(Recruit recruit);
	public Optional<Recruit> findById(Long id);
	public boolean existsById(Long id);
	public long count();
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);
	
	public Page<Recruit> findAll(Specification<Recruit> spec,Pageable pageable);
}
