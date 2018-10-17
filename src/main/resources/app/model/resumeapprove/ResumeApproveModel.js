Ext.define('Admin.model.resumeapprove.ResumeApproveModel', {
    extend: 'Admin.model.Base',
    fields: [	//需要修改
		{type: 'int' ,name: 'id'},
        {type: 'string' ,name: 'userId'},
        {type: 'string' ,name: 'name'},
        {type: 'string' ,name: 'processStatus'},
        {type: 'string' ,name: 'employBranch'},
		{type: 'string' ,name: 'estimate'},
		{type: 'string' ,name: 'interviewer'},
		{type: 'date' ,name: 'interviewTime'},
		{type: 'string' ,name: 'resumeBackReason'},
		{type: 'float' ,name: 'firstAuditScore'},
		{type: 'string' ,name: 'firstBackReason'},
		{type: 'float' ,name: 'lastAuditScore'},
		{type: 'string' ,name: 'lastBackReason'},
        {type: 'string' ,name: 'processInstanceId'},
        {type: 'string' ,name: 'taskId'},
        {type: 'string' ,name: 'taskName'},
        {type: 'date' ,name: 'taskCreateTime'},
        {type: 'string' ,name: 'assignee'},
        {type: 'string' ,name: 'taskDefinitionKey'},
        {type: 'string' ,name: 'processDefinitionId'},
        {type: 'boolean' ,name: 'suspended'},
        {type: 'int' ,name: 'version'}
    ]
});