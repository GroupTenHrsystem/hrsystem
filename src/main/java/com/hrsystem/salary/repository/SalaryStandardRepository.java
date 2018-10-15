package com.hrsystem.salary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.salary.entity.SalaryStandard;



/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: SalaryStandardRepository.java
  *@Date: 2018年9月28日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Repository
public interface SalaryStandardRepository extends PagingAndSortingRepository<SalaryStandard, Long>,JpaSpecificationExecutor<SalaryStandard>{
	
	@Modifying
	@Query(value="UPDATE hrsystem.t_salary_standard SET status = false WHERE id IN ?1",nativeQuery=true) 
	public void updateAll(List<Long> ids);
}
