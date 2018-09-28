Ext.define('Admin.view.salaryStandard.salaryStandardViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.salaryStandardViewModel',

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
		salaryStandardLists: {type: 'salaryStandardGridStore'}
    }
});
