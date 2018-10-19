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
            name:'auditor'
        }, {
            xtype: 'textfield',
            fieldLabel: '审核结果',
            name:'auditResult'
        }]
    }],
   
    dockedItems: {
        dock: 'bottom',
        items: [{
            xtype: 'button',
            text: '提交',
            handler: 'submitEditFormYes'
        },{
            xtype: 'button',
            text: '关闭',
            handler: function(btn) {
                btn.up('window').close();
            }
        }]
    }
});
