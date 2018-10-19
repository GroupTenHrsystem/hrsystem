Ext.define('Admin.view.role.RolePanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'rolePanel',

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
            title: 'RoleGrid Results',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{roleLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Id',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'position',text: 'Position',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'limite',text: 'Limite',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'departmentId',text: 'Department Id',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'departmentName',text: 'Department Name',flex: 1},
                
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close'	,handler: 'deleteOneRow'}
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
				      	{ name: '部门', value: 'departmentName' },
						{ name: '权限', value: 'limite' }
				    ]
				}),
	            displayField: 'name',
	            valueField:'value',
	            value:'部门',
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
            	name:'userPanelSearchField'
		    }, '-',{
                xtype: 'textfield',
                hideLabel: true,
                hidden:true,
                reference:'searchDataFieldValue',
                fieldLabel: 'From',
                name: 'from_date'
                //,id:'from_date',
                //vtype: 'daterange',
                //endDateField: 'to_date'
            },'-',{
		        text: 'Search',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearch'
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
                bind: '{roleLists}'
            }]
        }]
});
