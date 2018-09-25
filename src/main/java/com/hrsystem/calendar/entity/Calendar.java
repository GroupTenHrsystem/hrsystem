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

import lombok.Data;
@Data
public class Calendar 
{
 	private Long id;
 	private String title;
    private String description;
    private String color;
    private String assignedColor;
    private Boolean hidden=false;
    private Boolean editable=true; 
    private List<Event> eventStore = new ArrayList<Event>();
}
