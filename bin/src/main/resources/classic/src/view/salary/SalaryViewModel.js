Ext.define('Admin.view.salary.salaryViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.salaryViewModel',

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
		salaryLists: {type: 'salaryGridStore'}
    }
});
