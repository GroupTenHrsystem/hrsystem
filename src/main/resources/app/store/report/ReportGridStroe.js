Ext.define('Admin.store.report.ReportGridStroe', {
    extend: 'Ext.data.Store',
    alias: 'store.reportGridStroe',
	model:'Admin.model.report.ReportModel',

    proxy: {
        type: 'rest',
        url: '/report',
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
        property: 'id'
    }
});
