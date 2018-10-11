package com.hrsystem.resume.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.resume.entity.Resume;
import com.hrsystem.resume.repository.ResumeRepository;

@Service
@Transactional
public class ResumeService implements IResumeService{
	
	@Autowired
	private ResumeRepository resumeRepository;

	@Override
	public Resume save(Resume resume) {
		return resumeRepository.save(resume);
	}

	@Override
	public Optional<Resume> findById(Long id) {
		Optional<Resume> resume = resumeRepository.findById(id);
		if(!resume.isPresent()) {
			return null;
		}
		return resumeRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		Optional<Resume> resume = resumeRepository.findById(id);
		if(!resume.isPresent()) {
			return false;
		}
		return resumeRepository.existsById(id);
	}

	@Override
	public long count() {
		return resumeRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		resumeRepository.deleteById(id);
	}

	@Override
	public void deleteAll(Long[] ids) {
		resumeRepository.deleteAll();
	}

	@Override
	public Page<Resume> findAll(Specification<Resume> spec, Pageable pageable) {
		return resumeRepository.findAll(spec, pageable);
	}
}
