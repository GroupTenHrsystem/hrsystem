Ext.define('Aria.view.person.PersonEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.personEditWindow',
    height: 700,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    x:270,
    y:20,
    scrollable: true,
    title: 'Edit Person Window',
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
            handler: 'submitEditForm'
        },{
            xtype: 'button',
            text: 'Close',
            handler: function(btn) {
                btn.up('window').close();
            }
        }]
    }
});
