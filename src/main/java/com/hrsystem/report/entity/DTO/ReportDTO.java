package com.hrsystem.report.entity.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.common.BeanUtils;
import com.hrsystem.report.entity.Report;

import lombok.Data;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: ReportDTO.java
  *@Date: 2018年10月19日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Data
public class ReportDTO {
private Long id;
	

	private String title;

	private String messages;
	
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date time;

	private Boolean status = true;
			
	private String staffName;
	
	public static Page<ReportDTO> toReportDTO(Page<Report> page, Pageable pageable) {
		List<ReportDTO> results = new ArrayList<ReportDTO>();
	      Iterator iter = page.iterator();
	      while(iter.hasNext()){
	         ReportDTO reportDTO = new ReportDTO();
	         Report report=(Report)iter.next();
	         BeanUtils.copyProperties(report,reportDTO);
	         reportDTO.setStaffName(report.getStaff().getStaffName());
	         results.add(reportDTO);
	      }
	      return new PageImpl<ReportDTO> (results, pageable, null!=results?page.getTotalElements():0);
	}
}
