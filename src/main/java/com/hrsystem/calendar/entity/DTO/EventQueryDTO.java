package com.hrsystem.calendar.entity.DTO;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: EventQueryDTO.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.calendar.entity.Event;
import com.hrsystem.common.sign.Name;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.PerformanceTemplet;

import lombok.Data;


@Data
public class EventQueryDTO {
	
	@Name("calendarId")
	private Long calendar;
	
}
