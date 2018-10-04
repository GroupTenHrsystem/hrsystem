Ext.define('Admin.view.salary.SalaryPanel', {
    extend: 'Ext.grid.Panel',
    xtype: 'grid-exporter',
    controller: 'salaryViewController',

    requires: [
        // 'KitchenSink.view.grid.ExporterController',
        // 'KitchenSink.store.Products',
        'Ext.grid.plugin.Exporter'
    ],

    title: 'Export grid content',
    collapsible: true,
   layout: 'fit',

    profiles: {
        classic: {
            width: 700,
            priceWidth: 90
        },
        neptune: {
            width: 700,
            priceWidth: 90
        },
        graphite: {
            width: 900,
            priceWidth: 120
        }
    },
    resizable: true,

    loadMask: true,
    plugins: {
        gridexporter: true
    },

    // store: {
    //     type: 'products',
    //     url: 'data/grid/grid-filter.json',
    //     autoLoad: true,
    //     autoDestroy: true,
    //     grouper: {
    //         property: 'size'
    //     }
    // },
    bind: '{salaryLists}',
    features: [{
        ftype : 'groupingsummary',
        groupHeaderTpl : '{name}',
        hideGroupedHeader : false,
        enableGroupingMenu : false
    }, {
        ftype: 'summary',
        dock: 'bottom'
    }],

    listeners: {
        // this event notifies us when the document was saved
        documentsave: 'onDocumentSave',
        beforedocumentsave: 'onBeforeDocumentSave',
        dataready: 'onDataReady'
    },

    columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'salaryTime',text: '发钱日',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'salarySum',text: '钱数',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close'   ,handler: 'deleteOneRow'},
                        {xtype: 'button',iconCls: 'x-fa fa-ban'     ,handler: 'onDisableButton'}
                    ]
                }
            ],

    header: {
        itemPosition: 1, // after title before collapse tool
        items: [{
            ui: 'default-toolbar',
            xtype: 'button',
            text: 'Export to ...',
            menu: {
                defaults: {
                    handler: 'exportTo'
                },
                items: [{
                    text:   'Excel xlsx',
                    cfg: {
                        type: 'excel07',
                        ext: 'xlsx'
                    }
                },{
                    text:   'Excel xlsx (include groups)',
                    cfg: {
                        type: 'excel07',
                        ext: 'xlsx',
                        includeGroups: true,
                        includeSummary: true
                    }
                },{
                    text: 'Excel xml',
                    cfg: {
                        type: 'excel03',
                        ext: 'xml'
                    }
                },{
                    text: 'Excel xml (include groups)',
                    cfg: {
                        includeGroups: true,
                        includeSummary: true
                    }
                },{
                    text:   'CSV',
                    cfg: {
                        type: 'csv'
                    }
                },{
                    text:   'TSV',
                    cfg: {
                        type: 'tsv',
                        ext: 'csv'
                    }
                },{
                    text:   'HTML',
                    cfg: {
                        type: 'html'
                    }
                },{
                    text:   'HTML (include groups)',
                    cfg: {
                        type: 'html',
                        includeGroups: true,
                        includeSummary: true
                    }
                }]
            }
        }]
    }
});