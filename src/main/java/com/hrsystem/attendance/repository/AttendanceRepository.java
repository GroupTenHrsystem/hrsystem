package com.hrsystem.attendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.attendance.entity.Attendance;
import com.hrsystem.attendance.entity.Sign;
import com.hrsystem.user.entity.Department;
import com.hrsystem.user.entity.Role;
@Repository
public interface AttendanceRepository extends PagingAndSortingRepository<Attendance, Long>,JpaSpecificationExecutor<Attendance>{
	

	@Query(value="SELECT * FROM hrsystem.t_attendance where employe_name =?1",nativeQuery=true)
	public List<Attendance> findAttendanceByName(String name);
}
