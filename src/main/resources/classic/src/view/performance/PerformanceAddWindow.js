Ext.define('Aria.view.performance.PerformanceAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.performanceAddWindow',
    height: 350,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '添加绩效考核信息',
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
            fieldLabel: '绩效考核名称',
            name:'performanceName'
        }, {
            xtype: 'datefield',
            fieldLabel: '考核开始时间',
            name:'startTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: '考核结束时间',
            name:'endTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: '考核周期',
            name:'cycle'
        },{
            xtype: 'combo',
            store: {
                type: 'array',
                fields: [ 'id' ,'name'],
                data: [
                    // ['test@example.com','name'],         //假数据
                    // ['someone@example.com','name'],
                    // ['someone-else@example.com','name']
                ],
                autoLoad: true, //启动自动加载
                proxy: {
                            type: 'rest',
                            url: '/performanceTemplet',
                            reader:{
                                type:'json',
                                rootProperty:'content',//对应后台返回的结果集名称
                                totalProperty: 'totalElements'//分页需要知道总记录数
                            },
                            writer: {
                                type: 'json',
                            },
                            simpleSortMode: true    //简单排序模式
                    },
                autoSync: true
            },
            mode:'local' ,
            editable: false,
            valueField:'id',
            displayField: 'name', //显示的field
         //   plugins: 'fieldreplicator',   //选中后追加文本框
            fieldLabel: '绩效模板',
            anchor: '0',
            queryMode: 'local',
            selectOnTab: false,
            name: 'performanceTemplet',
            emptyText:'请选择...',
          // blankText: '请选择', // 该项如果没有选择，则提示错误信息,
            onReplicate: function () {
                this.getStore().clearFilter();
            }
        }]
    }],
   
    dockedItems: {
        dock: 'bottom',
        items: [{
            xtype: 'button',
            text: 'Submit',
            handler: 'submitAddForm'
        },{
            xtype: 'button',
            text: 'Close',
            handler: function(btn) {
                btn.up('window').close();
            }
        }]
    }
});
