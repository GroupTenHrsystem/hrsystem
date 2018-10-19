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
            style:'margin: 25px;',
            items: [{
                xtype:'schedulingPanel',
                id:'schedulingPanel'
            }]
        }]

});
