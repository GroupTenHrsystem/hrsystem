Ext.define('Admin.model.salary.SalaryModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'date', name: 'salaryStarTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'date', name: 'salaryEndTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'date', name: 'createTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'float',name: 'salarySum'},
	    {type: 'string',name: 'staffName'},
	    {type: 'string',name: 'salaryStandardName'},
	],
	proxy: {
		type: 'rest',
		url: '/salary',
	}
});
