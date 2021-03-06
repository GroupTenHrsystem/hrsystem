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
	    {type: 'date', name: 'applyTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'date', name: 'completeTime', dateFormat:'Y/m/d H:i:s'},
	    //{type: 'int',name: 'cycle'},
	    {type: 'string',name: 'processStatus'},
	    {type: 'string',name: 'processInstanceId'},
	  	{type:'string',name:'staffName'},
	  	{type:'string',name:'performanceTempletName'},

	  	{type: 'float' ,name: 'selfScore'},
        {type: 'float' ,name: 'deptLeaderScore'},
        {type: 'string' ,name: 'selfScoreReason'},
        {type: 'string' ,name: 'deptLeaderScoreReason'},
        {type: 'string' ,name: 'confirmResult'},
	  	//{type:'float',name:'resultScore'},
	  	
	    // {type: 'string',name: 'performanceIndex'},
	    // {type: 'string',name: 'weighting'},
	],
	proxy: {
		type: 'rest',
		url: '/performance',
	}
});