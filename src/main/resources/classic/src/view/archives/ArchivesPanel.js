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
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'attach',text: '附件',flex: 1},
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
		        tooltip: '新增一条档案信息',
		        iconCls: 'fa fa-plus',
 				handler: 'openAddWindow'
		    },'-',{
		        text: '上传附件',
		        tooltip: '上传一个附件',
		        iconCls:'fa fa-trash',
		        //disabled: true,
		        handler: 'openAddWindowUpload'	
		    },'-',{
		        text: '移除档案',
		        tooltip: '移除选择的档案（作废）',
		        iconCls:'fa fa-trash',
		        //disabled: true,
		        handler: 'deleteMoreRows'	
		    },{
            	xtype:'textfield',
                reference:'searchFieldName1',
            	name:'trainingAllPanelSearchName1',
            	value:'archivesId',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue1',
            	name:'trainingAllPanelSearchField1',
            	value:'',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldName2',
            	name:'trainingAllPanelSearchName2',
            	value:'ssCard',
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
            	value:'bankCard',
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
            	value:'education',
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
            	value:'major',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue5',
            	name:'trainingAllPanelSearchField5',
            	value:'',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldName6',
            	name:'trainingAllPanelSearchName6',
            	value:'graduateSchool',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue6',
            	name:'trainingAllPanelSearchField6',
            	value:'',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldName7',
            	name:'trainingAllPanelSearchName7',
            	value:'record',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue7',
            	name:'trainingAllPanelSearchField7',
            	value:'',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldName8',
            	name:'trainingAllPanelSearchName8',
            	value:'family',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue8',
            	name:'trainingAllPanelSearchField8',
            	value:'',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldName9',
            	name:'trainingAllPanelSearchName9',
            	value:'remark',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue9',
            	name:'trainingAllPanelSearchField9',
            	value:'',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldName10',
            	name:'trainingAllPanelSearchName10',
            	value:'attach',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue10',
            	name:'trainingAllPanelSearchField10',
            	value:'',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldName11',
            	name:'trainingAllPanelSearchName11',
            	value:'arstatus',
            	hidden: true
            },{
            	xtype:'textfield',
                reference:'searchFieldValue11',
            	name:'trainingAllPanelSearchField11',
            	value:'待审核',
            	hidden: true
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
