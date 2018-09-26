package com.hrsystem.performance.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.performance.entity.HrUser;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: HrUserRepository.java
  *@Date: 2018年9月26日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Repository
public interface HrUserRepository extends PagingAndSortingRepository<HrUser, Long>,JpaSpecificationExecutor<HrUser>{

}
