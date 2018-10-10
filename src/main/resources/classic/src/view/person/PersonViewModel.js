Ext.define('Admin.view.person.PersonViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.personViewModel',

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
		personLists: {type: 'PersonGridStore'}
    }
});
