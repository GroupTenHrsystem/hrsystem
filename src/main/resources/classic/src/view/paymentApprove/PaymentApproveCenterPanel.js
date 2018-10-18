Ext.define('Admin.view.paymentApprove.PaymentApproveCenterPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'paymentApproveCenterPanel',
	layout:'fit',
    margin: '20 20 20 20',
	controller: 'paymentApproveViewController',
    viewModel : { type: 'paymentApproveViewModel'},
	items: [{xtype:'paymentApproveGrid'}]	//需要修改
});