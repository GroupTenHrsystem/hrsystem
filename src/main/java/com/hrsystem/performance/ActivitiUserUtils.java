//package com.hrsystem.performance;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.activiti.engine.identity.Group;
//import org.activiti.engine.identity.User;
//import org.activiti.engine.impl.persistence.entity.GroupEntity;
//import org.activiti.engine.impl.persistence.entity.GroupEntityImpl;
//import org.activiti.engine.impl.persistence.entity.UserEntityImpl;
//
//import com.hrsystem.performance.entity.HrUser;
//import com.hrsystem.performance.entity.Role;
//
///**
//*@项目名称: hrsystem
//*@作者: HyperMuteki
//*@文件名称: ActivitiUserUtils.java
//  *@Date: 2018年9月26日
//*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
// 
//*/
//public class ActivitiUserUtils {
//    public static User toActivitiUser(HrUser hrUser){
//        User userEntity=new UserEntityImpl();
//        userEntity.setId(hrUser.getId());
//        userEntity.setFirstName(hrUser.getLoginName());
//        userEntity.setLastName(hrUser.getLoginName());
//        userEntity.setPassword(hrUser.getPassWord());
//        return userEntity;
//    }
//    public static GroupEntity toActivitiGroup(Role role){
//        GroupEntity groupEntity=new GroupEntityImpl();
//        groupEntity.setRevision(1);
//        groupEntity.setType("assignment");
//        groupEntity.setId(role.getId());
//        groupEntity.setName(role.getRole());
//        return groupEntity;
//    }
//    public static List<Group> toActivitiGroups(List<Role> role){
//        List<Group> groups=new ArrayList<Group>();
//        for (Role Role:role) {
//            GroupEntity groupEntity=toActivitiGroup(Role);
//            groups.add(groupEntity);
//        }
//        return groups;
//    }
//}
