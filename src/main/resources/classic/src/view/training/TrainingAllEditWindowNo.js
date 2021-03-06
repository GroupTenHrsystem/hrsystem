Ext.define('Aria.view.training.TrainingAllEditWindowNo', {
    extend: 'Ext.window.Window',
    alias: 'widget.trainingAllEditWindowNo',
    height: 300,
    minHeight: 100,
    minWidth: 300,
    width: 100,
    scrollable: true,
    title: '审核不通过记录',
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
            xtype: 'datefield',
            fieldLabel: '审核时间',
            name:'courseAuditTime',
            format: 'Y/m/d H:i:s',
            allowBlank:false
        }, {
            xtype: 'textfield',
            fieldLabel: '审核人',
            name:'courseAuditor',
            allowBlank:false
        }, {
            xtype: 'textfield',
            fieldLabel: '审核说明',
            name:'courseAuditResult'
        },{
            xtype: 'textfield',
            fieldLabel: 'Arstatus',
            name:'courseAuditStatus',
            value:'待审核',
            hidden: true
        }]
    }],
   
    buttons: ['->',{
	    xtype: 'button',
	    text: '提交',
	    handler: 'submitEditFormYes1'
	},{
	    xtype: 'button',
	    text: '关闭',
	    handler: function(btn) {
	        btn.up('window').close();
	    }
	},'->']
});

