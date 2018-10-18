package com.hrsystem.performance.repository;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceRepository.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.hrsystem.performance.entity.Performance;


@Repository
public interface PerformanceRepository extends PagingAndSortingRepository<Performance, Long>,JpaSpecificationExecutor<Performance>{
	@Query(value="select * from t_performance where performance_templet_id=?1",nativeQuery=true)
	List<Performance> getPerformanceByPerformanceTempletId(Long id);

	@Query(value="SELECT * FROM hrsystem.t_performance where staff_id in (SELECT id FROM hrsystem.t_staff where staff_name=?1)",nativeQuery=true)
	Page<Performance> getMyPerformanceByStaffName(String userId, Pageable pageable);

	@Query(value = "SELECT * FROM hrsystem.t_performance where staff_id = ?1 AND end_time Between ?2 And ?3 AND start_time Between ?2 And ?3 ",nativeQuery=true)
	List<Performance> getPerformanceByStaffAndTime(Long id,  Date startTime, Date endTime);

	@Modifying
	@Query(value="UPDATE hrsystem.t_performance SET status = false WHERE id IN ?1 AND process_status != 'APPROVAL'",nativeQuery=true) 
	public void updateAll(List<Long> ids);
	 
	@Override
    @EntityGraph("Performance.withStaff")
	Page<Performance> findAll(@Nullable Specification<Performance> spec, Pageable pageable);
}
