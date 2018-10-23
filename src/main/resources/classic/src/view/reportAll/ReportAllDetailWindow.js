Ext.define('Aria.view.reportAll.ReportAllDetailWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.reportAllDetailWindow',
    x: 50,  
    y: 100,
    resizable : false,
    minWidth: 520,
    maxWidth: 520,
    width: 520,
    scrollable: true,
    title: '汇报内容',
    width: 600,
    bodyPadding: 10,
    defaults: {
        anchor: '100%',
        labelWidth: 100
    },
    items: [{
        xtype: 'form',
        //ariaLabel: 'Enter your name',
        // height: 600,
        // minHeight: 600,
        // maxHeight: 600,
       
    items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'htmleditor',
            id:'messages',
            name:'messages',
            flex: 1,
            minHeight: 100,
            labelAlign: 'top',
            fieldLabel: '内容',
        }
       ]
    }]
});
