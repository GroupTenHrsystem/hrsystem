package com.hrsystem.leave.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
@Transactional
public class FlowcountEndProcessor implements TaskListener{
	private static final long serialVersionUID = -8360605214753688651L;

	@Override
	public void notify(DelegateTask delegateTask) {
		// TODO Auto-generated method stub
		
	}
}
