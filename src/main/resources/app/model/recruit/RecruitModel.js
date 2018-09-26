Ext.define('Admin.model.recruit.RecruitModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'recruitId'},
	    {type: 'string',name: 'departmentname'},
	    {type: 'string',name: 'position'},
	    {type: 'int',name: 'planNum'},
	    {type: 'float',name: 'salary'},
	    {type: 'date',name: 'startTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'date',name: 'endTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name: 'editName'},
	    {type: 'string', name: 'postdesc'},
	    {type: 'string', name: 'demand'},
	],
	proxy: {
		type: 'rest',
		url: '/recruit',
	}
});
