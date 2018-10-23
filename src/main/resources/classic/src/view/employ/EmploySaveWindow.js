Ext.define('Aria.view.employ.EmploySaveWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.employSaveWindow',
    x:50,
   	y:100,
    height: 300,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '应聘者存档',
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
            fieldLabel: '员工工号',
            name:'employeNum'
        }, {
        	xtype: 'textfield',
            fieldLabel: '实习部门',
            name:'departmentName'
        }, {
            xtype: 'datefield',
            fieldLabel: '入职时间',
            name:'employmentDate',
            format: 'Y/m/d H:i:s'
        }]
    }],
    buttons: ['->',{
	    xtype: 'button',
	    text: '提交',
	    handler: 'saveIntoStaffFormSubmit'
	},{
	    xtype: 'button',
	    text: '取消',
	    handler: function(btn) {
	        btn.up('window').close();
   		 }
	},'->']
});
