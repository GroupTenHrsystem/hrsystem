Ext.define('Admin.store.training.TrainingAllGridStroe', {
    extend: 'Ext.data.Store',
    storeId:'trainingAllGridStroe',
    alias: 'store.trainingAllGridStore',
    model:'Admin.model.training.TrainingAllModel',
    proxy: {
        type: 'rest',
        url: '/training',
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