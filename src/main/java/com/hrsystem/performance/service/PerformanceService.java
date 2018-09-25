package com.hrsystem.performance.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.repository.PerformanceRepository;
@Service
public class PerformanceService implements IPerformanceService{
	@Autowired
	PerformanceRepository performanceRepository;
	public Performance findPerformanceById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Performance> performance = performanceRepository.findById(id);
		    if (!performance.isPresent()) {
		        return null;
		    }
		    return performance.get();
	}

	@Override
	public void insertPerformance(Performance Performance) {
		// TODO Auto-generated method stub
		performanceRepository.save(Performance);     
	}

	@Override
	public void deletePerformance(Long id) {
		// TODO Auto-generated method stub
		performanceRepository.deleteById(id);
	}
 
	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));	
		List<Performance> Performances = (List<Performance>) performanceRepository.findAllById(idLists);
		performanceRepository.deleteAll(Performances);
	}

	@Override
	public Page<Performance> findAll(Specification<Performance> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return performanceRepository.findAll(spec, pageable);
	}
	
	@Override
	 public List<Performance> getPerformanceByPerformanceTempletId(Long id){
		return performanceRepository.getPerformanceByPerformanceTempletId(id);
	 }
}
