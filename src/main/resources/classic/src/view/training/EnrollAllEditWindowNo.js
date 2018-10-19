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
            handler: 'submitEditFormYes1'
        },{
            xtype: 'button',
            text: '关闭',
            handler: function(btn) {
                btn.up('window').close();
            }
        }]
    }
});

