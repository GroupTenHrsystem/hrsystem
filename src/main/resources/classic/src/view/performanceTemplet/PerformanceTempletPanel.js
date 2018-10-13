Ext.define('Admin.view.performanceTemplet.PerformanceTempletPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'performanceTempletPanel',

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
            title: '绩效模板管理',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{performanceTempletLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'name',text: '绩效模板名字',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'startTime',text: '开始时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'endTime',text: '结束时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'kind',text: '种类',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'performanceIndex',text: '考评指标',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'selfWeighting',text: '自评占比',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'deptLeaderWeighting',text: '领导评分占比',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close'	,handler: 'deleteOneRow'},
                        {xtype: 'button',iconCls: 'x-fa fa-ban'	 	,handler: 'onDisableButton'}
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
				      	{ name: '绩效模板名字', value: 'name' },
						{ name: '开始时间', value: 'startTime' },
                        { name: '结束时间', value: 'endTime' },
                        { name: '种类', value: 'kind' },
                        { name: '考评指标', value: 'performanceIndex' },
                        { name: '考评分值', value: 'weighting' },
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
            	name:'performanceTempletPanelSearchField'
		    }, '-',{
                xtype: 'datefield',
                hideLabel: true,
                hidden:true,
                format: 'Y/m/d H:i:s',
                reference:'searchDataFieldValue',
                fieldLabel: 'From',
                name: 'from_date'
                //,id:'from_date',
                //vtype: 'daterange',
                //endDateField: 'to_date'
            }, {
                xtype: 'datefield',
                hideLabel: true,
                hidden:true,
                format: 'Y/m/d H:i:s',
                reference:'searchDataFieldValue2',
                fieldLabel: 'To',
                name: 'to_date'
                //,id:'to_date',
                //vtype: 'daterange',
                //startDateField: 'from_date'
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
		        text: 'Add',
		        tooltip: 'Add a new row',
		        iconCls: 'fa fa-plus',
		        handler: 'openAddWindow'	
		    },'-',{
		        text: 'Removes',
		        tooltip: 'Remove the selected item',
		        iconCls:'fa fa-trash',
		        //disabled: true,
		        handler: 'deleteMoreRows'	
		    }],			
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{performanceTempletLists}'
            }]
        }]
});
