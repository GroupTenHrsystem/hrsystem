Ext.define('Aria.view.performanceTemplet.PerformanceTempletEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.performanceTempletEditWindow',
    x: 50,  
    y: 100,
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
            allowBlank:false, 
            name:'name'
        }, {
            xtype: 'datefield',
            fieldLabel: '开始时间',
            editable:false,
            allowBlank:false, 
            name:'startTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: '结束时间',
            editable:false,
            allowBlank:false, 
            name:'endTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            allowBlank:false, 
            fieldLabel: '种类',
            name:'kind'
        }, {
            xtype: 'numberfield',
            id: 'selfWeighting',
            fieldLabel: '自评占比(%)',
            allowBlank:false, 
            name: 'selfWeighting',
            minValue: 0,
            maxValue: 1,
            allowDecimals: true,
            decimalPrecision: 2,
            step: 0.01,
            listeners:{ 
                change:function() 
                    { 
                        if( Ext.getCmp('selfWeighting').getValue!=""&&Ext.getCmp('selfWeighting').getValue()!="0"){                               
                            Ext.getCmp('deptLeaderWeighting').setValue(1-Ext.getCmp('selfWeighting').getValue());//即时计算并填充                      } 
                        }             
                }
            }
        }, {
            xtype: 'numberfield',
            id: 'deptLeaderWeighting',
            fieldLabel: '领导评分占比(%)',
            allowBlank:false, 
            name: 'deptLeaderWeighting',
            minValue: 0,
            maxValue: 1,
            allowDecimals: true,
            decimalPrecision: 2,
            step: 0.01,
            listeners:{ 
                change:function() 
                    {   
                        if( Ext.getCmp('deptLeaderWeighting').getValue!=""){
                            Ext.getCmp('selfWeighting').setValue(1-Ext.getCmp('deptLeaderWeighting').getValue());//即时计算并填充                      } 
                        } 
                }
            }
        }]
    }],
   
    dockedItems: {
        dock: 'bottom',
        items: [{
            xtype: 'button',
            text: '提交',
            handler: 'submitEditForm'
        },{
            xtype: 'button',
            text: '关闭',
            handler: function(btn) {
                btn.up('window').close();
            }
        }]
    }
});
