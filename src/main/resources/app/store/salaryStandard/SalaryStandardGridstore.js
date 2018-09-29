Ext.define('Admin.store.salaryStandard.SalaryStandardGridStroe', {
    extend: 'Ext.data.Store',
    storeId:'salaryStandardGridStroe',
    alias: 'store.salaryStandardGridStore',
    model:'Admin.model.salaryStandard.SalaryStandardModel',
    proxy: {
        type: 'rest',
        url: '/salaryStandard',
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