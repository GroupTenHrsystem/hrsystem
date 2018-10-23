Ext.define('Aria.view.resume.ResumeAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.resumeAddWindow',
	x:50,
	y:100,
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
		    		{	xtype: 'combobox',
		    			fieldLabel:'专业',
		    			name:'major',
			    		store:Ext.create("Ext.data.Store",{
			    			fields:["name","value"],
				    		data:[
				    			{name:'本科',value:'本科'},
				    			{name:'博士',value:'博士'},
				    			{name:'专科',value:'专科'},
				    			{name:'硕士',value:'硕士'},
				    			{name:'教授',value:'教授'},
				    			{name:'专科以下',value:'专科以下'}
				    		]
			    		})
		    		},
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
	        margin:'5 0 5 0',
	        items:[{
					xtype: 'checkbox',
				    boxLabel: '是否推荐',
					name:'ifrefer',
					reference:'ifrefer',
					inputValue:'true'
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
			xtype:'container',
			layout:'fit',
			margin:'5 0 5 0',
			items:[{
				xtype: 'filefield',
            	fieldLabel: '附件:',
            	name:'attachment',
            	labelSeparator: '',
            	buttonConfig: {
                    xtype: 'filebutton',
                   //name:'attachment',
                    glyph:'',
                    iconCls: 'x-fa fa-cloud-upload',
                    text: '上传附件'
                    //handler: 'onClickresumeUploadButton'	
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
