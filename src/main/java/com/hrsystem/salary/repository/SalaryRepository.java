package com.hrsystem.salary.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
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

}
