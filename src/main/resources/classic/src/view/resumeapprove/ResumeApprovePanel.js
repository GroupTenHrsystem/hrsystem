Ext.define('Admin.view.resumeapprove.ResumeApprovePanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'resumeApprovePanel',
	layout:'fit',
    margin: '20 20 20 20',
	controller: 'resumeApproveViewController',
    viewModel : { type: 'resumeApproveViewModel'},
	items: [{xtype:'resumeApproveGrid'}]	
});