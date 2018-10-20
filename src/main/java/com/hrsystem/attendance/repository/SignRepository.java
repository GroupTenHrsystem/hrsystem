package com.hrsystem.attendance.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.attendance.entity.Sign;
import com.hrsystem.user.entity.Role;
@Repository
public interface SignRepository extends PagingAndSortingRepository<Sign, Long>,JpaSpecificationExecutor<Sign>{
	

}
