package com.hrsystem.interview.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.interview.entity.Interview;
import com.hrsystem.interview.repository.InterviewRepository;

@Service
@Transactional
public class InterviewService implements IInterviewService{
	@Autowired
	private InterviewRepository interviewRepository;

	@Override
	public Interview save(Interview interview) {
		return interviewRepository.save(interview);
	}

	@Override
	public Optional<Interview> findById(Long id) {
		return interviewRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return interviewRepository.existsById(id);
	}

	@Override
	public long count() {
		return interviewRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		interviewRepository.deleteById(id);
	}

	@Override
	public void deleteAll(Long[] ids) {
		interviewRepository.deleteAll();
	}

	@Override
	public Page<Interview> findAll(Specification<Interview> spec, Pageable pageable) {
		return interviewRepository.findAll(spec, pageable);
	}
}
