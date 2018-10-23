Ext.define('Aria.view.employ.EmployShowDetailsWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.employShowDetailsWindow',
    x:50,
    y:100,
    height: 380,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '笔试面试流程细节查看',
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
            fieldLabel: '姓名',
            name:'name',
            readOnly: true
		}, {
		    xtype: 'textfield',
		    fieldLabel: '一面面试官',
		    name:'firstarr',
		    readOnly: true
		}, {
		    xtype: 'textfield',
		    fieldLabel: '一面评价',
		    name:'firstBackReason',
		    readOnly: true
		}, {
		    xtype: 'textfield',
		    fieldLabel: '二面面试官',
		    name:'lastarr',
		    readOnly: true
		}, {
		    xtype: 'textfield',
		    fieldLabel: '二面评价',
		    name:'lastBackReason',
		    readOnly: true
		}, {
		    xtype: 'datefield',
            fieldLabel: '面试审批流程完成时间',
            name:'completeTime',
            format: 'Y/m/d H:i:s',
            readOnly: true
        }]
    }]
});
