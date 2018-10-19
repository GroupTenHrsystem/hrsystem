Ext.define('Admin.view.training.FeedbackPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'feedbackPanel',

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
            title: '反馈表管理',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{feedbackLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'feedbackId',text: '反馈表编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeeId',text: '员工编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'courseId',text: '课程编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'courseHarvest',text: '培训收获',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'courseEvaluate',text: '培训评价',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'courseOpinion',text: '培训意见',flex: 1}
                /*
                 ,
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'}
                    ]
                }
                */
            ],
            tbar: [{
	            xtype: 'combobox',
                reference:'searchFieldName',
	            hideLabel: true,
	            store:Ext.create("Ext.data.Store", {
				    fields: ["name", "value"],
				    data: [
				      	{ name: '反馈表编号', value: 'feedbackId' },
				      	{ name: '员工编号', value: 'employeeId' },
				      	{ name: '课程编号', value: 'courseId' },
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
	        },'-',{
            	xtype:'textfield',
                reference:'searchFieldValue',
            	name:'feedbackPanelSearchField'
		    },'-',{		    	
		        text: '查询反馈表',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearch'
			},'-',{
                text: '清空输入框',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
            }, '->',{
		        text: '新增反馈表',
		        tooltip: 'Add a new row',
		        iconCls: 'fa fa-plus',
		        handler: 'openAddWindow'	
		    },'-',{
		        text: '删除反馈表',
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
                bind: '{feedbackLists}'
            }]
        }]
});
