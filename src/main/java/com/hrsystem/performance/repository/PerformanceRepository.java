package com.hrsystem.performance.repository;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceRepository.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.performance.entity.Performance;


@Repository
public interface PerformanceRepository extends PagingAndSortingRepository<Performance, Long>,JpaSpecificationExecutor<Performance>{
	@Query(value="select * from t_performance where performance_templet_id=?1",nativeQuery=true)
	List<Performance> getPerformanceByPerformanceTempletId(Long id);
}
