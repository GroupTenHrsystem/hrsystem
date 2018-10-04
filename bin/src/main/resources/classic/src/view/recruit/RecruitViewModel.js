Ext.define('Admin.view.recruit.RecruitViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.recruitViewModel',

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
		recruitLists: {type: 'recruitGridStroe'}
    }
});
