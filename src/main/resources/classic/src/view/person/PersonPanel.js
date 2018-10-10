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
   // height: 200,
   //  minHeight: 100,
   //  minWidth: 300,
   //  width: 500,
   //  scrollable: true,
   //  title: 'Add User Window',
   //  closable: true,
   //  constrain: true,
   //  defaultFocus: 'textfield',
   //  modal:true,
   layout: 'fit',
    items: [{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: 'UserGrid Results',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{personLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeNum',text: 'User Name',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'staffName',text: 'Create Time'},
                
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close'   ,handler: 'deleteOneRow'},
                        {xtype: 'button',iconCls: 'x-fa fa-ban'     ,handler: 'onDisableButton'}
                    ]
                }
            ],
            
        }]
});
