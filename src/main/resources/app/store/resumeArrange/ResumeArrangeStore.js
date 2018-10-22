Ext.define('Admin.store.resumeArrange.ResumeArrangeStore', {
    extend: 'Ext.data.Store',
    storeId:'resumeArrangeStore',
    alias: 'store.resumeArrangeStore',
    model: 'Admin.model.resumeArrange.ResumeArrangeModel',
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