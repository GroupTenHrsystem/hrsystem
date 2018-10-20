package com.hrsystem.calendar.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.calendar.entity.Calendar;


/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: CalendarRepository.java
  *@Date: 2018年10月20日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Repository
public interface CalendarRepository extends PagingAndSortingRepository<Calendar, Long>,JpaSpecificationExecutor<Calendar>{

}
