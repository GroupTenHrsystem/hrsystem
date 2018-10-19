Ext.define('Admin.view.archives.ArchivesPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'archivesPanel',

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
            title: '人事档案登记与变更',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{archivesLists}',
            scrollable: false,
            columns: [
            	{xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true},
            	{xtype: 'gridcolumn', cls: 'content-column',dataIndex: 'archivesId',text: '档案编号',flex: 1},
                {xtype: 'gridcolumn', cls: 'content-column',dataIndex: 'ssCard',text: '社保卡号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'bankCard',text: '银行卡',flex: 1},                
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'education',text: '学历',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'major',text: '专业',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'graduateSchool',text: '毕业院校',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'record',text: '个人履历',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'family',text: '家庭关系信息',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'remark',text: '备注',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'attach',text: '附件上传',flex: 1},
               	{xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'arstatus',text: '档案状态',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,dataIndex: 'bool',text: '操作',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button', iconCls: 'x-fa fa-close'	,handler: 'openEditWindowDelete'}
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
				      	{ name: '档案编号', value: 'archivesId' },
				      	{ name: '档案状态', value: 'arstatus' },
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
            	name:'archivesPanelSearchField'
		    },'-',{
		        text: '快捷查询',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearch'		    
			},'-',{
		        text: '查询档案',
		        iconCls: 'fa fa-search',
		        handler: 'openSearchWindow'		    
			},'-',{
		        text: '新增档案',
		        tooltip: 'Add a new row',
		        iconCls: 'fa fa-plus',
 				handler: 'openAddWindow'
		    },'-',{
		        text: '上传附件',
		        tooltip: 'Remove the selected item',
		        iconCls:'fa fa-trash',
		        //disabled: true,
		        handler: 'openAddWindowUpload'	
		    },'-',{
		        text: '移除档案',
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
                bind: '{archivesLists}'
            }]
        }]
});
