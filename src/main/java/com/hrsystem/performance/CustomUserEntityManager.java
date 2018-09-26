//package com.hrsystem.performance;
//
//import org.activiti.engine.identity.Group;
//import org.activiti.engine.identity.Picture;
//import org.activiti.engine.identity.User;
//import org.activiti.engine.identity.UserQuery;
//import org.activiti.engine.impl.Page;
//import org.activiti.engine.impl.UserQueryImpl;
//import org.activiti.engine.impl.interceptor.Session;
//import org.activiti.engine.impl.persistence.entity.UserEntity;
//import org.activiti.engine.impl.persistence.entity.UserEntityImpl;
//import org.activiti.engine.impl.persistence.entity.UserEntityManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.hrsystem.performance.entity.HrUser;
//import com.hrsystem.performance.entity.Role;
//import com.hrsystem.performance.entity.UserRole;
//import com.hrsystem.performance.repository.HrUserRepository;
//import com.hrsystem.performance.repository.RoleRepository;
//import com.hrsystem.performance.repository.UserRoleRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
///**
//*@项目名称: hrsystem
//*@作者: HyperMuteki
//*@文件名称: CustomUserEntityManager.java
//  *@Date: 2018年9月26日
//*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
// 
//*/
//@Component
//public class CustomUserEntityManager extends UserEntityManager{
//    @Autowired
//    private HrUserRepository hrUserRepository;
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private UserRoleRepository userRoleRepository;
//    @Override
//    public User findUserById(String userId){   	
//        User userEntity = new UserEntityImpl();
//        Optional<HrUser> hrUser=hrUserRepository.findById(userId);
//        if (!hrUser.isPresent()) {
//        	 userEntity=ActivitiUserUtils.toActivitiUser(hrUser.get());
//        }else {
//        	userEntity = null;
//        }
//        return userEntity;
//    }
//
//    @Override
//    public List<Group> findGroupsByUser(final String userId) {
//        if(userId==null){
//            return null;
//        }
//        List<Role> roleList=new ArrayList<Role>();
//        List<UserRole> userRoleList=userRoleRepository.findByUserId(userId);
//        for (UserRole userrole:userRoleList) {
//            String roleId=userrole.getRoleId();
//            Optional<Role> role=roleRepository.findById(roleId);
//            if (!role.isPresent()) {
//            	roleList.add(role.get());
//            }
//        }
//        List<Group> gs=null;
//        gs=ActivitiUserUtils.toActivitiGroups(roleList);
//        return gs;
//    }
//}