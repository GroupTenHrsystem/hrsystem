package com.hrsystem.attendance.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.attendance.entity.Attendance;


public interface IAttendanceService {


	public Attendance findAttendanceById(Long id);
	 
	 public void insertAttendance(Attendance attendance) ;
	 
//	 public Attendance findAttendanceByName(String name);
	 
	 public void deleteAttendance(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<Attendance> findAll(Specification<Attendance> spec, Pageable pageable);
	 
//	 public List<Attendance> getAttendanceList(Long id);
//	 public List<Staff> getStaffByStaffTempletId(Long id);
}