Ext.define('Admin.model.salary.SalaryAnalysisModel', {
    extend: 'Ext.data.Model',
    fields: [
    		{type: 'string', name: 'salaryStarTime',
    			convert:function(value){  
			            var createTime = Ext.Date.format(new Date(value),"Y-m-d");
			             return createTime;  
			        } 
     		},
    		// 'salaryStarTime', 
    		'salarySum'
    		]
});
