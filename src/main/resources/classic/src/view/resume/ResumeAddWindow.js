﻿Ext.define('Aria.view.resume.ResumeAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.resumeAddWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '新增简历',
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
            name:'name'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: '性别',
		    name:'sex'
		}, {
            xtype: 'datefield',
            fieldLabel: '出生日期',
            name:'birthday',
            format: 'Y/m/d'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: '籍贯',
		    name:'nativePlace'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: '专业',
		    name:'major'
		}, {
		    xtype: 'textfield',
		    fieldLabel: '政治面貌',
		    name:'politicsStatus'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: '毕业学校',
		    name:'graduateSchool'
		}, {
		    xtype: 'textfield',
		    fieldLabel: '邮箱',
		    name:'email'
		}, {
		    xtype: 'textfield',
		    fieldLabel: '联系方式',
		    name:'phone'
		}, {
		    xtype: 'textfield',
		    fieldLabel: '应聘职位',
		    name:'employBranch'
		}, {
		    xtype: 'textfield',
		    fieldLabel: '工作经历',
		    name:'experience'
		}, {
		    xtype: 'datefield',
            fieldLabel: '应聘时间',
            name:'applyTime',
            format: 'Y/m/d H:i:s'
		}, {
		    xtype: 'textfield',
		    fieldLabel: '简历状态',
		    name:'restatus'
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
