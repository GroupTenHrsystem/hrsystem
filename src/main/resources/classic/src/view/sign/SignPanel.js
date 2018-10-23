Ext.define('Admin.view.sign.SignPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'signPanel',

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
    items: [
    	 
    	{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: 'SignGrid Results',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{signLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'name',text: 'Name',flex: 1,hidden:true},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'starTime',text: '签到',flex: 1,formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'endTime',text: '签退',flex: 1,formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'extraStarTime',text: '加班签到',flex: 1,formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'extraEndTime',text: '加班签退',flex: 1,formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'state',text: '状态',flex: 1}
            ],		
            tbar: [{
                text: '签到',
//                iconCls: 'fa fa-eraser',
                handler: 'signIn' 
            }, '->',{
		        text: '签退',
		        tooltip: 'Add a new row',
//		        iconCls: 'fa fa-plus',
		        handler: 'signBack'	
		    },'->',{
		        text: '加班签到',
		        tooltip: 'Remove the selected item',
//		        iconCls:'fa fa-trash',
		        //disabled: true,
		        handler: 'extraSignIn'	
		    },'->',{
		        text: '加班签退',
		        tooltip: 'Remove the selected item',
//		        iconCls:'fa fa-trash',
		        //disabled: true,
		        handler: 'extraSignBack'	
		    }],	
            dockedItems: [{
            	xtype: 'gridpanel',
                cls: 'user-grid',
                //routeId: 'user',
                selModel: {type: 'checkboxmodel'},
                bind: '{attendanceLists}',
                scrollable: false,
                columns: [
                    {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true},
                    {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeName',text: '姓名',flex: 1},
                    {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeNum',text: '员工编号',flex: 1},
                    {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'delateCount',text: '迟到次数',flex: 1},
                    {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'leaveEarlyCount',text: '早退次数',flex: 1},
                    {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'leaveCount',text: '请假次数',flex: 1},
                    {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'absenTime',text: '旷工次数',flex: 1},
                    {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'totalTime',text: '工作总时间',flex: 1},
                    {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'extraTime',text: '加班总时间',flex: 1}      
                ]
            }]
    	}]
        
});
