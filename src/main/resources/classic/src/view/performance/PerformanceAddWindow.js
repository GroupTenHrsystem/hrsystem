Ext.define('Aria.view.performance.PerformanceAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.performanceAddWindow',
    y:50,
    resizable : false,
    minWidth: 425,
    maxWidth: 425,
    width: 520,
    scrollable: true,
    title: '绩效考核',
    width: 600,
    layout:'fit',
    bodyPadding: 10,
    defaults: {
        anchor: '100%',
        labelWidth: 100
    },
    items: [{
        xtype: 'form',
        // layout: 'form',
        // padding: '10px',
        // ariaLabel: 'Enter your name',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: 'processStatus',
            name:'processStatus',
            value:'NEW',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '绩效考核名称',
            allowBlank:false, 
            regexText: '请填写',
            width:400,
            name:'performanceName'
        }, {
            xtype: 'datefield',
            fieldLabel: '考核开始时间',
            name:'startTime',
            allowBlank:false, 
            regexText: '请选择日期',
            width:400,
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: '考核结束时间',
            allowBlank:false, 
            regexText: '请选择日期',
            name:'endTime',
            width:400,
            format: 'Y/m/d H:i:s'
        }, 
    

        {
            xtype: 'combo',
            allowBlank:false, 
            width:400,
            store: {
                type: 'array',
                fields: [ 'id' ,'name'],
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
            fieldLabel: '绩效模板',
            anchor: '0',
            queryMode: 'local',
            selectOnTab: false,
            name: 'performanceTempletId',
            emptyText:'请选择...',
            onReplicate: function () {
                this.getStore().clearFilter();
            }
        },

        {
            xtype: 'treepicker',
            allowBlank:false, 
            displayField: 'departmentName',
            autoScroll:true,
            scrollable: true,
            width:400,
            minPickerHeight: 400,
            fieldLabel: '选择部门',
            flex: 1,
            //必须这样创建store
            store:Ext.create("Ext.data.TreeStore",{
                    fields: ['id','departmentName'],
                    root: {
                        departmentName: '请选择部门',
                        id:'-1',
                        expanded: true
                    },
                    rootVisible: false,
                    proxy: {
                        type: 'ajax',
                        url: '/department/findNoParent',
                        reader: {
                            type: 'json'
                        }
                    }
                }),
            listeners:{
            select:function(combo,record,index){
                    var departmentId=record.get('id');
                    //testfunction()//对应的处理函数
                    console.log(departmentId);
                    var staff = Ext.getCmp("staff");    //获取staff Combo组件
                    staff.getStore().removeAll(); // 清空已加载列表
                    staff.reset();    // 清空已存在结果
                    staff.getStore().load({
                                     params: {'departmentId': departmentId}
                                });
                }
            },
        },

        {
            xtype: 'fieldcontainer',
            combineErrors: true,
            layout: 'hbox',
            items: [{
                xtype: 'tagfield',
                allowBlank:false, 
                fieldLabel: '选择员工',
                id:'staff',
                reference:'staffTag',
               // disabled:true,
                width:340,
                store: {
                    type: 'array',
                    fields: [ 'id' ,'staffName'],
               //     autoLoad: true, //启动自动加载
                    // data: [
                    //     ['-1','全选']
                    // ],
                    proxy: {
                                type: 'rest',
                                url: '/department/departmentAllStaff',
                                reader:{
                                    type:'json',
                                    rootProperty:'',//对应后台返回的结果集名称
                                    totalProperty: 'totalElements'//分页需要知道总记录数
                                },
                                writer: {
                                    type: 'json',
                                },
                                simpleSortMode: true    //简单排序模式
                        },
                 //   autoSync: true
                },
                valueField:'id',
                displayField: 'staffName',
                name:'staffIds',
                filterPickList: true,
                queryMode: 'local',
                publishes: 'value'
            },{
                xtype: 'checkbox',
                boxLabel: '全选',
                margin: '0 0 0 10',
                listeners: {
                    change: 'toggleDisabled'  // see Controller
                }
            }]
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
