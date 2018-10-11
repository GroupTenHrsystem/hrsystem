Ext.define('Admin.model.performanceApprove.PerformanceApproveModel', {
    extend: 'Admin.model.Base',
    fields: [	
		 {type: 'int' ,name: 'id'}
        ,{type: 'string' ,name: 'userId'}
        ,{type: 'string' ,name: 'performanceName'}
		,{type: 'date' 	 ,name: 'startTime'}
		,{type: 'date'	 ,name: 'endTime'}
        ,{type: 'date'   ,name: 'applyTime'}
        ,{type: 'string' ,name: 'leaveType'}
        ,{type: 'string' ,name: 'processStatus'}
        
		,{type: 'string' ,name: 'reason'}
        ,{type: 'string' ,name: 'processInstanceId'}
        ,{type: 'string' ,name: 'taskId'}
        ,{type: 'string' ,name: 'taskName'}
        ,{type: 'date' ,name: 'taskCreateTime'}
        ,{type: 'string' ,name: 'assignee'}
        ,{type: 'string' ,name: 'taskDefinitionKey'}
        ,{type: 'string' ,name: 'processDefinitionId'}
        ,{type: 'boolean' ,name: 'suspended'}
        ,{type: 'int' ,name: 'version'}

        ,{type: 'float' ,name: 'selfScore'}
        ,{type: 'float' ,name: 'deptLeaderScore'}
        ,{type: 'string' ,name: 'selfScoreReason'}
        ,{type: 'string' ,name: 'deptLeaderScoreReason'}
        ,{type: 'string' ,name: 'confirmResult'}
    ]
});