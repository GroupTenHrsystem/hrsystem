Ext.define('Aria.view.user.UserAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.userAddWindow',
    height: 730,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    x:350,
    y:20,
    scrollable: true,
    title: 'Add User Window',
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
            fieldLabel: 'Employe Num',
            name:'employeNum'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Staff Name',
            name:'staffName'
        },
        {
            xtype: 'radiogroup',
            id: 'sex',
            fieldLabel: 'Sex',
            layout: {
                autoFlex: false
            },

            defaults: {
                name: 'ccType',
                margin: '0 15 0 0'
            },

            items: [{
                boxLabel: 'man',
                name      : 'sex',
                inputValue: 'man',
                checked: true
            }, {
                boxLabel: 'woman',
                name      : 'sex',
                inputValue: 'woman'
            }]
        },{
            xtype: 'textfield',
            fieldLabel: 'Idcard',
            name:'idcard'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Email',
            name:'email'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Password',
            name:'password'
        },{
            xtype: 'textfield',
            fieldLabel: 'Address',
            name:'address'
        },{
            xtype: 'textfield',
            fieldLabel: 'NativePlace',
            name:'nativePlace'
        },{
            xtype: 'textfield',
            fieldLabel: 'Phone',
            name:'phone'
        },  {
            xtype: 'combo',
            allowBlank:false, 
            width:400,
            store: {
                type: 'array',
                fields: ['position'],
                autoLoad: true, //启动自动加载
                proxy: {
                            type: 'ajax',
                            url: '/Role/findNoParent',
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
            valueField:'position',
            displayField: 'position', //显示的field
            fieldLabel: 'Role',
            anchor: '0',
            queryMode: 'local',
            selectOnTab: false,
            name: 'roleName',
            emptyText:'请选择...',
            onReplicate: function () {
                this.getStore().clearFilter();
            }
        },{
            xtype: 'datefield',
            fieldLabel: 'Birthday',
            name:'birthday',
            format: 'Y/m/d'
        },{
            xtype: "combobox",
            name: "status",
            fieldLabel: "Status",
            store: [['实习', '实习'], ['入职', '入职'],['等待入职', '等待入职']],
            editable: false,
            displayField: "Status",
            valueField: "Value",
            emptyText: "--请选择--",
            queryMode: "local"
        }, {
            xtype: 'datefield',
            fieldLabel: 'Employment Date',
            name:'employmentDate',
            format: 'Y/m/d'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Leave Date',
            name:'leaveDate',
            format: 'Y/m/d'
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
