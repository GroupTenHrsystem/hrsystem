Ext.define('Admin.view.archives.ArchivesAllViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.archivesAllViewModel',

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
		archivesAllLists: {type: 'archivesAllGridStroe'}
    }
});
