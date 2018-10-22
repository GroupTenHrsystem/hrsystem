Ext.define('Admin.model.employ.EmployModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'string',name: 'name'},
	    {type: 'string',name: 'sex'},
	    {type: 'date',name: 'birthday', dateFormat:'Y/m/d'},
	    {type: 'string',name: 'nativePlace'},
	    {type: 'string',name: 'major'},
	    {type: 'string',name: 'politicsStatus'},
	    {type: 'string',name: 'graduateSchool'},
	    {type: 'string',name: 'email'},
	    {type: 'string',name: 'phone'},
	    {type: 'string',name: 'employBranch'},
	    {type: 'string',name: 'experience'},
	    {type: 'string',name: 'selfEvaluation'},
	    {type: 'string',name: 'referer'},
	    {type: 'string',name: 'attachment'},
	    {type: 'date',name: 'applyTime', dateFormat:'Y/m/d'},
	    {type:'string',name:'userId'},
	    {type:'string',name:'processStatus'},
	    {type:'string',name:'processInstanceId'}
	],
	proxy: {
		type: 'rest',
		url: '/resume/employ',
	}
});
