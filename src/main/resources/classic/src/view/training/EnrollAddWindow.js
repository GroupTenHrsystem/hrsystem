Ext.define('Aria.view.training.EnrollAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.enrollAddWindow',
    height: 400,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '报名填写',
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
        },
        /*{
            xtype: 'textfield',
            fieldLabel: '培训编号',
            name:'courseId'
        }, */
        {
            xtype: 'combo',
            allowBlank:false, 
            width:400,
            store: {
                type: 'array',
                fields: [ 'id' ,'courseCode'],
                autoLoad: true, //启动自动加载
                proxy: {
                            type: 'rest',
                            url: '/training/trainingpass',
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
            valueField:'courseCode',
            displayField: 'courseCode', //显示的field
            fieldLabel: '培训',
            anchor: '0',
            queryMode: 'local',
            selectOnTab: false,
            name: 'courseId',
            emptyText:'请选择...',
            onReplicate: function () {
                this.getStore().clearFilter();
            }
        },

    
        
        {
            xtype: 'textfield',
            fieldLabel: '培训员工编号',
            name:'employeeId',
            allowBlank:false
        }, {
            xtype: 'textfield',
            fieldLabel: 'Arstatus',
            name:'auditStatus',
            value:'待审核',
            hidden: true
        }]
    }],
   
    buttons: ['->',{
        xtype: 'button',
        text: '提交',
        handler: 'submitAddForm'
    },{
        xtype: 'button',
        text: '关闭',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});
