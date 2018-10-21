Ext.define('Admin.view.resumeArrange.ResumeArrangePanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'resumeArrangePanel',
	layout:'fit',
    margin: '20 20 20 20',
	controller: 'resumeArrangeViewController',
    viewModel : { type: 'resumeArrangeViewModel'},
	items: [{xtype:'resumeArrangeGrid'}]	
});