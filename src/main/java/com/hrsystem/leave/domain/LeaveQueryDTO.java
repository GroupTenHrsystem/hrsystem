package com.hrsystem.leave.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import com.hrsystem.common.sign.Like;

import lombok.Data;

@Data
public class LeaveQueryDTO {

	private String userId;
	
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")  
	private Date startTime;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")  
	private Date endTime;
	
	@SuppressWarnings({ "serial"})
	public static Specification<Leave> getWhereClause(final LeaveQueryDTO leaveQueryDTO) {
		return new Specification<Leave>() {
			@Override
			public Predicate toPredicate(Root<Leave> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			
				List<Predicate> predicate = new ArrayList<>();
		
				if (null!=leaveQueryDTO.getUserId()) {
					predicate.add(criteriaBuilder.equal(root.get("userId").as(String.class),
							leaveQueryDTO.getUserId()));
				}
				
				if (null!=leaveQueryDTO.getStartTime()) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startTime").as(Date.class),
							leaveQueryDTO.getStartTime()));
				}
				if (null!=leaveQueryDTO.getEndTime()) {
					predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("endTime").as(Date.class),
							leaveQueryDTO.getEndTime()));
				}
				
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}
	

}
