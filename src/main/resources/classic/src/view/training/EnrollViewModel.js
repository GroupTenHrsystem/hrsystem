Ext.define('Admin.view.training.enrollViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.enrollViewModel',

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
    	enrollLists: {type: 'enrollGridStore'}
    }
});
