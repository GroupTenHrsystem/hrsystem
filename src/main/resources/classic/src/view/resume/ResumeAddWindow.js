Ext.define('Aria.view.resume.ResumeAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.resumeAddWindow',

    minHeight: 300,
    minWidth: 610,
    width: 800,
    scrollable: true,
    resizable:true,
    title: '新增简历',
    			
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Enter your name',
        items: [{
        	//xtype: 'form',
            //layout:'hbox',
            //defaultType:'textfield',
            items:[{
            	xtype:'container',
            	layout:'hbox',
            	items:[
					{items:[
					{xtype: 'textfield',fieldLabel:'id',name:'id',hidden:true,readOnly:true},
					{xtype: 'textfield',fieldLabel:'姓名',name:'name'},
					{xtype: 'textfield',fieldLabel:'性别',name:'sex'},
		    		{xtype: 'textfield',fieldLabel:'毕业学校',name:'graduateSchool'},
		    		{xtype: 'textfield',fieldLabel:'政治面貌',name:'politicsStatus'},
		    		{xtype: 'textfield',fieldLabel:'简历状态',name:'processStatus',value:'NEW',hidden:true,readOnly:true}
				]},
					{items:[
					{xtype: 'datefield',fieldLabel:'出生日期',name:'birthday',format: 'Y/m/d'},
					{xtype: 'textfield',fieldLabel:'籍贯',name:'nativePlace'},
		    		{xtype: 'textfield',fieldLabel:'专业',name:'major'},
		    		{xtype: 'textfield',fieldLabel:'邮箱',name:'email'}
				]}
				//	{items:[
			//	{xtype: 'textarea',fieldLabel:'专业',name:'major'}
		//	]}
		    		//{xtype: 'textfield',fieldLabel:'毕业学校',name:'graduateSchool'},
		    		//{xtype: 'textfield',fieldLabel:'政治面貌',name:'politicsStatus'},
		    //{xtype: 'textfield',fieldLabel:'简历状态',name:'restatus',value:'新增',hidden:true,readOnly:true}
				]
			}]
	   }, {
	   	   xtype: 'container',
	        layout:'fit',
            defaultType:'textfield',
            margin:'5 0 5 0',
           	items:[{
           		xtype: 'textfield',
           		fieldLabel: '联系方式',
				name:'phone'
	        }]
		},{
			xtype: 'container',
	        layout:'fit',
            defaultType:'textfield',
            margin:'5 0 5 0',
           	items:[{
           		xtype: 'textfield',
				fieldLabel: '求职意向',
				name:'employBranch'
	        }]
		},{
			xtype: 'container',
	        layout:'fit',
            defaultType:'textfield',
            margin:'5 0 5 0',
           	items:[{
           		xtype: 'textarea',
				fieldLabel: '工作经历',
				name:'experience'
	        }]
		},{
			xtype: 'container',
	        layout:'fit',
            defaultType:'textfield',
            margin:'5 0 5 0',
           	items:[{
           		xtype: 'textarea',
				fieldLabel: '自我评价',
				name:'selfEvaluation'
	        }]
		},{
			xtype:'container',
	        layout:'hbox',
	        items:[{
					xtype: 'checkbox',
				    boxLabel: '是否推荐',
					name:'ifrefer',
					reference:'ifrefer'
				},{
					xtype: 'textfield',
					fieldLabel: '推荐人',
					name:'referer',
					margin:'0 0 0 40',
					bind:{
						disabled:'{!ifrefer.checked}'
					}
		    }]
		},{
			xtype: 'container',
	        layout:'fit',
            defaultType:'textfield',
            margin:'5 0 5 0',
           	items:[{
           		xtype: 'datefield',
				fieldLabel: '简历填写时间',
				name:'applyTime'
	        }]
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
