package com.hrsystem.salary.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.hrsystem.salary.entity.Salary;


/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: SalaryRepository.java
  *@Date: 2018年9月28日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Repository
public interface SalaryRepository extends PagingAndSortingRepository<Salary, Long>,JpaSpecificationExecutor<Salary>{

    @Override
    @EntityGraph("Salary.withStaff")
    Page<Salary> findAll(@Nullable Specification<Salary> spec, Pageable pageable);
    
    @Modifying
	@Query(value="UPDATE hrsystem.t_salary SET status = false WHERE id IN ?1",nativeQuery=true) 
	public void updateAll(List<Long> ids);
    
    @Query(value="SELECT * FROM hrsystem.t_salary where staff_id in (SELECT id FROM hrsystem.t_staff where staff_name=?1)  order by salary_star_time ASC",nativeQuery=true)
    Page<Salary> getSalaryByStaffName(String userId, Pageable pageable);
}
