Ext.define('Admin.view.resumeapprove.task.Lastarrange', {
    extend: 'Ext.form.Panel',
    alias: 'widget.lastarrange',
    requires: [
        'Ext.button.Button',
        'Ext.form.RadioGroup',
        //'Ext.form.field.Radio', 
        'Ext.form.field.*'
        //'Ext.form.field.File',
        //'Ext.form.field.Date',
        //'Ext.form.field.ComboBox',
        //'Ext.form.field.HtmlEditor'
    ],
    bodyPadding: 10,
    bodyBorder: true,
    defaults: {
        anchor: '100%'
    },
    fieldDefaults: {
        labelAlign: 'left',
        msgTarget: 'none',
        invalidCls: '' 
    },
    items: [{
    	xtype: 'textfield',
		name: 'taskId',
		fieldLabel: '任务ID',
        hidden: true,
        readOnly: true
	},{
		xtype: 'textfield',
        name: 'id',
        fieldLabel: 'ID',
        hidden: true,
        readOnly: true
	},{
        xtype: 'textfield',
        name: 'lastarr',
        fieldLabel: '二面面试官'		
    },{
        xtype: 'datefield',
        name: 'lastTime',
        fieldLabel: '二面时间',
        format: 'Y/m/d H:i:s'
    }],

   	bbar: [{
		xtype: 'button',
		ui: 'soft-green',
		text: '提交'	,
		handler: 'onClickLastarrangeFormSubmitButton'
	},{
		xtype: 'button',
		ui: 'gray',
		text: '取消',
		handler:function(btn){
			var win = btn.up('window');
	        if (win) {
	            win.close();
	        }
		}
	}]
});
