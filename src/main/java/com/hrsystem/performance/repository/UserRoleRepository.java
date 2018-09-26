//package com.hrsystem.performance.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.stereotype.Repository;
//
//import com.hrsystem.performance.entity.UserRole;
//
//
//
///**
//*@项目名称: hrsystem
//*@作者: HyperMuteki
//*@文件名称: UserRoleRepository.java
//  *@Date: 2018年9月26日
//*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
// 
//*/
//@Repository
//public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long>,JpaSpecificationExecutor<UserRole>{
//	@Query(value="select * from user_role where user_id=?1",nativeQuery=true)
//	List<UserRole> findByUserId(String id);
//	
//	@Query(value="select * from user_role where role_id=?1",nativeQuery=true)
//	List<UserRole> findByRoleId(String id);
//}
