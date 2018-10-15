package com.hrsystem.salary.entity.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.common.BeanUtils;
import com.hrsystem.salary.entity.Salary;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Data
public class SalaryDTO {
            private Long id;
            @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
            private Date salaryStarTime;
            @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
            private Date salaryEndTime;
            @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
            private Date createTime;
            private Double salarySum;

            //养老保险
            private Double pension;
            //生育保险
            private Double maternity;
            //医疗保险
            private Double medicare;
            //失业保险
            private Double unemployment;
            //工伤保险
            private Double injury;
            //住房公积金
            private Double house;
            //绩效
            private Double performancesSalary;

            private Long staffIds[];                //员工列表
            private Long salaryStandardId;          //薪资标准id
            private String staffName;               //员工名字
            private String salaryStandardName;       //薪资标准名字
            private Double basis;                      //基本工资

            public static Page<SalaryDTO> toSalaryDTO(Page<Salary> page, Pageable pageable) {
                List<SalaryDTO> results = new ArrayList<SalaryDTO>();
                Iterator iter = page.iterator();
                while(iter.hasNext()){
                    SalaryDTO salaryDTO = new SalaryDTO();
                    Salary salary=(Salary)iter.next();
                    BeanUtils.copyProperties(salary,salaryDTO);
                    salaryDTO.setStaffName(salary.getStaff().getStaffName());
                    salaryDTO.setSalaryStandardName(salary.getSalaryStandard().getName());
                    salaryDTO.setBasis(salary.getSalaryStandard().getBasis());
                    results.add(salaryDTO);
                }
                return new PageImpl<SalaryDTO>(results, pageable, null!=results?page.getTotalElements():0);
            }
}
