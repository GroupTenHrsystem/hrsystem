Ext.define('Aria.view.salary.SalaryAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.salaryAddWindow',
    height: 400,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '添加薪资信息',
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
        items:[{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'datefield',
            fieldLabel: '开始日期',
            name:'salaryStarTime',
            format: 'Y/m/d H:i:s'
        },{
            xtype: 'datefield',
            fieldLabel: '结束日期',
            name:'salaryEndTime',
            format: 'Y/m/d H:i:s'
        }, 
        // {
        //     xtype: 'textfield',
        //     fieldLabel: '钱数',
        //     name:'salarySum'
        // }
        
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
                xtype: 'checkbox',
                boxLabel: '全选此部门员工',
                listeners: {
                    change: 'toggleDisabled'  // see Controller
                }
        },

        {
                xtype: 'tagfield',
                allowBlank:false, 
                fieldLabel: '选择员工',
                id:'staff',
                reference:'staffTag',
               // disabled:true,
               // width:340,
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
