/*没有用的*/
Ext.define('Aria.view.archives.ArchivesAllEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.archivesAllEditWindow',
    height: 700,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Edit ArchivesAll Window',
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
            fieldLabel: 'archivesId',
            name:'archivesId',
        },{
            xtype: 'textfield',
            fieldLabel: 'SsCard',
            name:'ssCard'
        }, {
            xtype: 'textfield',
            fieldLabel: 'BankCard',
            name:'bankCard'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Education',
            name:'education'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Attach',
            name:'attach'
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
