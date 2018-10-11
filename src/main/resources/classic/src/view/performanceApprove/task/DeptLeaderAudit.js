Ext.define('Admin.view.performanceApprove.task.DeptLeaderAudit', {
    extend: 'Ext.form.Panel',
    alias: 'widget.deptLeaderAudit',
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
		fieldLabel: '部门经理审批',
        hidden: true,
		defaults: {
			flex: 1
		},
		items: [{
			name: 'deptLeaderPass',
			inputValue: true,
			boxLabel: '同意',
			checked: true
		}, {
			name: 'deptLeaderPass',
			inputValue: false,
			boxLabel: '不同意'
		}]
    },{
        xtype     : 'numberfield',
        grow      : true,
        name      : 'deptLeaderScore',
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
        name      : 'deptLeaderScoreReason',
        fieldLabel: '评分细节',
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
