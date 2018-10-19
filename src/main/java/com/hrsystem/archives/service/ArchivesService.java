package com.hrsystem.archives.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.hrsystem.archives.domain.Archives;
import com.hrsystem.archives.repository.ArchivesRepository;
import com.hrsystem.training.domain.Training;


@Service
@Transactional
public class ArchivesService implements IArchivesService{
	@Autowired
	ArchivesRepository archivesRepository;
	@Override
	public Archives save(Archives entity) {
		return archivesRepository.save(entity);
	}
	@Override
	public Optional<Archives> findById(Long id) {
		return archivesRepository.findById(id);
	}
	
	@Override
	public Page<Archives> findArchivesByArstatus(Long archivesId, Specification<Archives> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return archivesRepository.findArchivesByArstatus(archivesId, spec, pageable);
	}
	@Override
	public Page<Archives> findArchivesByArstatusFirst(Specification<Archives> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return archivesRepository.findArchivesByArstatusFirst(spec, pageable);
	}
	@Override
	public Page<Archives> findArchivesByArstatusPass(Specification<Archives> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return archivesRepository.findArchivesByArstatusPass(spec, pageable);
	}
	@Override
	public boolean existsById(Long id) {
		
		return archivesRepository.existsById(id);
	}

	@Override
	public long count() {
		return archivesRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		archivesRepository.deleteById(id);
	}

	@Override
	public Page<Archives> findAll(Specification<Archives> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		System.out.println("Archives");
		return archivesRepository.findAll(spec, pageable);
	}

	@Override
	public void deleteAll(Long[] ids) {
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		
		List<Archives> archivess = (List<Archives>) archivesRepository.findAllById(idLists);
		if(archivess!=null) {
			archivesRepository.deleteAll(archivess);
		}
	}
	@Override
	public Archives findArchivesById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Archives> archives = archivesRepository.findById(id);
		    if (!archives.isPresent()) {
		        return null;
		    }
		    return archives.get();
	}

	@Override
	public void insertArchives(Archives archives) {
		// TODO Auto-generated method stub
		archivesRepository.save(archives);     
	}

	@Override
	public void deleteArchives(Long id) {
		// TODO Auto-generated method stub
		archivesRepository.deleteById(id);
	}
 
}
