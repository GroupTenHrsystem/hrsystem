Ext.define('Admin.view.training.EnrollAllPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'enrollAllPanel',

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
            bind: '{enrollAllLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'courseId',text: '培训编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeeId',text: '培训员工编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'auditStatus',text: '审核状态',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'auditor',text: '审核人',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'auditResult',text: '审核结果',flex: 1},
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
            	name:'enrollAllPanelSearchName1',
            	value:'auditStatus',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue1',
            	name:'enrollAllPanelSearchField1',
            	value:'待审核',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldName2',
            	name:'enrollAllPanelSearchName2',
            	value:'courseId',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue2',
            	name:'enrollAllPanelSearchField2',
            	value:'',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldName3',
            	name:'enrollAllPanelSearchName3',
            	value:'employeeId',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue3',
            	name:'enrollAllPanelSearchField3',
            	value:'',
            	hidden: true
            },'-',{
	            xtype: 'combobox',
                reference:'searchFieldName',
	            hideLabel: true,
	            store:Ext.create("Ext.data.Store", {
				    fields: ["name", "value"],
				    data: [
				      	{ name: '培训编号', value: 'courseId' },
				      	{ name: '培训员工编号', value: 'employeeId' },
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
            	name:'enrollPanelSearchField'
		    },'-',{
		        text: '查询报名',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearch'		    
			},'-',{
                text: '清空输入框',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
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
                bind: '{enrollAllLists}'
            }]
        }]
});
