package com.hrsystem.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.user.entity.Department;

public interface DepartmentIService {

	public Optional<Department> findDepartmentById(Long id);
	 
	 public void insertDepartment(Department department) ;
	 
	 public void deleteDepartment(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<Department> findAll(Specification<Department> spec, Pageable pageable);
	 
//	 public List<Department> getDepartmentByDepartmentTempletId(Long id);
}
