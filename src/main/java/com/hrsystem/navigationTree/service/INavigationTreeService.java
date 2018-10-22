package com.hrsystem.navigationTree.service;

import java.util.List;

import com.hrsystem.navigationTree.entity.NavigationTree;


/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: INavigationTreeService.java
  *@Date: 2018年10月22日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
public interface INavigationTreeService {
	
	public List<NavigationTree> findNoParent();
	
}
