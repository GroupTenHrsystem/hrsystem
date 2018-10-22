package com.hrsystem.navigationTree.controller;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: NavigationTreeController.java
  *@Date: 2018年10月22日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.navigationTree.entity.NavigationTree;
import com.hrsystem.navigationTree.service.NavigationTreeService;

@RestController
@RequestMapping("/navigationTree")
public class NavigationTreeController {
	@Autowired
	private NavigationTreeService navigationTreeService;
	
	//查找navigationTree
    @RequestMapping(value = "/findNoParent")
    public List<NavigationTree> getFindNoParentList(){
		return navigationTreeService.findNoParent();
    }
}
