package com.hrsystem.attendance.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsystem.attendance.entity.Attendance;
import com.hrsystem.attendance.repository.AttendanceRepository;
import com.hrsystem.user.entity.Staff;

@Service
public class AttendanceService implements IAttendanceService {
	
	@Autowired
	AttendanceRepository attendanceRepository;

	@Override
	public Attendance findAttendanceById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Attendance> attendance = attendanceRepository.findById(id);
		 if (!attendance.isPresent()) {
		        return null;
		    }
		    return attendance.get();
	}

	@Override
	public void insertAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		attendanceRepository.save(attendance);

	}

	@Override
	public void deleteAttendance(Long id) {
		// TODO Auto-generated method stub
		attendanceRepository.deleteById(id);

	}

	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> attendance =new ArrayList(Arrays.asList(ids));
		List<Attendance>check =(List<Attendance>) attendanceRepository.findAllById(attendance);
		attendanceRepository.deleteAll(check);

	}

	@Override
	public Page<Attendance> findAll(Specification<Attendance> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return attendanceRepository.findAll(spec, pageable);
	}

}
