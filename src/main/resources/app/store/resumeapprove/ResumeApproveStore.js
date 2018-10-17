Ext.define('Admin.store.resumeapprove.ResumeApproveStore', {
    extend: 'Ext.data.Store',
    storeId:'resumeApproveStore',
    alias: 'store.resumeApproveStore',
    model: 'Admin.model.resumeapprove.ResumeApproveModel',
    //pageSize: 25,
    proxy: {
        type: 'ajax',
        url: 'resume/tasks', 			//需要修改
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