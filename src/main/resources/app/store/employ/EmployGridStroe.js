Ext.define('Admin.store.employ.EmployGridStroe', {
    extend: 'Ext.data.Store',
    alias: 'store.employGridStroe',
	model:'Admin.model.employ.EmployModel',

    proxy: {
        type: 'rest',
        url: '/resume/employ',
	    reader:{
	    	type:'json',
	    	rootProperty:'content',
	    	totalProperty: 'totalElements'//分页需要知道总记录数	
	    },
	    writer: {
			type: 'json'
		},
		simpleSortMode: true
    },

    autoLoad: true,
    autoSync: true,
	remoteSort: true,//全局排序
	pageSize: 20,

    sorters: {
        direction: 'DESC',
        property: 'id'
    }
});
