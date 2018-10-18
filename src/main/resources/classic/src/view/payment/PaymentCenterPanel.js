Ext.define('Admin.view.payment.PaymentCenterPanel', {
    extend: 'Ext.container.Container',
    xtype: 'paymentCenterPanel',
    controller: 'paymentViewController',
    viewModel: {type: 'paymentViewModel'},
    layout: 'fit',
    items: [{xtype:'paymentGridPanel'}]
});
