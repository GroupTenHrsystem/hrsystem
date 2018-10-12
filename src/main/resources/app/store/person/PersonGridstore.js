Ext.define('Admin.store.person.PersonGridStore', {
    extend: 'Ext.data.Store',
    storeId:'personGridStore',
    alias: 'store.personGridStore',
    model:'Admin.model.person.PersonModel',
    proxy: {
        type: 'rest',
        url: '/person',
        reader:{
            type:'json',
            rootProperty:'',//对应后台返回的结果集名称
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