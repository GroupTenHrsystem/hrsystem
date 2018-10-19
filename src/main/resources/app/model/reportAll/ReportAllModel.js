Ext.define('Admin.model.reportAll.ReportAllModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'string',name: 'title'},
	    {type: 'string',name: 'messages'},
	    {type: 'date',name: 'time', dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name:'staffName'}
	],
	proxy: {
		type: 'rest',
		url: '/report/reportAll',
	}
});
