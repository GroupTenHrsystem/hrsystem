package com.hrsystem.training.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import com.hrsystem.training.domain.Training;

public interface ITrainingService {
	public Training save(Training entity);
	public Optional<Training> findById(Long id);
	public boolean existsById(Long id);
	public long count();
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);

	public Page<Training> findAll(Specification<Training> spec, Pageable pageable);
}
