Ext.define('Admin.model.training.TrainingAllModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'string',name: 'courseCode'},
	    {type: 'string',name: 'courseName'},
	    {type: 'string',name: 'courseAuditor'},
	    {type: 'string',name: 'personLiable'},
	    {type: 'string',name: 'courseAuditStatus'},
	    {type: 'string',name: 'courseAuditResult'},
	    {type: 'string',name: 'courseAuditor'},
	    {type: 'date', name: 'courseAuditTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'date', name: 'courseAirtime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'date', name: 'courseEndtime', dateFormat:'Y/m/d H:i:s'},

	],
	proxy: {
		type: 'rest',
		url: '/trainingAll',
	}
});
