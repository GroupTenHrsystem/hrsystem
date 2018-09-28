Ext.define('Admin.model.salaryStandard.SalaryStandardModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'date', name: 'salaryTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'float',name: 'salarySum'},
	],
	proxy: {
		type: 'rest',
		url: '/salaryStandard',
	}
});
