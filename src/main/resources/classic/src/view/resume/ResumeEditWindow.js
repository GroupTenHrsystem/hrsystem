Ext.define('Aria.view.resume.ResumeEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.resumeEditWindow',
    x:50,
    y:100,
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '修改简历',
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
            fieldLabel: 'processStatus',
            name:'processStatus',
            value:'NEW',
            hidden:true,
            readOnly:true
        }, {
            xtype: 'textfield',
            fieldLabel: '姓名',
            name:'name'
    	}, {
		    xtype: 'combobox',
		    allowBlank:false,
			fieldLabel:'性别',
			name:'sex',
			displayField:'sex',
			valueField:'value',
    		store:Ext.create("Ext.data.Store",{
    			fields:["sex","value"],
    			data:[
    				{sex:'男',value:'男'},
    				{sex:'女',value:'女'}
    			]	
	    	})
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
	    	xtype: 'combobox',
			fieldLabel:'专业',
			name:'major',
			displayField:'major',
			valueField:'value',
    		store:Ext.create("Ext.data.Store",{
    			fields:["major","value"],
    			data:[
    				{major:'本科',value:'本科'},
    				{major:'博士',value:'博士'},
    				{major:'专科',value:'专科'},
    				{major:'硕士',value:'硕士'},
    				{major:'教授',value:'教授'},
    				{major:'专科以下',value:'专科以下'},
    			]	
	    	})
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
