package com.hrsystem.user.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.hrsystem.user.entity.Staff;

@Repository
public interface StaffRepository extends PagingAndSortingRepository<Staff, Long>,JpaSpecificationExecutor<Staff>{

	
	@Query(value="from Staff staff where staff.staffName like ?1") 
	public Staff findByName(String staffName);
}
