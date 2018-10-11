Ext.define('Aria.view.resume.resumeSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.resumeSearchWindow',
    height: 200,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'resume Search Window',
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
            fieldLabel: '����',
            name:'name'
        }, {
            xtype: 'textfield',
            fieldLabel: 'רҵ',
            name:'major'
       }, {
            xtype: 'textfield',
            fieldLabel: '������ò',
            name:'politicsStatus'
        }, {
            xtype: 'textfield',
            fieldLabel: '����״̬',
            name:'restatus'
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
