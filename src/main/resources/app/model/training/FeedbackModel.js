Ext.define('Admin.model.training.FeedbackModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'string',name: 'feedbackId'},
	    {type: 'string',name: 'employeeId'},
	    {type: 'string',name: 'courseId'},
	    {type: 'string',name: 'courseHarvest'},
	    {type: 'string',name: 'courseEvaluate'},
	    {type: 'string',name: 'courseOpinion'},

	],
	proxy: {
		type: 'rest',
		url: '/feedback',
	}
});
