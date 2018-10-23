package com.hrsystem.navigationTree.controller;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: NavigationTreeController.java
  *@Date: 2018年10月22日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.common.SessionUtil;
import com.hrsystem.navigationTree.entity.NavigationTree;
import com.hrsystem.navigationTree.service.NavigationTreeService;
import com.hrsystem.user.entity.Role;
import com.hrsystem.user.service.StaffService;

@RestController
@RequestMapping("/navigationTree")
public class NavigationTreeController {
	@Autowired
	private NavigationTreeService navigationTreeService;
	@Autowired
	private StaffService staffService;
	
	//查找navigationTree
    @RequestMapping(value = "/findNoParent")
    public List<NavigationTree> getFindNoParentList(HttpSession session){
    	String userId = SessionUtil.getUserName(session);
		if(userId!=null) {
			String position = staffService.findStaffByName(userId).getRole().getPosition();
			System.out.println(position);
			if(position.equals("financeManager") || position.equals("financeClerk"))
				return navigationTreeService.findNoParent(1);	//财务
			else if(position.equals("admin"))
				return navigationTreeService.findNoParent(2);	//管理员
			else
				return navigationTreeService.findNoParent(3);	//普通员工
		}
		else {
			return navigationTreeService.findNoParent(0);
		}
    }
}
