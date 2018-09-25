package com.hrsystem.performance.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import lombok.Data;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: User.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Data
@Entity
@Table(name="t_user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
     * 用户名
     */
    private String userName;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 登陆密码
     */
    private String passWord;
    /**
     * 手机号
     */
    private String telPhone;
    /**
     * 一个用户可以参加多个绩效
     */

    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "User_Performance",
	joinColumns = {@JoinColumn(name = "user_id")},
	inverseJoinColumns = {@JoinColumn(name = "performance_id")}) 
    private List<Performance> performanceList=new ArrayList<>();

}
