package com.hrsystem.salary.entity.DTO;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: SalaryStandardQueryDTO.java
  *@Date: 2018年10月8日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Data
public class SalaryStandardQueryDTO {
	private Long id;
	private Double basis;					//基本工资
	private Double subsidy;					//补贴
	private Double overtime;				//加班费/天
	private Double pensionBenefits;			//养老保险比例
	private Double medicareBenefits;		//医疗保险比例
	private Double unemploymentBenefits;	//失业保险比例
	private Double injuryBenefits;			//工伤保险比例
	private Double maternityBenefits;		//生育保险比例
	private Double houseFund;				//住房公积金比例
	private Double kpi;						//绩效比例
	private Double absence;					//缺勤比例				
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date createTimeStart; 			//创建时间范围开始
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date createTimeEnd; 			//创建时间范围结束
	private Boolean status = true;
}
