Ext.define('Admin.view.salary.SalaryAnalysis', {
	extend: 'Ext.panel.Panel',
	xtype: 'salaryAnalysis',
    controller: 'salaryViewController',
    layout: 'fit',
    tbar: [
        {
            xtype: 'button',
            text: '刷新数据',
            handler: 'onReloadData'
        },{
            xtype: 'button',
            text: '保存',
            handler: 'onDownload'
        }
    ],
    items: [
        {
            xtype: 'chart',
            lookupReference: 'chart',
            id:'chart',
            insetPadding: { top: 60, bottom: 20, left: 20, right: 40 },
            store: Ext.create("Admin.store.salary.SalaryAnalysisStroe"),
            axes: [
                {
                    type: 'numeric',
                    position: 'left',
                    grid: true,
                    title: { text: '工资/元', fontSize: 16 }
                },
                {
                    type: 'category3d',
                    position: 'bottom',
                    title: { text: '时间', fontSize: 16 }
                }
            ],
            series: [
                {
                    type: 'bar3d',
                    xField: 'salaryStarTime',
                    yField: ['salarySum'],
                    label: {
		                field: 'salarySum',
		                display: 'insideEnd'
		            }
                },

            ],
            sprites: {
                type: 'text',
                text: '薪资分析',
                font: '25px Helvetica',
                width: 120,
                height: 35,
                x: 100,
                y: 40
            }
        }
    ],

    
});