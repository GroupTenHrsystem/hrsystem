package com.hrsystem.recruit.service;

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

import com.hrsystem.recruit.entity.Recruit;
import com.hrsystem.recruit.repository.RecruitRepository;

@Service
@Transactional
public class RecruitService implements IRecruitService{

	@Autowired
	private RecruitRepository recruitRepository;

	@Override
	public Recruit save(Recruit recruit) {
		return recruitRepository.save(recruit);
	}

	@Override
	public Optional<Recruit> findById(Long id) {
		return recruitRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return recruitRepository.existsById(id);
	}

	@Override
	public long count() {
		return recruitRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		recruitRepository.deleteById(id);
	}

	@Override
	public Page<Recruit> findAll(Specification<Recruit> spec, Pageable pageable) {
		return recruitRepository.findAll(spec,pageable);
	}

	@Override
	public void deleteAll(Long[] ids) {
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		List<Recruit> recruits = (List<Recruit>) recruitRepository.findAllById(idLists);
		if(recruits!=null) {
			recruitRepository.deleteAll(recruits);
		}
	}
	
	
}
