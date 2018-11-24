Ext.define('Admin.store.charts.PieChartStroe', {
    extend: 'Ext.data.Store',
   
	fields:['name','data'],
		
	data: [
        { 'name': '本科',   'data': 10 },
        { 'name': '博士',   'data':  5},
        { 'name': '硕士',   'data':  8 },
        { 'name': '专科',   'data':  7 },
        { 'name': '教授',   'data':  6 },
        { 'name': '本科以下',   'data':  5 },
    ],
    /*proxy: {
        type: 'ajax',
        url: '/resume/getEduation',
	    reader:{
            type:'json',
            rootProperty:'content'
        },
        writer: {
            type: 'json'
        },
        simpleSortMode: true 
    },*/

    autoLoad: true,
    autoSync: true,
    remoteSort: true
});