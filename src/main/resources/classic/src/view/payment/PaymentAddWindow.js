Ext.define('Admin.view.payment.PaymentAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.paymentAddWindow',
    height: 350,
    minHeight: 350,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Add payment Window',
    closable: true,
    constrain: true,
    
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Enter your name',
		items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: 'processStatus',
            name:'processStatus',
            value:'NEW',
            hidden: true,
            readOnly: true
        },{
			xtype: 'textfield',
			name: 'userId',
			fieldLabel: '发起人',
			//value:loginUser,
			allowBlank: false
		},{
			xtype     : 'numberfield',
	        grow      : true,
	        name      : 'price',
	        fieldLabel: '报销金额',
	        minValue: 0,
	        allowDecimals: true,
	        decimalPrecision: 1,
	        step: 5
		},{
			xtype     : 'textareafield',
			grow      : true,
			name      : 'reason',
			fieldLabel: '报销用途',
			anchor    : '100%'
		}]
    }],
	buttons: ['->',{
        xtype: 'button',
        text: 'Submit',
        handler: 'submitAddForm'
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});