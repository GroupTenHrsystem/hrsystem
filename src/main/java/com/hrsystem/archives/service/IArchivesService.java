package com.hrsystem.archives.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.hrsystem.archives.domain.Archives;
import com.hrsystem.training.domain.Training;



public interface IArchivesService {
	public Archives save(Archives entity);
	public Optional<Archives> findById(Long id);
	public boolean existsById(Long id);
	public long count();
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);
	public Page<Archives> findArchivesByArstatus(Long archivesId, Specification<Archives> spec, Pageable pageable);
	public Page<Archives> findArchivesByArstatusPass(Specification<Archives> spec, Pageable pageable);
	public Page<Archives> findArchivesByArstatusFirst(Specification<Archives> spec, Pageable pageable);
	public Page<Archives> findAll(Specification<Archives> spec, Pageable pageable);
	public Archives findArchivesById(Long id);
	 
	public void insertArchives(Archives archives) ;

	public void deleteArchives(Long id) ;
}
