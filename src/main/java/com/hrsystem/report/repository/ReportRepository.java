package com.hrsystem.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.report.entity.Report;


/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: ReportRepository.java
  *@Date: 2018年10月17日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Repository
public interface ReportRepository extends PagingAndSortingRepository<Report, Long>,JpaSpecificationExecutor<Report>{

	
	@Modifying
	@Query(value="UPDATE hrsystem.t_report SET status = false WHERE id IN ?1",nativeQuery=true) 
	public void updateAll(List<Long> ids);
}
