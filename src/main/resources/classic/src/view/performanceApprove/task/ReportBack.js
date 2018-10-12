Ext.define('Admin.view.performanceApprove.task.ReportBack', {
    extend: 'Ext.form.Panel',
    alias: 'widget.reportBack',
    requires: [
        'Ext.button.Button',
        'Ext.form.RadioGroup',
        'Ext.form.field.*'
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
		id: 'result',
		fieldLabel: '结果',
		defaults: {
			flex: 1
		},
		items: [{
				name: 'confirmResult',
				inputValue: true,
				boxLabel: '确认',
				checked: true
			}, {
				name: 'confirmResult',
				boxLabel: '申诉',
				inputValue: false				
			}],
		    listeners:{  
			          'change':function(){  
					      	if (Ext.getCmp("result").getValue().confirmResult == true) {  
									Ext.getCmp("resultReason").setVisible(false);  
							} else {  
									Ext.getCmp("resultReason").setVisible(true);  
							} 
			          	}  
		   			} 
	    },{
	        xtype: 'textareafield',
	        id:'resultReason',
	        hidden: true,
	        grow: true,
	        name: 'resultReason',
	        fieldLabel: '理由',
	        anchor: '100%'
	   }],
   	bbar: [{
		xtype: 'button',
		ui: 'soft-green',
		text: '提交'	,
		handler: 'onClickReportBackFormSubmitButton'
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
