package com.hrsystem.performance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.performance.entity.Performance;


@Repository
public interface PerformanceRepository extends PagingAndSortingRepository<Performance, Long>,JpaSpecificationExecutor<Performance>{
	@Query(value="select * from performance where performance_templet_id=?1",nativeQuery=true)
	List<Performance> getPerformanceByPerformanceTempletId(Long id);
}
