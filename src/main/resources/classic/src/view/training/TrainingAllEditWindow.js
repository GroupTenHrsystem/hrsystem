Ext.define('Aria.view.training.TrainingAllEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.trainingAllEditWindow',
    height: 300,
    minHeight: 100,
    minWidth: 300,
    width: 100,
    scrollable: true,
    title: '审核通过记录',
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
            xtype: 'datefield',
            fieldLabel: '审核时间',
            name:'courseAuditTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: '审核人',
            name:'courseAuditor'
        }, {
            xtype: 'textfield',
            fieldLabel: '审核结果',
            name:'courseAuditResult'
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
