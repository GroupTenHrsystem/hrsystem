Ext.define('Admin.model.paymentApprove.PaymentApproveModel', {
    extend: 'Admin.model.Base',
    fields: [	//需要修改
		 {type: 'int' ,name: 'id'}
        ,{type: 'string' ,name: 'userId'}
		,{type: 'date' 	 ,name: 'startTime'}
		,{type: 'date'	 ,name: 'endTime'}
		,{type: 'float' 	 ,name: 'price'}
		,{type: 'string' ,name: 'reason'}
        ,{type: 'string' ,name: 'processStatus'}
        ,{type: 'string' ,name: 'processInstanceId'}
        ,{type: 'string' ,name: 'taskId'}
        ,{type: 'string' ,name: 'taskName'}
        ,{type: 'date' ,name: 'taskCreateTime'}
        ,{type: 'string' ,name: 'assignee'}
        ,{type: 'string' ,name: 'taskDefinitionKey'}
        ,{type: 'string' ,name: 'processDefinitionId'}
        ,{type: 'boolean' ,name: 'suspended'}
        ,{type: 'int' ,name: 'version'}
    ]
});