Ext.define('Aria.view.recruit.RecruitEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.recruitEditWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '修改发布信息',
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
            fieldLabel: '部门名称',
            name:'departmentname'
        }, {
            xtype: 'textfield',
            fieldLabel: '职位',
            name:'position',
	    }, {
	        xtype: 'textfield',
	        fieldLabel: '计划人数',
	        name:'planNum',
	    }, {
	        xtype: 'textfield',
	        fieldLabel: '薪资',
	        name:'salary',
	    }, {
	        xtype: 'datefield',
	        fieldLabel: '开始时间',
	        name:'startTime',
	    }, {
	        xtype: 'datefield',
	        fieldLabel: '截止时间',
	        name:'endTime',
	    }, {
	        xtype: 'textfield',
	        fieldLabel: '发布人',
	        name:'editName',
	   	}, {
	        xtype: 'textfield',
	        fieldLabel: '职位描述',
	        name:'postdesc',
	    }, {
	        xtype: 'textfield',
	        fieldLabel: '要求',
	        name:'demand',
        }]
    }],
   
    buttons: ['->',{
	    xtype: 'button',
	    text: '提交',
	    handler: 'submitEditForm'
	},{
	    xtype: 'button',
	    text: '取消',
	    handler: function(btn) {
	        btn.up('window').close();
   		 }
	},'->']
});
