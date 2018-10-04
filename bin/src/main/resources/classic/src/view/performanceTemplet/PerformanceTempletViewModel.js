Ext.define('Admin.view.performanceTemplet.performanceTempletViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.performanceTempletViewModel',

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
		performanceTempletLists: {type: 'performanceTempletGridStore'}
    }
});
