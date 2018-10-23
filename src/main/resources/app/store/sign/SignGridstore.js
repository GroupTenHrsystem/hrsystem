Ext.define('Admin.store.sign.SignGridStore', {
    extend: 'Ext.data.Store',
    storeId:'signGridStore',
    alias: 'store.signGridStore',
    model:'Admin.model.sign.SignModel',
    proxy: {
        type: 'rest',
        url: '/Sign',
        reader:{
            type:'json',
            rootProperty:'content',//对应后台返回的结果集名称
            totalProperty: 'totalElements'//分页需要知道总记录数
        },
        writer: {
            type: 'json'
        },
        simpleSortMode: true    //简单排序模式
    },
    autoLoad: true,
    autoSync: true,
    remoteSort: true,//全局排序
    pageSize: 20,
    sorters: {
        direction: 'DESC',property: 'id'
    }
});