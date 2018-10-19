Ext.define('Admin.view.reportAll.ReportAllPanel', {
    extend: 'Ext.grid.Panel',
    xtype: 'reportAllPanel',
    controller: 'reportAllViewController',

    requires: [
        'Ext.grid.filters.Filters',
        'Ext.grid.plugin.Exporter'
    ],

    title: '工作汇报查询',
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
        gridexporter: true,
        gridfilters: true
    },

    bind: '{reportAllLists}',
    features: [{
        ftype : 'groupingsummary',
        groupHeaderTpl : '{name}',
        hideGroupedHeader : false,
        enableGroupingMenu : false
    }],

    listeners: {
        documentsave: 'onDocumentSave',
        beforedocumentsave: 'onBeforeDocumentSave',
        dataready: 'onDataReady'
    },
    selModel: {type: 'checkboxmodel'},
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
                },
                {
                    xtype: 'gridcolumn',
                    cls: 'content-column',
                    dataIndex: 'staffName',
                    text: '员工',
                    flex: 1,
                    filter: true
                },
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close'   ,handler: 'deleteOneRow'},
                        {xtype: 'button',iconCls: 'x-fa fa-ban'     ,handler: 'onDisableButton'},
                        {xtype: 'button', iconCls: 'x-fa fa-file' ,handler: 'openDetailWindow'}
                    ]
                }
            ],



    bbar: {
        xtype: 'pagingtoolbar',
        displayInfo: true,
        displayMsg: '本页显示 {0} - {1} 条, 总数 {2} 条',
        emptyMsg: "No topics to display",
    },

     tbar: {
        overflowHandler: 'menu',
        items: [{
                text:'快速查询',
                iconCls: 'x-fa fa-th',              
                menu: {
                    id: 'mainMenu',
                    showSeparator: true,
                    items: [{
                            text:'重置',     
                            handler:  'clearText'     
                        },'-',{
                            text: '标题',
                            id: 'titleCheck',
                            checked: false,       
                            menu: {
                                items: [{ 
                                        hideOnClick : false,
                                        xtype: 'textfield',
                                        reference:'searchFieldValue0',
                                    }]
                            },
                        },{
                            text: '员工',
                            id: 'staffNameCheck',
                            checked: false,       
                            menu: {
                                items: [{ 
                                        hideOnClick : false,
                                        xtype: 'textfield',
                                        reference:'searchFieldValue1',
                                    }]
                            },
                        }, {
                            text: '日期',
                            id: 'timeCheck',
                            checked: false, 
                            menu: {
                                    id: 'dateMainMenu',
                                    showSeparator: true,
                                    items: [
                                        {text: '范围开始',id: 'timeStartCheck',checked: false,      
                                            menu: {
                                                hideOnClick : false,xtype: 'datemenu',reference:'searchDataFieldValue1',
                                            }
                                        },
                                        {text: '范围结束',id: 'timeEndCheck',checked: false, 
                                            menu: {
                                                hideOnClick : false,xtype: 'datemenu',reference:'searchDataFieldValue2',
                                            }
                                        },'-', 
                                        {text: '具体日期',id: 'timeDetailCheck',checked: false, 
                                            menu: {
                                                hideOnClick : false,xtype: 'datemenu',reference:'searchDataFieldValue3',
                                            }
                                    }]
                            }
                        }]
                 }
        },{
                xtype: 'button',
                iconCls: 'fa fa-search',
                handler: 'quickSearch'
        }]
    },


    header: {
        itemPosition: 1, 
        style:"background-color:#FF8000;",
        items: [
            // {
            //     xtype: 'button',
            //     iconCls: 'fa fa-search-plus',
            //     style:"background-color:black;border-color: white;",
            //     handler: 'openSearchWindow' 
            // }, {
            //     xtype: 'button',
            //     tooltip: 'Add a new row',
            //     iconCls: 'fa fa-plus',
            //     style:"background-color:black;border-color: white;",
            //     handler: 'openAddWindow'    
            // }, {
            //     xtype: 'button',
            //     tooltip: 'Remove the selected item',
            //     iconCls:'fa fa-trash',
            //     style:"background-color:black;border-color: white;",
            //     handler: 'deleteMoreRows'   
            // }
            ]
    }
});