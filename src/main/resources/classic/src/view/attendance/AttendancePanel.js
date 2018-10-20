Ext.define('Admin.view.attendance.AttendancePanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'attendancePanel',

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
            title: 'attendanceGrid Results',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{attendanceLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeName',text: 'Employe Name',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeNum',text: 'Employe Num',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'delateCount',text: '迟到次数',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'leaveEarlyCount',text: '早退次数',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'leaveCount',text: '请假次数',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'absenTime',text: '旷工次数',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'totalTime',text: '工作总时间',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'extraTime',text: '加班总时间',flex: 1},
                
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
				      	{ name: '员工姓名', value: 'employeName' },
						{ name: '员工号', value: 'employeNum' }
				    ]
				}),
	            displayField: 'name',
	            valueField:'value',
	            value:'员工姓名',
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
                bind: '{attendanceLists}'
            }]
        }]
});
