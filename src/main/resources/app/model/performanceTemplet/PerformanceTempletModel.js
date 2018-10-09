Ext.define('Admin.model.performanceTemplet.PerformanceTempletModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'string',name: 'kind'},
	    {type: 'date', name: 'startTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'date', name: 'endTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name: 'performanceIndex'},
	    {type: 'float',name: 'weighting'},
	],
	proxy: {
		type: 'rest',
		url: '/performanceTemplet',
	}
});
