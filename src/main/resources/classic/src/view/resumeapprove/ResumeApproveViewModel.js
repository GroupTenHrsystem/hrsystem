Ext.define('Admin.view.resumeapprove.ResumeApproveViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.resumeApproveViewModel',
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
    	resumeApproveStore: {type: 'resumeApproveStore'}//调用组件2
    }
});
