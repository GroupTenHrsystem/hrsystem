Ext.define('Admin.view.training.TrainingPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'trainingPanel',

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
            bind: '{trainingLists}',
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
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: '修改',tooltip: '修改按钮 ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'}
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
				      	{ name: '培训编号', value: 'courseCode' },
				      	{ name: '培训名称', value: 'courseName' },
				      	{ name: '培训讲师', value: 'courseLecturer' },
				      	{ name: '负责人', value: 'personLiable' },
				      	{ name: '审核状态', value: 'courseAuditStatus' },
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
            }, '->',{
		        text: '新增培训',
		        tooltip: 'Add a new row',
		        iconCls: 'fa fa-plus',
		        handler: 'openAddWindow'	
		    },'-',{
		        text: '删除',
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
                bind: '{trainingLists}'
            }]
        }]
});
