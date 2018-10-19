Ext.define('Aria.view.training.FeedbackSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.feedbackSearchWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '反馈表高级查询',
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
            fieldLabel: '反馈表编号',
            name:'feedbackId'
        }, {
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'employeeId'
        }, {
            xtype: 'textfield',
            fieldLabel: '课程编号',
            name:'courseId'
        }, {
            xtype: 'textfield',
            fieldLabel: '培训收获',
            name:'courseHarvest'
        }, {
            xtype: 'textfield',
            fieldLabel: '培训评价',
            name:'courseEvaluate'
        }, {
            xtype: 'textfield',
            fieldLabel: '培训意见',
            name:'courseOpinion'
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
