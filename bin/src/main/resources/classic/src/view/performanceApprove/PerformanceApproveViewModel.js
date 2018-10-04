Ext.define('Admin.view.performanceApprove.PerformanceApproveViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.performanceApproveViewModel',
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
    	performanceApproveStore: {type: 'performanceApproveStore'}//调用组件2
    }
});
