package com.hrsystem.performance.service;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: IPerformanceTempletService.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.performance.entity.PerformanceTemplet;

public interface IPerformanceTempletService {
	public PerformanceTemplet findPerformanceTempletById(Long id);
	 
	 public void insertPerformanceTemplet(PerformanceTemplet performanceTemplet) ;
	 
	 public void deletePerformanceTemplet(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<PerformanceTemplet> findAll(Specification<PerformanceTemplet> spec, Pageable pageable);
}
