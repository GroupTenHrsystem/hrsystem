package com.hrsystem.performance.repository;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceTempletRepository.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.performance.entity.PerformanceTemplet;

@Repository
public interface PerformanceTempletRepository extends PagingAndSortingRepository<PerformanceTemplet, Long>,JpaSpecificationExecutor<PerformanceTemplet>{

}
