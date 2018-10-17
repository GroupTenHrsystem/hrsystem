Ext.define('Admin.view.leaveapprove.task.FirstAudit', {
    extend: 'Ext.form.Panel',
    alias: 'widget.firstAudit',
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
		fieldLabel: '一面审批',
		defaults: {
			flex: 1
		},
		items: [{
			name: 'firstPass',
			inputValue: true,
			boxLabel: '通过',
			checked: true
		}, {
			name: 'firstPass',
			inputValue: false,
			boxLabel: '不通过'
		}]
	},{
        xtype     : 'numberfield',
        grow      : true,
        name      : 'firstAuditScore',
        fieldLabel: '评分',
        //anchor    : '100%'
        minValue: 0,
        maxValue: 100,
        allowDecimals: true,
        decimalPrecision: 1,
        step: 5
    },{
        xtype     : 'textareafield',
        grow      : true,
        name      : 'firstBackReason',//修改
        fieldLabel: '驳回理由',
        anchor    : '100%'
    }],

   	bbar: [{
		xtype: 'button',
		ui: 'soft-green',
		text: '提交'	,
		handler: 'onClickFirstAuditFormSubmitButton'
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
