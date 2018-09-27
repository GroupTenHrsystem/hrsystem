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

import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.repository.StaffRepository;

@Service
public class StaffService implements IStaffService {

	@Autowired
	StaffRepository staffRepository;
	@Override
	public Optional<Staff> findStaffById(Long id) {
		// TODO Auto-generated method stub
		return staffRepository.findById(id);
	}

	@Override
	public void insertStaff(Staff staff) {
		// TODO Auto-generated method stub
		staffRepository.save(staff);
	}

	@Override
	public void deleteStaff(Long id) {
		// TODO Auto-generated method stub
		staffRepository.deleteById(id);
	}

	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idList=new ArrayList(Arrays.asList(ids));
		List<Staff>check =(List<Staff>) staffRepository.findAllById(idList);
		staffRepository.deleteAll(check);
	}

	@Override
	public Page<Staff> findAll(Specification<Staff> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return staffRepository.findAll(spec, pageable);
	}

//	@Override
//	public List<Staff> getStaffByStaffTempletId(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
