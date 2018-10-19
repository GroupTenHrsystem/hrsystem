Ext.define('Admin.model.training.EnrollModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'int',name: 'courseId'},
	    {type: 'int',name: 'employeeId'},
	    {type: 'string',name: 'auditStatus'},

	],
	proxy: {
		type: 'rest',
		url: '/enroll',
	}
});
