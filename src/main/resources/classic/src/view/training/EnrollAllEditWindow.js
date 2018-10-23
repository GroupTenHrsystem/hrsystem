Ext.define('Aria.view.training.EnrollAllEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.enrollAllEditWindow',
    height: 200,
    minHeight: 100,
    minWidth: 300,
    width: 100,
    scrollable: true,
    title: '报名通过提交',
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
        handler: 'submitEditFormYes'
    },{
        xtype: 'button',
        text: '关闭',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});
