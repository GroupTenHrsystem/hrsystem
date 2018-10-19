Ext.define('Aria.view.archives.ArchivesEditWindowDelete', {
    extend: 'Ext.window.Window',
    alias: 'widget.archivesEditWindowDelete',
    height: 200,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '作废档案',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Delete',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }]
    }],
   buttons: ['->',{
        xtype: 'button',
        text: '确定',
        handler: 'submitEditFormDelete'
    },{
        xtype: 'button',
        text: '取消',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
  
});
