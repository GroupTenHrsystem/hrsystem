Ext.define('Aria.view.archives.ArchivesCheckEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.archivesCheckEditWindow',
    height: 700,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '审核通过记录',
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
            name:'archivesId',
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '社保卡号',
            name:'ssCard',
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '银行卡号',
            name:'bankCard',
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '学历',
            name:'education',
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '专业',
            name:'major',
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '毕业学校',
            name:'graduateSchool',
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '个人履历',
            name:'record',
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '家庭关系信息',
            name:'family',
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'remark',
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '附件',
            name:'attach',
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: 'Arstatus',
            name:'arstatus',
            value:'待审核',
            hidden: true
        }]
    }],
   buttons: ['->',{
        xtype: 'button',
        text: '提交',
        handler: 'submitEditForm'
    },{
        xtype: 'button',
        text: '关闭',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
  
});
