Ext.define('Admin.view.department.DepartmentPanel', {
    extend: 'Ext.tree.Panel',
    xtype: 'departmentPanel',
    controller: 'departmentViewController',
    
    requires: [
        'Ext.grid.Panel',
        'Ext.grid.property.*',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.layout.container.VBox',
        'Ext.layout.container.HBox',
        'Ext.form.field.ComboBox',
        'Ext.form.field.Date',
        'Ext.grid.column.Date',
        'Ext.pivot.Grid',
        'Ext.grid.plugin.Exporter'
    ],
//    viewModel: {
//        type: 'departmentViewModel'
//    },
//    
    layout: 'fit',
  bind: '{departmentLists}',
    columns: [
    	{xtype: 'treecolumn',text: 'departmentName',dataIndex: 'departmentName',flex: 1}
      , {xtype: 'gridcolumn',width: 400,text: 'introduce',dataIndex: 'introduce',align: 'center'}
      , {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
          items: [
              {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
              {xtype: 'button',iconCls: 'x-fa fa-plus'	,handler: 'saveOneRow'},
              {xtype: 'button',iconCls: 'x-fa fa-close'	 	,handler: 'onDeleteButton'}
          ]
      }
    ],
    
    plugins: {
        gridexporter: true
    },
    
//    listeners: {
//        documentsave: 'onDocumentSave',
//        beforedocumentsave: 'onBeforeDocumentSave'
//
//    },
    titleBar: {
        shadow: false,
        items: [{
            align: 'right',
            xtype: 'button',
            text: 'Export to ...',
            stretchMenu: true,
            arrow: false,
            menu: {
                defaults: {
                    handler: 'exportDocument'
                },
                indented: false,         
            }
        }]
    } 	

});