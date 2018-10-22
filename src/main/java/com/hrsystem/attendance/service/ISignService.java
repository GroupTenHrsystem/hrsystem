package com.hrsystem.attendance.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.attendance.entity.Sign;


public interface ISignService {


	public Sign findSignById(Long id);
	 
	 public void insertSign(Sign staff) ;
	 
//	 public Sign findSignByName(String name);
	 
	 public void deleteSign(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<Sign> findAll(Specification<Sign> spec, Pageable pageable);
	 
	 public List<Sign> findSignByName(String name);
	 
	 
	 public List<Sign> findStarTime(String star_time);
	 
	 public List<Sign> findExtraStarTime(String extra_star_time);
//	 public List<Staff> getStaffByStaffTempletId(Long id);
}