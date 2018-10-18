Ext.define('Admin.store.paymentApprove.PaymentApproveStore', {
    extend: 'Ext.data.Store',
    storeId:'paymentApproveStore',
    alias: 'store.paymentApproveStore',
    model: 'Admin.model.paymentApprove.PaymentApproveModel',
    //pageSize: 25,
    proxy: {
        type: 'ajax',
        url: 'payment/tasks', 			//需要修改
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