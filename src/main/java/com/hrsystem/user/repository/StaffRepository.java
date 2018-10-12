package com.hrsystem.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.hrsystem.user.entity.Staff;

@Repository
public interface StaffRepository extends PagingAndSortingRepository<Staff, Long>,JpaSpecificationExecutor<Staff>{

	@Query(value="SELECT * FROM hrsystem.t_staff where department_id = ?1",nativeQuery=true)
	public List<Staff> findByDepartmentId(Long departmentId);
	
	@Query(value="from Staff staff where staff.staffName like ?1") 
	public Staff findByName(String staffName);
}
