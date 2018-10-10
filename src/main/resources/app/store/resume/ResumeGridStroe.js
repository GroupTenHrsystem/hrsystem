Ext.define('Admin.store.resume.ResumeGridStroe', {
    extend: 'Ext.data.Store',
    alias: 'store.resumeGridStroe',
	model:'Admin.model.resume.ResumeModel',

    proxy: {
        type: 'rest',
        url: '/resume',
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
