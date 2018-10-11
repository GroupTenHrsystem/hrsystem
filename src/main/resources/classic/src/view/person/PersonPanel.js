Ext.define('Admin.view.person.PersonPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'personPanel',

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
            title: 'personGrid Results',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{personLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeNum',text: 'Employe Num',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'staffName',text: 'Staff Name',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'sex',text: 'Sex',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'idcard',text: 'Id card',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'email',text: 'Email',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'phone',text: 'Phone',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'status',text: 'Status',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'password',text: 'Password',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'address',text: 'Address',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'nativePlace',text: 'NativePlace',flex: 1,hidden:true},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'birthday',text: 'Birthday',formatter: 'date("Y/m/d")',hidden:true},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'employmentDate',text: 'Employment Date',formatter: 'date("Y/m/d")'},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'leaveDate',text: 'Leave Date',formatter: 'date("Y/m/d")'},
                
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
				      	{ name: '用户名', value: 'staffName' },
						{ name: '入职时间', value: 'employmentDate' }
				    ]
				}),
	            displayField: 'name',
	            valueField:'value',
	            value:'用户名',
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
                bind: '{personLists}'
            }]
        }]
});
