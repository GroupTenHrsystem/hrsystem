Ext.define('Admin.view.archives.ArchivesSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.archivesSearchWindow',
    height: 700,
    minHeight: 300,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Search More Window',
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
        },{
            xtype: 'textfield',
            fieldLabel: '档案编号',
            name:'archivesId'
        }, {
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
        }, {
            xtype: 'textfield',
            fieldLabel: '毕业学校',
            name:'graduateSchool'
        }, {
            xtype: 'textfield',
            fieldLabel: '履历',
            name:'record'
        }, {
            xtype: 'textfield',
            fieldLabel: '家庭信息',
            name:'family'
        }, {
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'remark'
        }, {
            xtype: 'textfield',
            fieldLabel: '附件',
            name:'attach'
        },{
			xtype: 'combobox',
			name: 'arstatus',
			fieldLabel: '档案状态',
			//vtype: 'email',
			store: Ext.create('Ext.data.Store', {
				fields: ['value', 'name'],
				data : [
					{"value":"待审核", "name":"待审核"},
					{"value":"审核通过", "name":"审核通过"},
					{"value":"审核不通过", "name":"审核不通过"},
					{"value":"作废", "name":"作废"}
				]
			}),
			queryMode: 'local',
			displayField: 'name',
			valueField: 'value',
			allowBlank: false
		}]
    }],
	buttons: ['->',{
        xtype: 'button',
        text: '提交',
        handler: 'submitSearchForm'
    },{
        xtype: 'button',
        text: '关闭',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});