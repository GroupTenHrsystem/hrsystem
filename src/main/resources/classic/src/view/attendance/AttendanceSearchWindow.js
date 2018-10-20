Ext.define('Aria.view.attendance.AttendanceSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.attendanceSearchWindow',
    height: 270,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'attendance Search Window',
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
            fieldLabel: 'Staff Name',
            name:'staffName'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Create Time Start',
            name:'createTimeStart',
            format: 'Y/m/d'
        },{
            xtype: 'datefield',
            fieldLabel: 'Create Time End',
            name:'createTimeEnd',
            format: 'Y/m/d'
        }]
    }],
   
    dockedItems: {
        dock: 'bottom',
        items: [{
            xtype: 'button',
            text: 'Submit',
            handler: 'submitSearchForm'
        },{
            xtype: 'button',
            text: 'Close',
            handler: function(btn) {
                btn.up('window').close();
            }
        }]
    }
});
