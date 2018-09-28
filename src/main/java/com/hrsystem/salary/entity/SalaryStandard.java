package com.hrsystem.salary.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: SalaryStandard.java
  *@Date: 2018年9月28日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Data
@Entity
@Table(name = "t_salary_standard")
public class SalaryStandard {
			@Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;
			private Double basis;
			private Double subsidy;
			private Double overtime;
			private Double pensionBenefits;
			private Double medicareBenefits;
			private Double unemploymentBenefits;
			private Double injuryBenefits;
			private Double maternityBenefits;
			private Double houseFund;
			private Double kpi;
			private Double absence;
			private Boolean status = false;
}
