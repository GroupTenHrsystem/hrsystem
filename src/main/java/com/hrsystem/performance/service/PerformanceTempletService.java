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
import com.hrsystem.performance.entity.PerformanceTemplet;
import com.hrsystem.performance.repository.PerformanceTempletRepository;
@Service
public class PerformanceTempletService  implements IPerformanceTempletService{
	@Autowired
	PerformanceTempletRepository performanceTempletRepository;
	public Optional<PerformanceTemplet> findPerformanceTempletById(Long id) {
		// TODO Auto-generated method stub
		return  performanceTempletRepository.findById(id);
	}

	@Override
	public void insertPerformanceTemplet(PerformanceTemplet performanceTemplet) {
		// TODO Auto-generated method stub
		performanceTempletRepository.save(performanceTemplet);     
	}

	@Override
	public void deletePerformanceTemplet(Long id) {
		// TODO Auto-generated method stub
		performanceTempletRepository.deleteById(id);
	}
 
	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		
		List<PerformanceTemplet> performanceTemplet = (List<PerformanceTemplet>) performanceTempletRepository.findAllById(idLists);
		performanceTempletRepository.deleteAll(performanceTemplet);
	}

	@Override
	public Page<PerformanceTemplet> findAll(Specification<PerformanceTemplet> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return performanceTempletRepository.findAll(spec, pageable);
	}


}
