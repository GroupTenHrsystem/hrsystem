Ext.define('Admin.view.performance.PerformancePanel', {
    extend: 'Ext.tab.Panel',
    xtype: 'performancePanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.form.field.Date',
        'Ext.grid.column.Date',
        'Ext.view.MultiSelector',
    ],
    layout: 'fit', 
    minHeight: 400,
    deferredRender: false,
    items: [
    {
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: '发起的绩效',
            iconCls: 'fa fa-adjust fa-spin',
            //routeId: 'user',
            viewModel: {type: 'performanceViewModel'},
            selModel: {type: 'checkboxmodel'},
            bind: '{performanceLists}',

            collapsible: true,
            collapseFirst: false,
            frame: true,
            minHeight: 200,

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
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'performanceName',text: '绩效考核名字',width: 90},
                {xtype: 'datecolumn',cls: 'content-column',dataIndex: 'startTime',text: '考核开始时间',formatter: 'date("Y/m/d")'},
                {xtype: 'datecolumn',cls: 'content-column',dataIndex: 'endTime',text: '考核结束时间',formatter: 'date("Y/m/d")'},
                {xtype: 'datecolumn',cls: 'content-column',dataIndex: 'applyTime',text: '发起时间',formatter: 'date("Y/m/d")'},
                {xtype: 'datecolumn',cls: 'content-column',dataIndex: 'completeTime',text: '完成时间',formatter: 'date("Y/m/d")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'staffName',text: '被考核用户',width: 80},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'performanceTempletName',text: '考核模板',width: 80},
                {xtype: 'gridcolumn',cls: 'content-column',text: '自评分数' ,dataIndex: 'selfScore',width: 30,sortable: true},  
                {xtype: 'gridcolumn',cls: 'content-column',text: '自评细节' ,dataIndex: 'selfScoreReason',width: 30,sortable: true,hidden:true},    
                {xtype: 'gridcolumn',cls: 'content-column',text: '领导评分' ,dataIndex: 'deptLeaderScore',width: 30,sortable: true},
                {xtype: 'gridcolumn',cls: 'content-column',text: '领导评分细节' ,dataIndex: 'deptLeaderScoreReason',width: 30,sortable: true,hidden:true},  
                {xtype: 'gridcolumn',cls: 'content-column',text: '最终分数' ,dataIndex: 'resultScore',sortable: true},  
                {xtype: 'gridcolumn',cls: 'content-column',text: '申诉理由' ,dataIndex: 'confirmResult',width: 80,sortable: true}, 
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {
                            xtype: 'button', iconCls: 'x-fa fa-pencil' ,
                            getClass: function(v, meta, rec) {
                                if (rec.get('processStatus')!="NEW") {
                                    return 'x-hidden';
                                }
                                return 'x-fa fa-pencil';
                            },
                            handler: 'openEditWindow'
                        },
                        // {xtype: 'button',iconCls: 'x-fa fa-close'	,handler: 'deleteOneRow'},
                      //  {xtype: 'button',iconCls: 'x-fa fa-ban'	 	,handler: 'onDisableButton'},
                        {
                            xtype: 'button',iconCls: 'x-fa fa-star',tooltip: '开始绩效考核',
                            getClass: function(v, meta, rec) {
                                if (rec.get('processInstanceId')!="") {
                                    return 'x-hidden';
                                }
                                return 'x-fa fa-star';
                            },
                            handler: 'starLeaveProcess'
                        },{ 
                            xtype: 'button', 
                            iconCls: 'x-fa fa-file' ,
                            tooltip: '查看详情',
                            handler: 'openDetailWindow'
                       }
                        // ,{
                        //     xtype: 'button',iconCls: 'x-fa fa-ban',tooltip: '取消请假',
                        //     getClass: function(v, meta, rec) {
                        //         if (rec.get('processInstanceId')=="") {
                        //             return 'x-hidden';
                        //         }
                        //         return 'x-fa fa-ban';
                        //     },
                        //     handler: 'cancelLeaveProcess'
                        // }
                    ]
                }
            ],

            features: [{
                ftype: 'grouping',
                startCollapsed: true,
                groupHeaderTpl: '{columnName}: {name} ({rows.length} 条记录{[values.rows.length > 1 ? "s" : ""]})'
            }],

            tbar: [ '->',{
		        text: 'excel',
		        tooltip: 'excel',
		        iconCls: 'fa fa-plus',
                href:'/performance/downloadExcel',
                hrefTarget:'_self'
		        //handler:  'gridExcel' 
		    },'-',{
                text: '添加',
                tooltip: 'Add a new row',
                iconCls: 'fa fa-plus',
                handler: 'openAddWindow'    
            },'-',{
		        text: '删除',
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
        },
        {
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: '参与的绩效',
            iconCls: 'fa fa-arrows fa-spin',
            collapsible: true,
            // html: 'KitchenSink.DummyText.longText'
            viewModel: {type: 'myPerformanceViewModel'},
            selModel: {type: 'checkboxmodel'},
            bind: '{myPerformanceLists}',
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
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'performanceCount',text: '待归档人数',flex: 1}
            ],
             dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                displayInfo: true,
                bind: '{myPerformanceLists}'
            }],
            // header: {
            //             itemPosition: 1, // after title before collapse tool
                        
            //         }
        }]
});
