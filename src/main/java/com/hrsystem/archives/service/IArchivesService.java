package com.hrsystem.archives.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.archives.domain.Archives;

public interface IArchivesService {
	public Archives save(Archives entity);
	public Optional<Archives> findById(Long id);
	public boolean existsById(Long id);
	public long count();
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);

	public Page<Archives> findAll(Specification<Archives> spec, Pageable pageable);
	
}
