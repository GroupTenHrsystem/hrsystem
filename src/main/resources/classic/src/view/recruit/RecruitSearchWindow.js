Ext.define('Aria.view.recruit.recruitSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.recruitSearchWindow',
    height: 200,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'recruit Search Window',
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
            fieldLabel: 'Order Number',
            name:'orderNumber'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Create Time',
            name:'createTime',
            format: 'Y/m/d H:i:s'
        }]
    }],
   
    buttons: ['->',{
	    xtype: 'button',
	    text: 'Submit',
	    handler: 'submitSearchForm'
	},{
	    xtype: 'button',
	    text: 'Close',
	    handler: function(btn) {
	        btn.up('window').close();
   		 }
	},'->']
});
