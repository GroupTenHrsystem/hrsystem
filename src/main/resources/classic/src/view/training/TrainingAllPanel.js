Ext.define('Admin.view.training.TrainingAllPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'trainingAllPanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.form.field.Date',
        'Ext.grid.column.Date'
    ],
    //controller: 'searchresults',
   // viewModel: {type: 'orderViewModel'},
    layout: 'fit',
    items: [{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: '培训管理',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{trainingAllLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'courseCode',text: '培训编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'courseName',text: '培训名称',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'courseLecturer',text: '培训讲师',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'personLiable',text: '负责人',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'courseAuditStatus',text: '审核状态',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'courseAirtime',text: '开始时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'courseEndtime',text: '结束时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'courseAuditor',text: '审核人',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'courseAuditResult',text: '审核结果',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'courseAuditTime',text: '审核时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: '修改',tooltip: '修改按钮 ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-save' ,handler: 'openEditWindow'},
                        {xtype: 'button', iconCls: 'x-fa fa-close'	,handler: 'openEditWindowNo'}
                    ]
                }
            ],
            tbar: [{
		        text: '查询待审核',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearchnow'		    
            },{
            	xtype:'textfield',
                reference:'searchFieldName1',
            	name:'trainingAllPanelSearchName1',
            	value:'courseAuditStatus',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue1',
            	name:'trainingAllPanelSearchField1',
            	value:'待审核',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldName2',
            	name:'trainingAllPanelSearchName2',
            	value:'courseCode',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue2',
            	name:'trainingAllPanelSearchField2',
            	value:'',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldName3',
            	name:'trainingAllPanelSearchName3',
            	value:'courseName',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue3',
            	name:'trainingAllPanelSearchField3',
            	value:'',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldName4',
            	name:'trainingAllPanelSearchName4',
            	value:'courseLecturer',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue4',
            	name:'trainingAllPanelSearchField4',
            	value:'',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldName5',
            	name:'trainingAllPanelSearchName5',
            	value:'personLiable',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue5',
            	name:'trainingAllPanelSearchField5',
            	value:'',
            	hidden: true
            },'-',{
	            xtype: 'combobox',
                reference:'searchFieldName',
	            hideLabel: true,
	            store:Ext.create("Ext.data.Store", {
				    fields: ["name", "value"],
				    data: [
				      	{ name: '培训编号', value: 'courseCode' },
				      	{ name: '培训名称', value: 'courseName' },
				      	{ name: '培训讲师', value: 'courseLecturer' },
				      	{ name: '负责人', value: 'personLiable' },
				    ]
				}),
	            displayField: 'name',
	            valueField:'value',
	            value:'请选择',
	            editable: false,
	            queryMode: 'local',
	            triggerAction: 'all',
	            emptyText: 'Select a state...',
	            width: 135
	        }, '-',{
            	xtype:'textfield',
                reference:'searchFieldValue',
            	name:'trainingPanelSearchField'
		    },'-',{
		        text: '查询培训',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearch'		    
			},'-',{
                text: '清空输入框',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
            },'-',{
		        text: '删除培训',
		        tooltip: 'Remove the selected item',
		        iconCls:'fa fa-trash',
		        //disabled: true,
		        handler: 'deleteMoreRows'	
		    }],			
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{trainingAllLists}'
            }]
        }]
});
