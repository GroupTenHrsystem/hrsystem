Ext.define('Admin.view.user.userViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.userViewModel',

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
		userLists: {type: 'userGridStore'}
    }
});
