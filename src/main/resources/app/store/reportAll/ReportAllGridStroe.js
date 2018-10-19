Ext.define('Admin.store.reportAll.ReportAllGridStroe', {
    extend: 'Ext.data.Store',
    alias: 'store.reportAllGridStroe',
	model:'Admin.model.reportAll.ReportAllModel',

    proxy: {
        type: 'ajax',
        url: '/report/reportAll',
	    reader:{
	    	type:'json',
	    	rootProperty:'content',
	    	totalProperty: 'totalElements'	
	    },
	    writer: {
			type: 'json'
		},
		simpleSortMode: true
    },

    autoLoad: true,
    autoSync: true,
	remoteSort: true,
	pageSize: 20,

    sorters: {
        direction: 'DESC',
        property: 'time'
    }
});
