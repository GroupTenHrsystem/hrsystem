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
	
//	@SuppressWarnings({"serial"})
//	public static Specification<Event> getWhereClause(final EventQueryDTO eventQueryDTO) {
//		return new Specification<Event>() {
//			@Override
//			public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//			
//				List<Predicate> predicate = new ArrayList<>();
//				if (null!=eventQueryDTO.getCalendar()) {
//					predicate.add(criteriaBuilder.equal(root.get("calendarId").as(Long.class),
//							eventQueryDTO.getCalendar()));
//				}
//				Predicate[] pre = new Predicate[predicate.size()];
//				return query.where(predicate.toArray(pre)).getRestriction();
//			}
//		};
//	}
}
