Ext.define('Aria.view.training.EnrollAllEditWindowNo', {
    extend: 'Ext.window.Window',
    alias: 'widget.enrollAllEditWindowNo',
    height: 300,
    minHeight: 100,
    minWidth: 300,
    width: 100,
    scrollable: true,
    title: '报名不通过返回',
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
        }, {
            xtype: 'textfield',
            fieldLabel: '审核人',
            name:'auditor',
            allowBlank:false
        }, {
            xtype: 'textfield',
            fieldLabel: '审核说明',
            name:'auditResult'
        },{
            xtype: 'textfield',
            fieldLabel: 'Arstatus',
            name:'auditStatus',
            value:'待审核',
            hidden: true,
            readOnly: true
        }]
    }],

	buttons: ['->',{
	    xtype: 'button',
	    text: '提交',
	    handler: 'submitEditFormYes1'
	},{
	    xtype: 'button',
	    text: '关闭',
	    handler: function(btn) {
	        btn.up('window').close();
	    }
	},'->']
});

