Ext.define('Admin.view.archives.ArchivesAddWindowUpload', {
    extend: 'Ext.window.Window',
    alias: 'widget.archivesAddWindowUpload',
    height: 200,
    minHeight: 300,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '上传附件',
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
	        fieldLabel: '上传文件:',
	        labelSeparator: '',
	        buttonConfig: {
	            xtype: 'filebutton',
	            glyph:'',
	            iconCls: 'x-fa fa-cloud-upload',
	            text: 'Browse'
	        }
	    }]
    }],
	buttons: [{
        xtype: 'button',
        text: '上传',
        handler: 'onClickUploadFormSumbitButton'
    },{
        xtype: 'button',
        text: '关闭',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});