Ext.define('Admin.view.employ.Employ', {
    extend: 'Ext.container.Container',
    xtype: 'employ',
    
    controller: 'employViewController',
    viewModel: {type: 'employViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'employPanel'}]
});
