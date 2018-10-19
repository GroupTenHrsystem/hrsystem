Ext.define('Admin.view.reportAll.ReportAllViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.reportAllViewModel',

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
		reportAllLists: {type: 'reportAllGridStroe'}
    }
});
