Ext.define('Admin.view.charts.Charts', {
    extend: 'Ext.container.Container',
    xtype: 'charts',
    	
    layout: 'responsivecolumn',
    items: [{
    	xtype:'pieChart',
    	userCls:'big-50 small-100'
	},{ 
		xtype:'lineChart',
		userCls:'big-50 small-100'	
    }]
});
