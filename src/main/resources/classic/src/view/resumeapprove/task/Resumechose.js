Ext.define('Admin.view.resumeapprove.task.Resumechose', {
    extend: 'Ext.form.Panel',
    alias: 'widget.resumechose',
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
		fieldLabel: '简历审批',
		defaults: {
			flex: 1
		},
		items: [{
			name: 'deptLeaderPass',
			inputValue: true,
			boxLabel: '通过',
			checked: true
		}, {
			name: 'deptLeaderPass',
			inputValue: false,
			boxLabel: '不通过'
		}]
    },{
        xtype     : 'textareafield',
        grow      : true,
        name      : 'resumeBackReason',//修改
        fieldLabel: '审批理由',
        anchor    : '100%'
    }],

   	bbar: [{
		xtype: 'button',
		ui: 'soft-green',
		text: '提交'	,
		handler: 'onClickDeptleaderAuditFormSubmitButton'
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
