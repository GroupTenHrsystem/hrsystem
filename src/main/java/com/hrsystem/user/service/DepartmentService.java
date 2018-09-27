package com.hrsystem.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsystem.calendar.entity.Event;
import com.hrsystem.user.entity.Department;
import com.hrsystem.user.repository.DepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Optional<Department> findDepartmentById(Long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id);
	}

	@Override
	public void insertDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentRepository.save(department);

	}

	@Override
	public void deleteDepartment(Long id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);

	}

	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long>idList =new ArrayList<Long>(Arrays.asList(ids));
		List<Department>check=(List<Department>) departmentRepository.findAllById(idList);
		departmentRepository.deleteAll(check);
	}

	@Override
	public Page<Department> findAll(Specification<Department> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return departmentRepository.findAll(spec, pageable);
	}

//	@Override
//	public List<Department> getDepartmentByDepartmentTempletId(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
