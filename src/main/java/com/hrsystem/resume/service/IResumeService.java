package com.hrsystem.resume.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import com.hrsystem.resume.entity.Resume;

public interface IResumeService {

	public Resume save(Resume resume);
	public Optional<Resume> findById(Long id);
	public boolean existsById(Long id);
	public long count();
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);
	
	public Page<Resume> findAll(Specification<Resume> spec,Pageable pageable);
}
