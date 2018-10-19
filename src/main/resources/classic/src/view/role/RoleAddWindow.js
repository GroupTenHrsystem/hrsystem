Ext.define('Aria.view.role.RoleAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.roleAddWindow',
    height: 300,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    x:270,
    y:20,
    scrollable: true,
    title: 'Add Role Window',
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
            fieldLabel: 'Position',
            name:'position'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Limite',
            name:'limite'
        },
        {
        	xtype: 'treepicker',
            allowBlank:false, 
            displayField: 'departmentName',
            autoScroll:true,
            scrollable: true,
            width:400,
            name:'departmentId',
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
                })
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
