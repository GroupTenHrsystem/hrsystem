Ext.define('Admin.view.recruit.RecruitPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'recruitPanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.grid.column.Date',
        'Ext.form.field.Date',
        'Ext.selection.CheckboxModel'
    ],
    layout: 'fit',
    items: [{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: '招聘发布',
            bind: '{recruitLists}',
            scrollable: false,
            selModel:{type:'checkboxmodel',checkOnly:true},
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'key',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'departmentName',text: '部门名称',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'position',text: '职位'},
                {xtype: 'gridcolumn',width: 100,dataIndex: 'planNum',text: '计划人数'},
                {xtype: 'gridcolumn',width: 100,dataIndex: 'salary',text: '薪资'},
                {xtype: 'datecolumn',cls: 'content-column',width:200,dataIndex: 'startTime',text: '开始时间',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width:200,dataIndex: 'endTime',text: '截止时间',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'editName',text: '发布人'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'contact',text: '联系方式'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'postdesc',text: '职位描述'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'demand',text: '要求',hidden:true},
                {xtype: 'actioncolumn',cls: 'content-column', width: 160,dataIndex: 'bool',text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close'	,handler: 'deleteOneRow'},
                		{xtype: 'button',iconCls: 'x-fa fa-search-plus',handler: 'openBiggerWindow'}
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
				      	{ name: '部门名称', value: 'departmentName' },
						{ name: '职位', value: 'position' }
				    ]
				}),
	            displayField: 'name',//展示的字段
	            valueField:'value',//获取值的字段
	            value:'departmentName',//设置默认值
	            editable: false,//不可编辑
	            queryMode: 'local',
	            triggerAction: 'all',
	            emptyText: 'Select a state...',
	            width: 135
	        }, '-',{
            	xtype:'textfield',
            	reference:'searchFieldValue',
            	name:'recruitPanelSearchField'
            }, '-', {
		        text: 'Search',
		        iconCls: 'fa fa-search',
		        handler:'quickSearch'
			}, '->',{
		        text: '新增',
		        tooltip: 'Add a new row',
		        iconCls: 'fa fa-plus',
				handler: 'openAWindow'	
		    },'-',{
		        text: 'Removes',
		        tooltip: 'Remove the selected item',
		        iconCls:'fa fa-trash',
		       	handler:'deleteMoreRows',
		        itemId:'recruitGridPanelRemove',
		        disabled: true
		    }],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{recruitLists}'
            }],
            listeners:{
	          selectionchange:function(selModel,selections){
	            this.down('#recruitGridPanelRemove').setDisabled(selections.length === 0);}
	          }
        	}]
});
