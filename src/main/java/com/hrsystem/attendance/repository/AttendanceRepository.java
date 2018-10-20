package com.hrsystem.attendance.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.attendance.entity.Attendance;
import com.hrsystem.user.entity.Role;
@Repository
public interface AttendanceRepository extends PagingAndSortingRepository<Attendance, Long>,JpaSpecificationExecutor<Attendance>{
	

}
