Ext.define('Admin.store.recruit.RecruitGridStroe', {
    extend: 'Ext.data.Store',
    alias: 'store.recruitGridStroe',
    storeId:'recruitGridStroe',
	model:'Admin.model.recruit.RecruitModel',
    proxy: {
        type: 'rest',
        url: '/recruit',
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
        property: 'recruitId'
    }
});
