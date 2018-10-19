Ext.define('Admin.model.training.EnrollAllModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'int',name: 'courseId'},
	    {type: 'int',name: 'employeeId'},
	    {type: 'string',name: 'auditStatus'},
	    {type: 'string',name: 'auditResult'},
	    {type: 'string',name: 'auditor'},
	],
	proxy: {
		type: 'rest',
		url: '/enrollAll',
	}
});
