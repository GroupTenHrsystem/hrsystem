package com.hrsystem.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.user.entity.Department;
import com.hrsystem.user.entity.Role;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.entity.DTO.RoleDTO;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long>,JpaSpecificationExecutor<Role>{

//	@Query(value="SELECT * FROM hrsystem.t_staff a where a.department_id =?1",nativeQuery=true) 
//	public List<Staff> findStaffByRole(Long positionId);
	
	@Query(value="SELECT * FROM hrsystem.t_role WHERE position = ?1",nativeQuery=true)
	public List<Role> findByPosition(String position);
	
	@Query(value="SELECT * FROM hrsystem.t_role ",nativeQuery=true)
	public List<Role> findNoParent();
	
}
