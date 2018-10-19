package com.hrsystem.training.service;

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
import org.springframework.web.bind.annotation.GetMapping;

import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.training.domain.Enroll;
import com.hrsystem.training.domain.EnrollQueryDTO;
import com.hrsystem.training.domain.Feedback;
import com.hrsystem.training.domain.Training;
import com.hrsystem.training.domain.TrainingQueryDTO;
import com.hrsystem.training.repository.EnrollRepository;
import com.hrsystem.training.repository.FeedbackRepository;

@Service
@Transactional
public class EnrollService implements IEnrollService{
	@Autowired
	private EnrollRepository enrollRepository;
	
	@Override
	public Enroll save(Enroll entity) {
		return enrollRepository.save(entity);
	}
	@Override
	public Optional<Enroll> findById(Long id) {
		return enrollRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		
		return enrollRepository.existsById(id);
	}

	@Override
	public long count() {
		return enrollRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		enrollRepository.deleteById(id);
	}

	@Override
	public Page<Enroll> findAll(Specification<Enroll> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		System.out.println("enroll");
		return enrollRepository.findAll(spec, pageable);
	}

	@Override
	public void deleteAll(Long[] ids) {
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		
		List<Enroll> enrolls = (List<Enroll>) enrollRepository.findAllById(idLists);
		if(enrolls!=null) {
			enrollRepository.deleteAll(enrolls);
		}
	}
	@Override
	public Enroll findEnrollById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Enroll> enroll = enrollRepository.findById(id);
		    if (!enroll.isPresent()) {
		        return null;
		    }
		    return enroll.get();
	}

	@Override
	public void insertEnroll(Enroll enroll) {
		// TODO Auto-generated method stub
		enrollRepository.save(enroll);     
	}

	@Override
	public void deleteEnroll(Long id) {
		// TODO Auto-generated method stub
		enrollRepository.deleteById(id);
	}
	@Override
	public Page<Enroll> findEnrollByArstatusPass(Specification<Enroll> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return enrollRepository.findEnrollByArstatusPass(spec, pageable);
	}

	
}

