Ext.define('Aria.view.department.DepartmentEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.departmentEditWindow',
    height: 300,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    x:270,
    y:100,
    scrollable: true,
    title: 'Edit Department Window',
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
            fieldLabel: 'Department Name',
            name:'departmentName'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Introduce',
            name:'introduce'
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
