Ext.define('Admin.view.performance.performanceViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.performanceViewModel',

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
		performanceLists: {type: 'performanceGridStore'}
    }
});
