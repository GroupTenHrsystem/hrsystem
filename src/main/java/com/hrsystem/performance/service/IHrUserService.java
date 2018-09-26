package com.hrsystem.performance.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.performance.entity.HrUser;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: IHrUserService.java
  *@Date: 2018年9月26日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
public interface IHrUserService {
	public HrUser findHrUserById(Long id);
	 
	 public void insertHrUser(HrUser hrUser) ;
	 
	 public void deleteHrUser(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<HrUser> findAll(Specification<HrUser> spec, Pageable pageable);
	 
}
