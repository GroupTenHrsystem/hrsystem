package com.hrsystem.navigationTree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrsystem.navigationTree.entity.NavigationTree;
import com.hrsystem.navigationTree.repository.NavigationTreeRepository;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: NavigationTreeService.java
  *@Date: 2018年10月22日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Service
public class NavigationTreeService implements INavigationTreeService{
	@Autowired
	private NavigationTreeRepository navigationTreeRepository;

	@Override
	public List<NavigationTree> findNoParent() {
		// TODO Auto-generated method stub
		return navigationTreeRepository.findNoParent();
	}

	@Override
	public void save(NavigationTree navigationTree) {
		// TODO Auto-generated method stub
		navigationTreeRepository.save(navigationTree);
	}
}
