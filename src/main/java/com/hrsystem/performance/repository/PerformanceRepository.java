package com.hrsystem.performance.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.performance.entity.Performance;


@Repository
public interface PerformanceRepository extends PagingAndSortingRepository<Performance, Long>,JpaSpecificationExecutor<Performance>{

}
