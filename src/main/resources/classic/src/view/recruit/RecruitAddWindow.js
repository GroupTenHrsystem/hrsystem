Ext.define('Aria.view.recruit.RecruitAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.recruitAddWindow',
    x:-600,
    y:100,
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '招聘发布',
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
		    name:'position'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: '计划人数',
		    name:'planNum'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: '薪资',
		    name:'salary'
		}, {
            xtype: 'datefield',
            fieldLabel: '开始时间',
            name:'startTime',
            format: 'Y/m/d'
        }, {
            xtype: 'datefield',
            fieldLabel: '截止时间',
            name:'endTime',
            format: 'Y/m/d'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: '发布人',
		    name:'editName'
    	}, {
    		xtype: 'textfield',
		    fieldLabel: '联系方式',
		    name:'contact'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: '职位描述',
		    name:'postdesc'
        }, {
            xtype: 'textfield',
            fieldLabel: '要求',
            name:'demand'
        }]
    }],

	buttons: ['->',{
	    xtype: 'button',
	    text: '提交',
	    handler: 'submitAddForm'
	},{
	    xtype: 'button',
	    text: '取消',
	    handler: function(btn) {
	        btn.up('window').close();
   		 }
	},'->']
});
