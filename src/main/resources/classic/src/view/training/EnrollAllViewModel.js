Ext.define('Admin.view.training.EnrollAllViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.enrollAllViewModel',

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
    	enrollAllLists: {type: 'enrollAllGridStore'}
    }
});
