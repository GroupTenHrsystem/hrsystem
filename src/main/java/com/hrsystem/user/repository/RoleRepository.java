package com.hrsystem.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.hrsystem.user.entity.Role;
import com.hrsystem.user.entity.DTO.RoleDTO;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long>,JpaSpecificationExecutor<Role>{

	@Query(value="SELECT a.id as id,a.position as position,a.limite as limite ,b.id as departmentId,b.department_name as departmentName FROM hrsystem.t_role as a join hrsystem.t_department as b on a.department_id = b.id",nativeQuery=true) 
	public List<RoleDTO> findDepartmentAndRole();
}
