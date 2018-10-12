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

import com.hrsystem.performance.entity.Performance;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.repository.StaffRepository;

@Service
public class StaffService implements IStaffService {

	@Autowired
	StaffRepository staffRepository;
	@Override
	public Staff findStaffById(Long id) {
		// TODO Auto-generated method stub

		 Optional<Staff> staff = staffRepository.findById(id);
		 if (!staff.isPresent()) {
		        return null;
		    }
		    return staff.get();
		    
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

	@Override
	public Staff findStaffByName(String name) {
		return staffRepository.findByName(name);
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public List<Staff> getStaffByStaffTempletId(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
