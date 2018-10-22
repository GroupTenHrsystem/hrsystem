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
