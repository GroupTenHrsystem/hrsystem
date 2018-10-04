Ext.define('Admin.view.performanceApprove.PerformanceApproveCenterPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'performanceApproveCenterPanel',
	layout:'fit',
    margin: '20 20 20 20',
	controller: 'performanceApproveViewController',
    viewModel : { type: 'performanceApproveViewModel'},
	items: [{xtype:'performanceApproveGrid'}]	//需要修改
});