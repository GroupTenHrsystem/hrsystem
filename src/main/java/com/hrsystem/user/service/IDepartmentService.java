package com.hrsystem.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.user.entity.Department;
import com.hrsystem.user.entity.Staff;

public interface IDepartmentService {

	public Department findDepartmentById(Long id);
	 
	 public void insertDepartment(Department department) ;
	 
	 public void deleteDepartment(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<Department> findAll(Specification<Department> spec, Pageable pageable);
	 
	 public List<Department> getDepartmentList(Specification<Department> spec);
	 
	 public List<Department> findAllSubChildrens(List<Department> lists,Long parentId);
	 
	 public List<Long> findAllSubChildrensIds(List<Long> idLists,Long parentId);
	 
	 public List<Staff> findAllSubChildrensStaffs(List<Long> idLists,Long parentId);
//	 public List<Department> getDepartmentByDepartmentTempletId(Long id);
}
