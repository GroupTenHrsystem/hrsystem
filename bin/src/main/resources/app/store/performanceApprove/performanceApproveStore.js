Ext.define('Admin.store.performanceApprove.PerformanceApproveStore', {
    extend: 'Ext.data.Store',
    storeId:'performanceApproveStore',
    alias: 'store.performanceApproveStore',
    model: 'Admin.model.performanceApprove.PerformanceApproveModel',
    //pageSize: 25,
    proxy: {
        type: 'ajax',
        url: 'performance/tasks', 			//需要修改
        reader : new Ext.data.JsonReader({  
            type : 'json',  
            rootProperty  : 'content',
            totalProperty : 'totalElements'
        })
        ,simpleSortMode: true
    },
    remoteSort: true,
    sorters: [{ property: 'id',direction: 'desc'}],
    autoLoad: true
});	