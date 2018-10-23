Ext.define('Aria.view.training.EnrollEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.enrollEditWindow',
    height: 400,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '作废报名信息',
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
            fieldLabel: '培训编号',
            name:'courseId',
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '培训员工编号',
            name:'employeeId',
            readOnly: true
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
        handler: 'submitEditForm'
    },{
        xtype: 'button',
        text: '关闭',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
   
});
