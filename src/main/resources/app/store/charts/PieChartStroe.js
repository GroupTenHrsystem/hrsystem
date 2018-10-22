Ext.define('Admin.store.charts.PieChartStroe', {
    extend: 'Ext.data.Store',
    //storeId: 'salarySum',
    //model: 'Admin.model.salary.SalaryAnalysisModel',
   
	fields:['name','data'],
		
	data: [
        { 'name': '北京',   'data': 10 },
        { 'name': '天津',   'data':  5},
        { 'name': '上海',   'data':  8 },
        { 'name': '深圳',   'data':  7 },
        { 'name': '广州',   'data':  6 },
        { 'name': '济南',   'data':  5 },
        { 'name': '郑州',   'data':  4 },
        { 'name': '石家庄',   'data':  3 }
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