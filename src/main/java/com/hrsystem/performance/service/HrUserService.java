package com.hrsystem.performance.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsystem.performance.entity.HrUser;
import com.hrsystem.performance.repository.HrUserRepository;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: HrUserService.java
  *@Date: 2018年9月26日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Service
public class HrUserService implements IHrUserService{
	@Autowired
	HrUserRepository HrUserRepository;
	public HrUser findHrUserById(Long id) {
		// TODO Auto-generated method stub
		 Optional<HrUser> HrUser = HrUserRepository.findById(id);
		    if (!HrUser.isPresent()) {
		        return null;
		    }
		    return HrUser.get();
	}

	@Override
	public void insertHrUser(HrUser HrUser) {
		// TODO Auto-generated method stub
		HrUserRepository.save(HrUser);     
	}

	@Override
	public void deleteHrUser(Long id) {
		// TODO Auto-generated method stub
		HrUserRepository.deleteById(id);
	}
 
	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));	
		List<HrUser> HrUsers = (List<HrUser>) HrUserRepository.findAllById(idLists);
		HrUserRepository.deleteAll(HrUsers);
	}

	@Override
	public Page<HrUser> findAll(Specification<HrUser> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return HrUserRepository.findAll(spec, pageable);
	}
	
	
}
