package com.hrsystem.performance.service;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: PerformanceTempletService.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.hrsystem.log.ServiceLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.PerformanceTemplet;
import com.hrsystem.performance.repository.PerformanceTempletRepository;
@Service
@Transactional
public class PerformanceTempletService  implements IPerformanceTempletService{
	@Autowired
	PerformanceTempletRepository performanceTempletRepository;
	@ServiceLogs(description = "通过id找绩效模板")
	public PerformanceTemplet findPerformanceTempletById(Long id) {
		// TODO Auto-generated method stub
		 Optional<PerformanceTemplet> performanceTemplet = performanceTempletRepository.findById(id);
		    if (!performanceTemplet.isPresent()) {
		        return null;
		    }
		    return performanceTemplet.get();
	}

	@Override
	@ServiceLogs(description = "插入绩效模板")
	public void insertPerformanceTemplet(PerformanceTemplet performanceTemplet) {
		// TODO Auto-generated method stub
		performanceTempletRepository.save(performanceTemplet);     
	}

	@Override
	@ServiceLogs(description = "删除绩效模板（单个）")
	public void deletePerformanceTemplet(Long id) {
		// TODO Auto-generated method stub
		performanceTempletRepository.deleteById(id);
	}
 
	@Override
	@ServiceLogs(description = "删除绩效模板（多个）")
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		performanceTempletRepository.updateAll(idLists);
	}

	@Override
	@ServiceLogs(description = "绩效模板找全部")
	public Page<PerformanceTemplet> findAll(Specification<PerformanceTemplet> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return performanceTempletRepository.findAll(spec, pageable);
	}


}
