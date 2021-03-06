Ext.define('Admin.view.performance.PerformancePanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'performancePanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.form.field.Date',
        'Ext.grid.column.Date',
        'Ext.view.MultiSelector'
    ],
    layout: 'fit',
    items: [{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: '绩效管理',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{performanceLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true},
                {header: '进度',dataIndex: 'processStatus',width: 60,sortable: true,
                renderer: function(val) {
                            if (val =='NEW') {
                                return '<span style="color:green;">新建</span>';
                            } else if (val =='APPROVAL') {
                                return '<span style="color:blue;">审批中...</span>';
                            } else if (val =='COMPLETE') {
                                return '<span style="color:orange;">完成审批</span>';
                            }else{
                                return '<span style="color:red;">取消申请</span>';
                            }
                            return val;
                        }
                },
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'performanceName',text: '绩效考核名字',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'startTime',text: '开始时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'endTime',text: '结束时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'cycle',text: '考核周期',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'performanceCount',text: '待归档人数',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close'	,handler: 'deleteOneRow'},
                      //  {xtype: 'button',iconCls: 'x-fa fa-ban'	 	,handler: 'onDisableButton'},
                        {
                            xtype: 'button',iconCls: 'x-fa fa-star',tooltip: '发起请假',
                            getClass: function(v, meta, rec) {
                                if (rec.get('processInstanceId')!="") {
                                    return 'x-hidden';
                                }
                                return 'x-fa fa-star';
                            },
                            handler: 'starLeaveProcess'
                        },{
                            xtype: 'button',iconCls: 'x-fa fa-ban',tooltip: '取消请假',
                            getClass: function(v, meta, rec) {
                                if (rec.get('processInstanceId')=="") {
                                    return 'x-hidden';
                                }
                                return 'x-fa fa-ban';
                            },
                            handler: 'cancelLeaveProcess'
                        }
                    ]
                }
            ],
            tbar: [{
	            xtype: 'combobox',
                reference:'searchFieldName',
	            hideLabel: true,
	            store:Ext.create("Ext.data.Store", {
				    fields: ["name", "value"],
				    data: [
				      	{ name: '绩效考核名字', value: 'performanceName' },
						{ name: '开始时间', value: 'startTime' },
                        { name: '结束时间', value: 'endTime' },
                        { name: '考核周期', value: 'cycle' }
				    ]
				}),
	            displayField: 'name',
	            valueField:'value',
	            value:'请选择',
	            editable: false,
	            queryMode: 'local',
	            triggerAction: 'all',
	            emptyText: 'Select a state...',
	            width: 135,
                listeners:{
                    select: 'searchComboboxSelectChuang'
                }
	        }, '-',{
            	xtype:'textfield',
                reference:'searchFieldValue',
            	name:'performancePanelSearchField'
		    }, '-',{
                xtype: 'datefield',
                hideLabel: true,
                hidden:true,
                format: 'Y/m/d H:i:s',
                reference:'searchDataFieldValue',
                fieldLabel: 'From',
                name: 'from_date'
            }, {
                xtype: 'datefield',
                hideLabel: true,
                hidden:true,
                format: 'Y/m/d H:i:s',
                reference:'searchDataFieldValue2',
                fieldLabel: 'To',
                name: 'to_date'
         },'-',{
		        text: 'Search',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearch'
		    }, '-',{
		        text: 'Search More',
		        iconCls: 'fa fa-search-plus',
		        handler: 'openSearchWindow'	
			},'-',{
                text: 'Clear Text',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
            }, '->',{
		        text: 'excel',
		        tooltip: 'excel',
		        iconCls: 'fa fa-plus',
                href:'/performance/downloadExcel',
                hrefTarget:'_self'
		        //handler:  'gridExcel' 
		    },'-',{
                text: 'Add',
                tooltip: 'Add a new row',
                iconCls: 'fa fa-plus',
                handler: 'openAddWindow'    
            },'-',{
		        text: 'Removes',
		        tooltip: 'Remove the selected item',
		        iconCls:'fa fa-trash',
		        handler: 'deleteMoreRows'	
		    }],			
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                displayInfo: true,
                bind: '{performanceLists}'
            }]
        }]
});
