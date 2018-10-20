Ext.define('Aria.view.salaryStandard.SchedulingdAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.schedulingdAddWindow',
    x: 50,  
    y: 100,  
    height: 200,
    minHeight: 200,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '添加类型',
    iconCls: 'fa fa-calendar',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        items: [
         {
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '名字',
            name:'title',
            allowBlank:false, 
        },{
            xtype: 'colorfield',
            fieldLabel: '颜色',
            name:'color',
            allowBlank:false, 
            labelWidth: 75,
            bind: '{color}',
            listeners: {
                change: 'onChange'
            }
        },{
            xtype: 'colorselector',
            hidden: true,
            flex: 1,
            bind: {
                value: '{color}',
                visible: '{full}'
            }
        }]
    }],
   
    dockedItems: {
        dock: 'bottom',
        items: [{
            xtype: 'button',
            text: '提交',
            handler: 'submitAddForm'
        },{
            xtype: 'button',
            text: '关闭',
            handler: function(btn) {
                btn.up('window').close();
            }
        }]
    }
});
