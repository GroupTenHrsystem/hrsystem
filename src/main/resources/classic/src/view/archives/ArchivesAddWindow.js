Ext.define('Admin.view.archives.ArchivesAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.archivesAddWindow',
    height: 700,
    minHeight: 350,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '新增档案',
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
            fieldLabel: '档案编号',
            name:'archivesId'
        },{
            xtype: 'textfield',
            fieldLabel: '社保卡号',
            name:'ssCard'
        }, {
            xtype: 'textfield',
            fieldLabel: '银行卡',
            name:'bankCard'
        }, {
            xtype: 'textfield',
            fieldLabel: '学历',
            name:'education'
        }, {
            xtype: 'textfield',
            fieldLabel: '专业',
            name:'major'
        },{
            xtype: 'textfield',
            fieldLabel: '毕业学校',
            name:'graduateSchool'
        },{
            xtype: 'textfield',
            fieldLabel: '个人履历',
            name:'record'
        },{
            xtype: 'textfield',
            fieldLabel: '家庭关系信息',
            name:'family'
        },{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'remark'
        },{
            xtype: 'textfield',
            fieldLabel: 'Arstatus',
            name:'arstatus',
            value:'待审核',
            hidden: true
        },/*{
            xtype: 'textfield',
            fieldLabel: '附件',
            name:'attach'
        }
        ,{
			xtype:'filefield',
			fieldLabel:'附件添加',
			id:'uploadinput',
			name:'attach',
			blankText:'请上传文件',
			anchor:'90%'
		},*/
		{
        	xtype: 'filefield',
	        width: 400,
	        labelWidth: 80,
			id:'uploadinput',
	        name:'attach',
	        emptyText: 'Select an zip/bpmn/bpmn.20.xml file!', 
	        fieldLabel: '附件选择:',
	        labelSeparator: '',
	        buttonConfig: {
	            xtype: 'filebutton',
	            glyph:'',
	            iconCls: 'x-fa fa-cloud-upload',
	            text: 'Browse'
	        }
	    }]
    }],
	buttons: ['->',{
        xtype: 'button',
        text: '提交',
        handler: 'submitAddForm'
    },{
        xtype: 'button',
        text: '关闭',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});