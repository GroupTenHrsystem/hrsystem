Ext.define('Admin.view.paymentApprove.PaymentApproveViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.paymentApproveViewModel',
    requires: [
        'Ext.data.Store',
        'Ext.data.proxy.Memory',
        'Ext.data.field.Integer',
        'Ext.data.field.String',
        'Ext.data.field.Date',
        'Ext.data.field.Boolean',
        'Ext.data.reader.Json'
    ],
    stores: {
    	paymentApproveStore: {type: 'paymentApproveStore'}//调用组件2
    }
});
