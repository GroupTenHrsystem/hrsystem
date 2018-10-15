Ext.define('Admin.view.salary.SalaryPanel', {
    extend: 'Ext.grid.Panel',
    xtype: 'salaryPanel',
    controller: 'salaryViewController',

    requires: [
        'Ext.grid.filters.Filters',
        'Ext.grid.plugin.Exporter'
    ],

    title: '薪资查询',
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

    bind: '{salaryLists}',
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
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true,filter: 'number'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'staffName',text: '员工名字',flex: 1,filter: true},                
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'createTime',text: '创建日期',flex: 1,formatter: 'date("Y/m/d")',filter: true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'salaryStarTime',text: '开始日期',flex: 1,formatter: 'date("Y/m/d")',filter: true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'salaryEndTime',text: '结束日期',flex: 1,formatter: 'date("Y/m/d")',filter: true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'salaryStandardName',text: '薪资标准',flex: 1,filter: true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'salarySum',text: '工资',flex: 1, formatter: 'round(2)',
                     filter: {
                        type: 'string',
                        itemDefaults: {
                            emptyText: 'Search for...'
                        }
                    }
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
                            text: '工资',
                            id: 'salarySumCheck',
                            checked: false,       
                            menu: {
                                items: [{ 
                                        hideOnClick : false,
                                        xtype: 'textfield',
                                        reference:'searchFieldValue',
                                    }]
                            },
                        },{
                            text: '用户名',
                            id: 'staffNameCheck',
                            checked: false,       
                            menu: {
                                items: [{ 
                                        hideOnClick : false,
                                        xtype: 'textfield',
                                        reference:'staffNameValue',
                                    }]
                            },
                        },{
                            text: '薪资标准',
                            id: 'salaryStandardCheck',
                            checked: false,       
                            menu: {
                                items: [{ 
                                        hideOnClick : false,
                                        xtype: 'textfield',
                                        reference:'salaryStandardValue',
                                    }]
                            },
                        }, {
                            text: '开始日期',
                            id: 'salaryStarTimeCheck',
                            checked: false, 
                            menu: {
                                    id: 'dateMainMenu',
                                    showSeparator: true,
                                    items: [
                                        {text: '范围开始',id: 'salaryStarTimeStartCheck',checked: false,      
                                            menu: {
                                                hideOnClick : false,xtype: 'datemenu',reference:'searchDataFieldValue',
                                            }
                                        },
                                        {text: '范围结束',id: 'salaryStarTimeEndCheck',checked: false, 
                                            menu: {
                                                hideOnClick : false,xtype: 'datemenu',reference:'searchDataFieldValue2',
                                            }
                                        },'-', 
                                        {text: '具体日期',id: 'salaryStarTimeDetailCheck',checked: false, 
                                            menu: {
                                                hideOnClick : false,xtype: 'datemenu',reference:'searchDataFieldValue3',
                                            }
                                    }]
                            }
                        }, {
                            text: '结束日期',
                            id: 'salaryEndTimeCheck',
                            checked: false, 
                            menu: {
                                    id: 'dateMainMenu2',
                                    showSeparator: true,
                                    items: [
                                        {text: '范围开始',id: 'salaryEndTimeStartCheck',checked: false,      
                                            menu: {
                                                hideOnClick : false,xtype: 'datemenu',reference:'searchDataFieldValue4',
                                            }
                                        },
                                        {text: '范围结束', id: 'salaryEndTimeEndCheck',checked: false, 
                                            menu: {
                                                hideOnClick : false,xtype: 'datemenu',reference:'searchDataFieldValue5',
                                            }
                                        },'-', 
                                        {text: '具体日期',id: 'salaryEndTimeDetailCheck',checked: false, 
                                            menu: {
                                                hideOnClick : false,xtype: 'datemenu',reference:'searchDataFieldValue6',
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
        items: [
            {
                xtype: 'button',
                iconCls: 'fa fa-search-plus',
                handler: 'openSearchWindow' 
            }, {
                xtype: 'button',
                tooltip: 'Add a new row',
                iconCls: 'fa fa-plus',
                handler: 'openAddWindow'    
            }, {
                xtype: 'button',
                tooltip: 'Remove the selected item',
                iconCls:'fa fa-trash',
                handler: 'deleteMoreRows'   
            }, {
                ui: 'default-toolbar',
                xtype: 'button',
                text: '导出本页',
                menu: {
                    defaults: {
                        handler: 'exportTo'
                    },
                    items: [{
                        text:   'xlsx文件',
                        cfg: {
                            type: 'excel07',
                            ext: 'xlsx'
                        }
                    },{
                        text:   'xlsx(include groups)文件',
                        cfg: {
                            type: 'excel07',
                            ext: 'xlsx',
                            includeGroups: true,
                            includeSummary: true
                        }
                    },{
                        text: 'xml文件',
                        cfg: {
                            type: 'excel03',
                            ext: 'xml'
                        }
                    },{
                        text: 'xml(include groups)文件',
                        cfg: {
                            includeGroups: true,
                            includeSummary: true
                        }
                    },{
                        text:   'CSV文件',
                        cfg: {
                            type: 'csv'
                        }
                    },{
                        text:   'TSV文件',
                        cfg: {
                            type: 'tsv',
                            ext: 'csv'
                        }
                    },{
                        text:   'HTML文件',
                        cfg: {
                            type: 'html'
                        }
                    },{
                        text:   'HTML(include groups)文件',
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