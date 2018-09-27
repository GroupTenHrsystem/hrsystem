package com.hrsystem.user.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.hrsystem.user.entity.Department;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long>,JpaSpecificationExecutor<Department>{

}
