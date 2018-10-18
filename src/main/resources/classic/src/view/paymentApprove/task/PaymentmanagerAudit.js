Ext.define('Admin.view.paymentapprove.task.PaymentmanagerAudit', {
    extend: 'Ext.form.Panel',
    alias: 'widget.paymentmanagerAudit',
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
		xtype: 'radiogroup',
		fieldLabel: '人事经理审批',
		defaults: {
			flex: 1
		},
		items: [{
			name: 'paymentmanagerPass',
			inputValue: true,
			boxLabel: '同意',
			checked: true
		}, {
			name: 'paymentmanagerPass',
			inputValue: false,
			boxLabel: '不同意'
		}]
    },{
        xtype     : 'textareafield',
        grow      : true,
        name      : 'backReason',//修改
        fieldLabel: '驳回理由',
        anchor    : '100%'
    }],

   	bbar: [{
		xtype: 'button',
		ui: 'soft-green',
		text: '提交'	,
		handler: 'onClickPaymentmanagerAuditFormSubmitButton'
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
