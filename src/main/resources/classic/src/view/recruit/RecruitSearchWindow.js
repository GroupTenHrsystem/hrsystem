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
            fieldLabel: '��������',
            name:'departmentname'
        }, {
            xtype: 'datefield',
            fieldLabel: 'ְλ',
            name:'position'
        }]
    }],
   
    buttons: ['->',{
	    xtype: 'button',
	    text: '�ύ',
	    handler: 'submitSearchForm'
	},{
	    xtype: 'button',
	    text: 'ȡ��',
	    handler: function(btn) {
	        btn.up('window').close();
   		 }
	},'->']
});
