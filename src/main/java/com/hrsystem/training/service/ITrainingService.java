package com.hrsystem.training.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.archives.domain.Archives;
import com.hrsystem.training.domain.Training;

public interface ITrainingService {
	public Training save(Training entity);
	public Optional<Training> findById(Long id);
	public boolean existsById(Long id);
	public long count();
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);

	public Page<Training> findAll(Specification<Training> spec, Pageable pageable);
	public Training findTrainingById(Long id);
	//通过的
	public Page<Training> findTrainingByArstatusPass(Specification<Training> spec, Pageable pageable);
	
	public void insertTraining(Training training) ;
	 
	public void deleteTraining(Long id) ;
	 

	 

}
