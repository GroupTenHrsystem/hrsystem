Ext.define('Admin.view.training.trainingAllViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.trainingAllViewModel',

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
    	trainingAllLists: {type: 'trainingAllGridStore'}
    }
});
