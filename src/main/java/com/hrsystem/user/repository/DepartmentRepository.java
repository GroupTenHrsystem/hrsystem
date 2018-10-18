package com.hrsystem.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.hrsystem.user.entity.Department;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long>,JpaSpecificationExecutor<Department>{
	//找出所有子部门id
	@Query("select d.id from Department d  where d.superId.id = ?1")
	public List<Long> findChildrensIds(Long parentId);
	//找出所有子部门
	@Query("from Department d  where d.superId.id = ?1")
	public List<Department> findChildrens(Long parentId);
	//找出所有子部门
	@Query(value="SELECT * FROM hrsystem.t_department WHERE super_id_id is NULL",nativeQuery=true)
	public List<Department> findNoParent();
	//找出子部门员工数
//	@Query(value="SELECT COUNT(d.id) FROM Department d where d.superId=?1")
//	public long count(Long parentId);
//	
}
