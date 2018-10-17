package com.hrsystem.report.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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

}
