Ext.define('Aria.view.training.TrainingAllSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.trainingAllSearchWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '培训高级查询',
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
            name:'courseCode'
        }, {
            xtype: 'textfield',
            fieldLabel: '培训名称',
            name:'courseName'
        }, {
            xtype: 'textfield',
            fieldLabel: '培训讲师',
            name:'courseLecturer'
        }, {
            xtype: 'textfield',
            fieldLabel: '负责人',
            name:'personLiable'
        }, {
            xtype: 'datefield',
            fieldLabel: '开始时间',
            name:'courseAirtime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: '结束时间',
            name:'courseEndtime',
            format: 'Y/m/d H:i:s'
        }]
    }],
   
    buttons: ['->',{
        xtype: 'button',
        text: '提交',
        handler: 'submitSearchForm'
    },{
        xtype: 'button',
        text: '关闭',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});
