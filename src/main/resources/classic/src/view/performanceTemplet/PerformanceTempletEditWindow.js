Ext.define('Aria.view.performanceTemplet.PerformanceTempletEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.performanceTempletEditWindow',
    height: 400,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Edit PerformanceTemplet Window',
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
            fieldLabel: '开始时间',
            name:'startTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: '结束时间',
            name:'endTime',
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
            xtype: 'numberfield',
            fieldLabel: '考评分值(%)',
            name: 'weighting',
            minValue: 0,
            maxValue: 1,
            allowDecimals: true,
            decimalPrecision: 2,
            step: 0.01
        }]
    }],
   
    dockedItems: {
        dock: 'bottom',
        items: [{
            xtype: 'button',
            text: 'Submit',
            handler: 'submitEditForm'
        },{
            xtype: 'button',
            text: 'Close',
            handler: function(btn) {
                btn.up('window').close();
            }
        }]
    }
});
