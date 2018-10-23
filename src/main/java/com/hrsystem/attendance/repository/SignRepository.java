package com.hrsystem.attendance.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.attendance.entity.Attendance;
import com.hrsystem.attendance.entity.Sign;
import com.hrsystem.user.entity.Role;
@Repository
public interface SignRepository extends PagingAndSortingRepository<Sign, Long>,JpaSpecificationExecutor<Sign>{
	
	@Query(value="SELECT * FROM hrsystem.t_sign where name=?1",nativeQuery=true)
	public List<Sign> findSignByName(String name);
	
	@Query(value="SELECT * FROM hrsystem.t_sign where star_time like ?%1",nativeQuery=true)
	public List<Sign> findStarTime(String star_time);
	
	@Query(value="SELECT * FROM hrsystem.t_sign where end_time like ?%1",nativeQuery=true)
	public List<Sign> findEndTime(String end_time);
	
	@Query(value="SELECT * FROM hrsystem.t_sign where extra_star_time like ?%1",nativeQuery=true)
	public List<Sign> findExtraStarTime(String extra_star_time);
	
	@Query(value="SELECT * FROM hrsystem.t_sign where extra_end_time like ?%1",nativeQuery=true)
	public List<Sign> findExtraEndTime(String extra_end_time);
}



