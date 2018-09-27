package com.hrsystem.archives.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.hrsystem.archives.domain.Archives;
import com.hrsystem.archives.repository.ArchivesRepository;

@Service
@Transactional
public class ArchivesService implements IArchivesService{
	@Autowired
	private ArchivesRepository archivesRepository;
	
	@Override
	public Archives save(Archives entity) {
		return archivesRepository.save(entity);
	}
	@Override
	public Optional<Archives> findById(Long id) {
		return archivesRepository.findById(id);
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

}
