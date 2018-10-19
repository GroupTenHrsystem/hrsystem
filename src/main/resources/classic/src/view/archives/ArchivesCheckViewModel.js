Ext.define('Admin.view.archives.ArchivesCheckViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.archivesCheckViewModel',

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
		archivesCheckLists: {type: 'archivesCheckGridStroe'}
    }
});
