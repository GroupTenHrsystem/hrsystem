Ext.define('Admin.view.charts.LineChart', {
	extend: 'Ext.panel.Panel',
		
	requires: [
        'Ext.chart.series.Line'
    ],
    	
	xtype: 'lineChart',
	layout:'fit',
    title:'line',
    items: [{
        xtype: 'cartesian',
        reference: 'chart',
        insetPadding: '20 20 10 10',
       	store: Ext.create("Admin.store.charts.LineChartStroe"),
        axes: [{
            type: 'numeric',
            position: 'left',
            fields: 'value',
            title: 'USD to Euro'
        }, {
            type: 'time',
            dateFormat: 'M d\nY',
            position: 'bottom',
            fields: 'time',
            title: 'Date'
        }],
        series: [{
            type: 'line',
            xField: 'time',
            yField: 'value'
        }]
    }]
});