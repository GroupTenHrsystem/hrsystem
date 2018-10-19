package com.hrsystem.leave.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
//@Transactional
public class LeaveProcessEndListener implements ExecutionListener{

	private static final long serialVersionUID = -2170319176143272096L;
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void notify(DelegateExecution execution) {
		// TODO Auto-generated method stub
		
	}
}
