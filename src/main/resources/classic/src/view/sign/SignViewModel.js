Ext.define('Admin.view.sign.SignViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.signViewModel',

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
    	signLists: {type: 'signGridStore'},
    	attendanceLists:{type: 'attendanceSignGridStore'}
    }
});
