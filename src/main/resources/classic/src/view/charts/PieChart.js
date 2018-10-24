Ext.define('Admin.view.charts.PieChart', {
	extend: 'Ext.panel.Panel',
		
	requires: [
        'Ext.chart.series.Pie'
    ],
	xtype: 'pieChart',
    layout: 'fit',
    width:600,
    height:500,
    title:'pie 图',
    	
    items: [{
        xtype: 'polar',
        reference: 'chart',
        legend:{
        	position:'right'
        },
        store: Ext.create("Admin.store.charts.PieChartStroe"),
	    series: [{
            type: 'pie',
            xField:'data',
           	donut:true,
           	showInLegend:true,
            label: {
                field: 'name',
                contrast:true
            },
	        tips:{
 				trackMouse:true,
                renderer:function(storeItem,item){
                    var total = 0;
                    store.each(function(rec) {
                        total += rec.get('data');
                    });
                    this.setTitle(storeItem.get("data"));
                }
	        },
		    highlight:{
		    	segment:{
                    margin:20
                }
		    },
			listeners:{
				itemclick:function(o){
                    var rec=store.getAt(o.index);
                    alert(rec.get("data"));
                }
			}
         }]
     }]
});