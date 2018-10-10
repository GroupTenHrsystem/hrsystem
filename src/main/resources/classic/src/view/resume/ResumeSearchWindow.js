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
            fieldLabel: '姓名',
            name:'name'
        }, {
            xtype: 'textfield',
            fieldLabel: '专业',
            name:'major'
       }, {
            xtype: 'textfield',
            fieldLabel: '政治面貌',
            name:'politicsStatus'
        }, {
            xtype: 'textfield',
            fieldLabel: '简历状态',
            name:'restatus'
        }]
    }],
   
    buttons: ['->',{
	    xtype: 'button',
	    text: '提交',
	    handler: 'submitSearchForm'
	},{
	    xtype: 'button',
	    text: '取消',
	    handler: function(btn) {
	        btn.up('window').close();
   		 }
	},'->']
});
