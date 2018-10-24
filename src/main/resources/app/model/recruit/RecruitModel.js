Ext.define('Admin.model.recruit.RecruitModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'string',name: 'departmentName'},
	    {type: 'string',name: 'position'},
	    {type: 'int',name: 'planNum'},
	    {type: 'float',name: 'salary'},
	    {type: 'date',name: 'startTime', dateFormat:'Y/m/d'},
	    {type: 'date',name: 'endTime', dateFormat:'Y/m/d'},
	    {type: 'string',name: 'editName'},
	    {type: 'string', name: 'postdesc'},
	    {type: 'string', name: 'demand'},
	],
	proxy: {
		type: 'rest',
		url: '/recruit',
	}
});
