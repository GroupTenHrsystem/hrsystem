package com.example.demo.entity.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.entity.calendar.Event;

public class EventQueryDTO {
	private Long calendar;

	public Long getCalendar() {
		return calendar;
	}

	public void setCalendar(Long calendar) {
		this.calendar = calendar;
	}
	
	@SuppressWarnings({"serial"})
	public static Specification<Event> getWhereClause(final EventQueryDTO eventQueryDTO) {
		return new Specification<Event>() {
			@Override
			public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			
				List<Predicate> predicate = new ArrayList<>();
				if (null!=eventQueryDTO.getCalendar()) {
					predicate.add(criteriaBuilder.equal(root.get("calendarId").as(Long.class),
							eventQueryDTO.getCalendar()));
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}
}
