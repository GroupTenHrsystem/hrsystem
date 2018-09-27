package com.hrsystem.leave.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.leave.entity.Leave;



/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: LeaveRepository.java
  *@Date: 2018年9月27日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Repository
public interface LeaveRepository extends PagingAndSortingRepository<Leave, Long>,JpaSpecificationExecutor<Leave>
{
//	@Query("from Leave leave where leave.userId = ?1") 
//	public Page<Leave> findLeave(String userId,Pageable pageable); 
}