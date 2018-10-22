Ext.define('Admin.view.resumeArrange.ResumeArrangeViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.resumeArrangeViewModel',
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
    	resumeArrangeStore: {type: 'resumeArrangeStore'}//调用组件2
    }
});
