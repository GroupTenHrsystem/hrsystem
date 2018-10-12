package com.hrsystem.performance.entity.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.common.BeanUtils;
import com.hrsystem.performance.entity.Performance;

import lombok.Data;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceRelateDTO.java
  *@Date: 2018年10月10日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Data
public class PerformanceRelateDTO {

	private Long id;
	private String performanceName;	
	private String processInstanceId;	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date startTime; 
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date endTime;  
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date applyTime;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date completeTime;
	//private Long cycle;
	private ProcessStatus processStatus;
	private Double selfScore;
	private Double deptLeaderScore;
	private String staffName;	
	private String performanceTempletName;	
	
	
	public static Page<PerformanceRelateDTO> toPerformanceRelateDTO(Page<Performance> page, Pageable pageable) {
		List<PerformanceRelateDTO> results = new ArrayList<PerformanceRelateDTO>();
	      Iterator iter = page.iterator();
	      while(iter.hasNext()){
	         PerformanceRelateDTO performanceRelateDTO = new PerformanceRelateDTO();
	         Performance performance=(Performance)iter.next();
	         BeanUtils.copyProperties(performance,performanceRelateDTO);
	         performanceRelateDTO.setStaffName(performance.getStaff().getStaffName());
	         performanceRelateDTO.setPerformanceTempletName(performance.getPerformanceTemplet().getName());
	         results.add(performanceRelateDTO);
	      }
	      return new PageImpl<PerformanceRelateDTO> (results, pageable, null!=results?page.getTotalElements():0);
	}
}
