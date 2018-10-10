Ext.define('Admin.view.resume.Resume', {
    extend: 'Ext.container.Container',
    xtype: 'resume',
    
    controller: 'resumeViewController',
    viewModel: {type: 'resumeViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'resumePanel'}]
});
