Ext.define('Aria.view.performance.PerformanceAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.performanceAddWindow',
    height: 400,
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
            fieldLabel: 'processStatus',
            name:'processStatus',
            value:'NEW',
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
        }, 
    

        // {
        //     xtype: 'combo',
        //     store: {
        //         type: 'array',
        //         fields: [ 'id' ,'name'],
        //         data: [
        //             // ['test@example.com','name'],         //假数据
        //             // ['someone@example.com','name'],
        //             // ['someone-else@example.com','name']
        //         ],
        //         autoLoad: true, //启动自动加载
        //         proxy: {
        //                     type: 'rest',
        //                     url: '/performanceTemplet',
        //                     reader:{
        //                         type:'json',
        //                         rootProperty:'content',//对应后台返回的结果集名称
        //                         totalProperty: 'totalElements'//分页需要知道总记录数
        //                     },
        //                     writer: {
        //                         type: 'json',
        //                     },
        //                     simpleSortMode: true    //简单排序模式
        //             },
        //         autoSync: true
        //     },
        //     mode:'local' ,
        //     editable: false,
        //     valueField:'id',
        //     displayField: 'name', //显示的field
        //  //   plugins: 'fieldreplicator',   //选中后追加文本框
        //     fieldLabel: '绩效模板',
        //     anchor: '0',
        //     queryMode: 'local',
        //     selectOnTab: false,
        //     name: 'performanceTempletId',
        //     emptyText:'请选择...',
        //   // blankText: '请选择', // 该项如果没有选择，则提示错误信息,
        //     onReplicate: function () {
        //         this.getStore().clearFilter();
        //     }
        // },

        {
            xtype: 'treepicker',
            displayField: 'departmentName',
            autoScroll:true,
            //必须这样创建store
            store:Ext.create("Ext.data.TreeStore",{
                   fields: ['id','departmentName'],
                root: {
                    departmentName: '部门',
                    id:'-1',
                    expanded: true,
                    //id:'2',
                    children: [{"id":4, "departmentName":"second",},

                        {id:"0", departmentName: "School Friends", expanded: true, children: 
                                    [
                                        {
                                            id:"1", departmentName: "Mike", leaf: true, name: "Mike", email: "mike@stackoverflow.com", phone: "345-2222"
                                        },
                                        {
                                            id:"select", departmentName: "Laura", leaf: true, name: "Laura", email: "laura@stackoverflow.com", phone: "345-3333"
                                        }
                                    ] 

                        }],
                },
                rootVisible: false,
                proxy: {
                    type: 'ajax',
                    url: '/department/findNoParent',
                    reader: {
                        type: 'json'
                    }
                }
            })
        }

        // ,{
        //     xtype: 'combo',
        //     store: {
        //         type: 'array',
        //         fields: [ 'id' ,'departmentName'],
        //         data: [
        //             // ['test@example.com','name'],         //假数据
        //             // ['someone@example.com','name'],
        //             // ['someone-else@example.com','name']
        //         ],
        //         autoLoad: true, //启动自动加载
        //         proxy: {
        //                     type: 'ajax',
        //                     url: '/department/department',
        //                     reader:{
        //                         type:'json',
        //                         rootProperty:'',//对应后台返回的结果集名称
        //                         totalProperty: 'totalElements'//分页需要知道总记录数
        //                     },
        //                     writer: {
        //                         type: 'json',
        //                     },
        //                     simpleSortMode: true    //简单排序模式
        //             },
        //         autoSync: true
        //     },
        //     mode:'local' ,
        //     editable: false,
        //     valueField:'id',
        //     displayField: 'departmentName', //显示的field
        //  //   plugins: 'fieldreplicator',   //选中后追加文本框
        //     fieldLabel: '选择部门',
        //     anchor: '0',
        //     queryMode: 'local',
        //     selectOnTab: false,
        //     name: 'departmentId',
        //     emptyText:'请选择...',
        //     listeners:{
        //     select:function(combo,record,index){
        //             var departmentId=record.get('id');
        //             //testfunction()//对应的处理函数
        //             console.log(departmentId);
        //             var staff = Ext.getCmp("staff");    //获取staff Combo组件
        //             staff.getStore().removeAll(); // 清空已加载列表
        //             staff.reset();    // 清空已存在结果
        //             staff.getStore().load({
        //                              params: {'departmentId': departmentId}
        //                         });
        //         }
        //     },
        //   // blankText: '请选择', // 该项如果没有选择，则提示错误信息,
        //     onReplicate: function () {
        //         this.getStore().clearFilter();
        //     }
        // },

        // {
        //     xtype: 'tagfield',
        //     fieldLabel: 'Select a state',
        //     id:'staff',
        //     store: {
        //         type: 'array',
        //         fields: [ 'id' ,'staffName'],
        //    //     autoLoad: true, //启动自动加载
        //         proxy: {
        //                     type: 'rest',
        //                     url: '/department/departmentAllStaff',
        //                     reader:{
        //                         type:'json',
        //                         rootProperty:'',//对应后台返回的结果集名称
        //                         totalProperty: 'totalElements'//分页需要知道总记录数
        //                     },
        //                     writer: {
        //                         type: 'json',
        //                     },
        //                     simpleSortMode: true    //简单排序模式
        //             },
        //      //   autoSync: true
        //     },
        //     valueField:'id',
        //     displayField: 'staffName',
        //     name:'staffIds',
        //     filterPickList: true,
        //     queryMode: 'local',
        //     publishes: 'value'
        // }
        
        ]
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
