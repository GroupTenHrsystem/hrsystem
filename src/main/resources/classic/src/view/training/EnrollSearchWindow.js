Ext.define('Aria.view.training.EnrollSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.enrollSearchWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '报名高级查询2',
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
            name:'courseId'
        }, {
            xtype: 'textfield',
            fieldLabel: '培训员工编号',
            name:'employeeId'
        }]
    }],
   
    dockedItems: {
        dock: 'bottom',
        items: [{
            xtype: 'button',
            text: '提交',
            handler: 'submitSearchForm'
        },{
            xtype: 'button',
            text: '关闭',
            handler: function(btn) {
                btn.up('window').close();
            }
        }]
    }
});
