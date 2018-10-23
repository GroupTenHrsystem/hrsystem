Ext.define('Admin.model.sign.SignModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'string',name: 'name'},
	    {type: 'date',name: 'starTime',dateFormat:'Y/m/d H:i:s'},
	    {type: 'date',name: 'endTime',dateFormat:'Y/m/d H:i:s'},
	    {type: 'date',name: 'extraStarTime',dateFormat:'Y/m/d H:i:s'},
	    {type: 'date',name: 'extraEndTime',dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name: 'state'}
	],
	proxy: {
		type: 'rest',
		url: '/Sign',
	}
});
