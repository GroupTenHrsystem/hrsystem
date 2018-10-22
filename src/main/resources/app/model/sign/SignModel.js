Ext.define('Admin.model.sign.SignModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'string',name: 'name'},
	    {type: 'date',name: 'starTime'},
	    {type: 'date',name: 'endTime'},
	    {type: 'date',name: 'extraStarTime'},
	    {type: 'date',name: 'extraEndTime'},
	    {type: 'string',name: 'state'}
	],
	proxy: {
		type: 'rest',
		url: '/Sign',
	}
});
