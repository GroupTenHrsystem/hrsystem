package com.hrsystem.attendance.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsystem.attendance.entity.Sign;
import com.hrsystem.attendance.repository.SignRepository;
import com.hrsystem.user.entity.Staff;

@Service
public class SignService implements ISignService {

	@Autowired
	SignRepository  signRepository;
	@Override
	public Sign findSignById(Long id) {
		// TODO Auto-generated method stub
		Optional<Sign> sign = signRepository.findById(id);
		 if (!sign.isPresent()) {
		        return null;
		    }
		    return sign.get();
		
	}

	@Override
	public void insertSign(Sign sign) {
		// TODO Auto-generated method stub
		signRepository.save(sign);

	}

//	@Override
//	public Sign findSignByName(String name) {
//		// TODO Auto-generated method stub
//		return signRepository.fin;
//	}

	@Override
	public void deleteSign(Long id) {
		// TODO Auto-generated method stub
		signRepository.deleteById(id); 
	}

	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> sign = new ArrayList(Arrays.asList(ids));
		List<Sign>check =(List<Sign>) signRepository.findAllById(sign);
		signRepository.deleteAll(check);
	}

	@Override
	public Page<Sign> findAll(Specification<Sign> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return signRepository.findAll(spec, pageable);
	}

	@Override
	public List<Sign> findSignByName(String name) {
		// TODO Auto-generated method stub
		return signRepository.findSignByName(name);
	}

	@Override
	public List<Sign> findStarTime(String star_time) {
		// TODO Auto-generated method stub
		return signRepository.findStarTime(star_time);
	}

	@Override
	public List<Sign> findExtraStarTime(String extra_star_time) {
		// TODO Auto-generated method stub
		return signRepository.findExtraStarTime(extra_star_time);
	}

	

}
