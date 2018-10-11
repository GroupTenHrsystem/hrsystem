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
	    	totalProperty: 'totalElements'//��ҳ��Ҫ֪���ܼ�¼��	
	    },
	    writer: {
			type: 'json'
		},
		simpleSortMode: true
    },

    autoLoad: true,
    autoSync: true,
	remoteSort: true,//ȫ������
	pageSize: 20,

    sorters: {
        direction: 'DESC',
        property: 'id'
    }
});
