Ext.define('Admin.model.performance.PerformanceModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'string',name: 'performanceName'},
	    {type: 'date', name: 'startTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'date', name: 'endTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'int',name: 'cycle'},
	    {type:'string',name:'staffName'}
	    // {type: 'string',name: 'performanceIndex'},
	    // {type: 'string',name: 'weighting'},
	],
	proxy: {
		type: 'rest',
		url: '/performance',
	}
});
