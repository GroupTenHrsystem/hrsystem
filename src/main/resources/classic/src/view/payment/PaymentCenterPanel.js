Ext.define('Admin.view.payment.PaymentCenterPanel', {
    extend: 'Ext.container.Container',
    xtype: 'paymentCenterPanel',
    controller: 'paymentViewController',
    viewModel: {type: 'paymentViewModel'},
    //layout: 'fit',
    
    layout: {
        type: 'hbox',
        align: 'stretch'
    },

    items: [
    	//{xtype:'paymentGridPanel'}
		{
            xtype: 'container',
            style:'margin: 25px;',
            itemId: 'navigationPanel',

            layout: {
                type: 'vbox',
                align: 'stretch'
            },

            width: '30%',
            minWidth: 1140,
            maxWidth: 1140,

            defaults: {
                margin: '0 20 20 0'
            },

            items: [
                {
                    xtype: 'paymentGridPanel'
                }
            ]
        }
    ]
});
