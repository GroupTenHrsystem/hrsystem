Ext.define('Admin.view.salaryStandard.SalaryStandardPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'salaryStandardPanel',
    requires: [
        'Ext.grid.filters.Filters',
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.form.field.Date',
        'Ext.grid.column.Date',
        'Ext.view.MultiSelector'
    ],
    layout: 'fit',
    //bodyStyle :'overflow-x:scroll;overflow-y:scroll',
    items: [{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: '薪资标准管理',
            selModel: {type: 'checkboxmodel'},
            bind: '{salaryStandardLists}',
            //bodyStyle :'overflow-x:scroll;overflow-y:scroll',
            columns: [
                {xtype: 'gridcolumn',width: 40, dataIndex: 'id',text: 'Key',hidden:true},
                {xtype: 'gridcolumn',width: 60, cls: 'content-column',dataIndex: 'createTime',text: '创建日期',flex: 1,formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',width: 60, cls: 'content-column',dataIndex: 'name',text: '名字',flex: 1},
                {xtype: 'gridcolumn',width: 60, cls: 'content-column',dataIndex: 'basis',text: '基本工资',flex: 1},
                {xtype: 'gridcolumn',width: 60, cls: 'content-column',dataIndex: 'subsidy',text: '补贴',flex: 1},
                {xtype: 'gridcolumn',width: 60, cls: 'content-column',dataIndex: 'overtime',text: '加班费/天',flex: 1},
                {xtype: 'gridcolumn',width: 150, cls: 'content-column',dataIndex: 'pensionBenefits',text: '养老保险比例',flex: 1},
                {xtype: 'gridcolumn',width: 150, cls: 'content-column',dataIndex: 'medicareBenefits',text: '医疗保险比例',flex: 1},
                {xtype: 'gridcolumn',width: 150, cls: 'content-column',dataIndex: 'unemploymentBenefits',text: '失业保险比例',flex: 1},
                {xtype: 'gridcolumn',width: 150, cls: 'content-column',dataIndex: 'injuryBenefits',text: '工伤保险比例',flex: 1},
                {xtype: 'gridcolumn',width: 150, cls: 'content-column',dataIndex: 'maternityBenefits',text: '生育保险比例',flex: 1},
                {xtype: 'gridcolumn',width: 150, cls: 'content-column',dataIndex: 'houseFund',text: '住房公积金比例',flex: 1},
                {xtype: 'gridcolumn',width: 60, cls: 'content-column',dataIndex: 'kpi',text: '绩效比例',flex: 1},
                {xtype: 'gridcolumn',width: 60, cls: 'content-column',dataIndex: 'absence',text: '缺勤比例',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: '操作',tooltip: 'edit ',
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
				      	{ name: '创建日期', value: 'creatTime' },
						{ name: '基本工资', value: 'basis' }
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
            	name:'performancePanelSearchField'
		    }, '-',{
                xtype: 'datefield',
                hideLabel: true,
                hidden:true,
                format: 'Y/m/d H:i:s',
                reference:'searchDataFieldValue',
                fieldLabel: 'From',
                name: 'from_date'
            }, {
                xtype: 'datefield',
                hideLabel: true,
                hidden:true,
                format: 'Y/m/d H:i:s',
                reference:'searchDataFieldValue2',
                fieldLabel: 'To',
                name: 'to_date'
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
		        handler: 'deleteMoreRows'	
		    }],			
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                displayInfo: true,
                bind: '{salaryStandardLists}'
            }]
        }]
});
