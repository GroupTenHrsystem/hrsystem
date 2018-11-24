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
	    {type: 'float',name: 'salarySum',dateFormat:'0.00'},
	    {type: 'string',name: 'staffName'},
	    {type: 'string',name: 'salaryStandardName'},

		{type: 'float',name: 'pension',dateFormat:'0.00'},
		{type: 'float',name: 'maternity',dateFormat:'0.00'},
		{type: 'float',name: 'medicare',dateFormat:'0.00'},
		{type: 'float',name: 'unemployment',dateFormat:'0.00'},
		{type: 'float',name: 'injury',dateFormat:'0.00'},
		{type: 'float',name: 'house',dateFormat:'0.00'},
		{type: 'float',name: 'performancesSalary',dateFormat:'0.00'},
		{type: 'float',name: 'subsidy',dateFormat:'0.00'},
		{type: 'float',name: 'delateCount',dateFormat:'0.00'},
		{type: 'float',name: 'leaveEarlyCount',dateFormat:'0.00'},
		{type: 'float',name: 'absenTime',dateFormat:'0.00'},
	],
	proxy: {
		type: 'rest',
		url: '/salary',
	}
});
