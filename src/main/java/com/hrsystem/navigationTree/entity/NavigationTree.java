package com.hrsystem.navigationTree.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: NavigationTree.java
  *@Date: 2018年10月22日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Data
@Entity
@Table(name="t_navigationTree")
public class NavigationTree {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;		
		private String text;
		private String iconCls;
		private String viewType;
		private Boolean leaf;
		private Boolean expanded;
		private Boolean selectable;
		
		@JsonIgnore
		@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
		private NavigationTree superNode;
		@OneToMany(cascade=CascadeType.ALL,mappedBy="superNode")
		private List<NavigationTree> children =new ArrayList<NavigationTree>();
}
