Ext.define('Admin.store.charts.PieChartStroe', {
    extend: 'Ext.data.Store',
    //storeId: 'salarySum',
    //model: 'Admin.model.salary.SalaryAnalysisModel',
   
	fields:['name','data'],
		
	data: [
        { 'name': '本科',   'data': 10 },
        { 'name': '博士',   'data':  5},
        { 'name': '硕士',   'data':  8 },
        { 'name': '专科',   'data':  7 },
        { 'name': '教授',   'data':  6 },
        { 'name': '本科以下',   'data':  5 },
    ],
    proxy: {
        type: 'memory',
        //url: '~api/search/users'	//mvc url  xxx.json
	    reader:{
	    	type:'json',
	    	rootProperty:'lists'
	    }
    },

    autoLoad: 'true',

    sorters: {
        direction: 'ASC',
        property: 'fullname'
    }
});