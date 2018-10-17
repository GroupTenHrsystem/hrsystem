Ext.define('Admin.view.email.Inbox', {
    extend: 'Ext.grid.Panel',
    xtype: 'inbox',

    cls: 'email-inbox-panel shadow',

    bind: {
        store: '{inbox}'
    },

    viewConfig: {
        preserveScrollOnRefresh: true,
        preserveScrollOnReload: true
    },

    selModel: {
        selType: 'checkboxmodel',
        checkOnly: true,
        showHeaderCheckbox: true
    },

    listeners: {
        cellclick: 'onGridCellItemClick'
    },

    headerBorders: false,
    rowLines: false,
    scrollable: false,

    columns: [
        
        {
            dataIndex: 'from',
            text: '时间',
            width: 140
        },
        {
            dataIndex: 'title',
            text: '标题',
            flex: 1
        },
        {
            dataIndex: 'has_attachments',
            text: '<span class="x-fa fa-paperclip"></span>',
            width: 40,
            renderer: function(value) {
                return value ? '<span class="x-fa fa-paperclip"></span>' : '';
            }
        }
        // ,{
        //     xtype: 'datecolumn',
        //     dataIndex: 'received_on',
        //     width: 90,
        //     text: 'Received'
        // }
    ],
    dockedItems: [{
        xtype: 'pagingtoolbar',
        dock: 'bottom',
        itemId: 'userPaginationToolbar',
        displayInfo: true,
        bind: '{userLists}'
    }]
});
