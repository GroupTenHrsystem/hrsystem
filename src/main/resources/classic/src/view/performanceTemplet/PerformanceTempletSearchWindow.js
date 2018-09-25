Ext.define('Aria.view.performanceTemplet.PerformanceTempletSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.performanceTempletSearchWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'PerformanceTemplet Search Window',
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
            fieldLabel: '名字',
            name:'name'
        }, {
            xtype: 'datefield',
            fieldLabel: '开始时间开始',
            name:'startTimeStart',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: '开始时间结束',
            name:'startTimeEnd',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: '结束时间开始',
            name:'endTimeStart',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: '结束时间结束',
            name:'endTimeEnd',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: '种类',
            name:'kind'
        }, {
            xtype: 'textfield',
            fieldLabel: '考评指标',
            name:'performanceIndex'
        }, {
            xtype: 'textfield',
            fieldLabel: '考评分值',
            name:'weighting'
        }]
    }],
   
    dockedItems: {
        dock: 'bottom',
        items: [{
            xtype: 'button',
            text: 'Submit',
            handler: 'submitSearchForm'
        },{
            xtype: 'button',
            text: 'Close',
            handler: function(btn) {
                btn.up('window').close();
            }
        }]
    }
});
