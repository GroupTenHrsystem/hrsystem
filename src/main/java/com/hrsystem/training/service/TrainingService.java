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

import com.hrsystem.training.domain.Training;
import com.hrsystem.training.repository.TrainingRepository;


@Service
@Transactional
public class TrainingService implements ITrainingService{
	@Autowired
	private TrainingRepository trainingRepository;
	
	@Override
	public Training save(Training entity) {
		return trainingRepository.save(entity);
	}
	@Override
	public Optional<Training> findById(Long id) {
		return trainingRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		
		return trainingRepository.existsById(id);
	}

	@Override
	public long count() {
		return trainingRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		trainingRepository.deleteById(id);
	}

	@Override
	public Page<Training> findAll(Specification<Training> spec, Pageable pageable) {
		
		return trainingRepository.findAll(spec, pageable);
	}

	@Override
	public void deleteAll(Long[] ids) {
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		
		List<Training> trainings = (List<Training>) trainingRepository.findAllById(idLists);
		if(trainings!=null) {
			trainingRepository.deleteAll(trainings);
		}
	}
}
