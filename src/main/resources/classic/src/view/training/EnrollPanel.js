Ext.define('Admin.view.training.EnrollPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'enrollPanel',

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
            title: '报名管理',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{enrollLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'courseId',text: '培训编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeeId',text: '培训员工编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'auditStatus',text: '审核状态',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: '作废',tooltip: '修改按钮 ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-close' ,handler: 'openEditWindow'}
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
				      	{ name: '培训编号', value: 'courseId' },
				      	{ name: '培训员工编号', value: 'employeeId' },
				      	{ name: '审核状态', value: 'auditStatus' },
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
		        text: '查询报名',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearch'		    
			},'-',{
                text: '清空输入框',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
            }, '->',{
		        text: '新增报名',
		        tooltip: 'Add a new row',
		        iconCls: 'fa fa-plus',
		        handler: 'openAddWindow'	
		    },'-',{
		        text: '删除报名',
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
                bind: '{enrollLists}'
            }]
        }]
});
