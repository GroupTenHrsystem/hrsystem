package com.hrsystem.calendar.entity;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: Calendar.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "t_calendar")
public class Calendar 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Long id;
 	private String title;
    private String description;
    private String color;
    private String assignedColor;
    private Boolean hidden=false;
    private Boolean editable=true; 
}
