Ext.define('Admin.model.salaryStandard.SalaryStandardModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'float',name: 'basis'},
	    {type: 'float',name: 'subsidy'},
	    {type: 'float',name: 'overtime'},
	    {type: 'float',name: 'pensionBenefits'},
	    {type: 'float',name: 'medicareBenefits'},
	    {type: 'float',name: 'unemploymentBenefits'},
	    {type: 'float',name: 'injuryBenefits'},
	    {type: 'float',name: 'houseFund'},
	    {type: 'float',name: 'kpi'},
	    {type: 'float',name: 'absence'},
	    {type: 'date', name: 'createTime', dateFormat:'Y/m/d H:i:s'},
	    // {type: 'float',name: 'maternityBenefits'},
	],
	proxy: {
		type: 'rest',
		url: '/salaryStandard',
	}
});
