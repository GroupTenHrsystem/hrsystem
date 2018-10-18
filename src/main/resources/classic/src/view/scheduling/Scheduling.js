Ext.define('Admin.view.scheduling.Scheduling', {
    extend: 'Ext.container.Container',
    xtype: 'scheduling',

    	
    // layout: 'fit',
    // items: [{xtype:'schedulingPanel'}]


     layout: {
        type: 'hbox',
        align: 'stretch'
    },
    items: [{
            xtype: 'container',
            margin: '0 20 20 0',
            items: [{xtype:'schedulingPanel'}]
        }]

});
