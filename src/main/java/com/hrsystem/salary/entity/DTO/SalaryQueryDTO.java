package com.hrsystem.salary.entity.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import com.hrsystem.salary.entity.Salary;

import lombok.Data;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: SalaryQueryDTO.java
  *@Date: 2018年10月8日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Data
public class SalaryQueryDTO {
	private Long id;
	private Double salarySum;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date salaryTimeStart; 
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") 
	private Date salaryTimeEnd; 
	
	@SuppressWarnings({ "serial"})
	public static Specification<Salary> getWhereClause(final SalaryQueryDTO salaryQueryDTO) {
		return new Specification<Salary>() {
			@Override
			public Predicate toPredicate(Root<Salary> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			
				List<Predicate> predicate = new ArrayList<>();
				

				if (null !=salaryQueryDTO.getSalarySum()) {
					predicate.add(criteriaBuilder.equal(root.get("salarySum").as(Double.class),
							salaryQueryDTO.getSalarySum()));
				}
				if (null!=salaryQueryDTO.getSalaryTimeStart()) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("salaryTime").as(Date.class),
							salaryQueryDTO.getSalaryTimeStart()));
				}
				if (null!=salaryQueryDTO.getSalaryTimeEnd()) {
					predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("salaryTime").as(Date.class),
							salaryQueryDTO.getSalaryTimeEnd()));
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
		};
	}
}
