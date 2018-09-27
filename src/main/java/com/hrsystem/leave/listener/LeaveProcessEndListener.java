package com.hrsystem.leave.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: LeaveProcessEndListener.java
  *@Date: 2018年9月27日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
//@Component
//@Transactional
public class LeaveProcessEndListener implements ExecutionListener {
	private static final long serialVersionUID = -2170319176143272096L;
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void notify(DelegateExecution execution) {
		// TODO Auto-generated method stub
		
	}

//  @Autowired
//  ActivitiDao activitiDao;
//
//  @Override
//  public void notify(DelegateExecution execution) throws Exception {
//      String processInstanceId = execution.getProcessInstanceId();
//
//      int i = activitiDao.deleteFormPropertyByProcessInstanceId(processInstanceId);
//      logger.debug("清理了 {} 条历史表单数据", i);
//  }
}
