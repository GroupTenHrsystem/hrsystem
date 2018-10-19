Ext.define('Admin.view.training.trainingViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.trainingViewModel',

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
    	trainingLists: {type: 'trainingGridStore'}
    }
});
