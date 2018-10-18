Ext.define('Admin.view.email.Inbox', {
    extend: 'Ext.grid.Panel',
    xtype: 'inbox',

    cls: 'email-inbox-panel shadow',

    bind: '{reportLists}',

    autoLoad: true,

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
            xtype: 'gridcolumn',
            dataIndex: 'id',
            text: 'id',
            hidden:true
        },
        {
            xtype: 'gridcolumn',
            dataIndex: 'title',
            text: '标题',
            flex: 1
        },
        {
            xtype: 'gridcolumn',
            cls: 'content-column',
            dataIndex: 'time',
            text: '时间',
            flex: 1,
            formatter: 'date("Y/m/d")',
            filter: true
        }
        // ,
        // {
        //     dataIndex: 'has_attachments',
        //     text: '<span class="x-fa fa-paperclip"></span>',
        //     width: 40,
        //     renderer: function(value) {
        //         return value ? '<span class="x-fa fa-paperclip"></span>' : '';
        //     }
        // }
    ],
    dockedItems: [{
        xtype: 'pagingtoolbar',
        dock: 'bottom',
        itemId: 'userPaginationToolbar',
        displayInfo: true,
        bind: '{reportLists}'
    }]
});
