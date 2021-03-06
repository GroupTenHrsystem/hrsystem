package com.hrsystem.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import com.hrsystem.user.entity.Staff;

public interface IStaffService {

	public Staff findStaffById(Long id);
	 
	 public void insertStaff(Staff staff) ;
	 
	 public Staff findStaffByName(String name);
	 
	 public void deleteStaff(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<Staff> findAll(Specification<Staff> spec, Pageable pageable);
	 
	 public List<Staff> getStaffList(Long id);
//	 public List<Staff> getStaffByStaffTempletId(Long id);
	 
}
