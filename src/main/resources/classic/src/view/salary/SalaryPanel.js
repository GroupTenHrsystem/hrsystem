Ext.define('Admin.view.salary.SalaryPanel', {
    extend: 'Ext.grid.Panel',
    xtype: 'salaryPanel',
    controller: 'salaryViewController',

    requires: [
        'Ext.grid.filters.Filters',
        'Ext.grid.plugin.Exporter'
    ],

    title: '薪资查询',
   // collapsible: true,
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
    }
    // , {
    //     ftype: 'summary',
    //     dock: 'bottom'
    // }
    ],

    listeners: {
        // this event notifies us when the document was saved
        documentsave: 'onDocumentSave',
        beforedocumentsave: 'onBeforeDocumentSave',
        dataready: 'onDataReady'
    },
    selModel: {type: 'checkboxmodel'},
    columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'Key',hidden:true,filter: 'number'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'salaryTime',text: '发钱日',flex: 1,formatter: 'date("Y/m/d H:i:s")',filter: true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'salarySum',text: '钱数',flex: 1,
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
                        {xtype: 'button',iconCls: 'x-fa fa-ban'     ,handler: 'onDisableButton'}
                    ]
                }
            ],

    // plugins: {
    //     preview: {
    //         expanded: true,
    //         bodyField: 'salaryTime',
    //     }
    // },

    // plugins: {
    //     rowexpander: {
    //         rowBodyTpl: new Ext.XTemplate(
    //             '<p><b>Company:</b> {salarySum}</p>',
    //             '<p><b>Change:</b> {salarySum}</p>',
    //             {
    //                 formatChange: function (v) {
    //                     var color = v >= 0 ? 'green' : 'red';
    //                     return '<span style="color: ' + color + ';">' +
    //                         Ext.util.Format.usMoney(v) + '</span>';
    //                 }
    //             })
    //     }
    // },

    // tbar: [
    //         {
    //             xtype: 'combobox',
    //             reference:'searchFieldName',
    //             hideLabel: true,
    //             store:Ext.create("Ext.data.Store", {
    //                 fields: ["name", "value"],
    //                 data: [
    //                     { name: '发钱日', value: 'salaryTime' },
    //                     { name: '钱数', value: 'salarySum' }
    //                 ]
    //             }),
    //             displayField: 'name',
    //             valueField:'value',
    //             value:'请选择',
    //             editable: false,
    //             queryMode: 'local',
    //             triggerAction: 'all',
    //             emptyText: 'Select a state...',
    //             width: 135,
    //             listeners:{
    //                 select: 'searchComboboxSelectChuang'
    //             }
    //         }, '-',{
    //             xtype:'textfield',
    //             reference:'searchFieldValue',
    //             name:'salaryPanelSearchField'
    //         }, '-',{
    //             xtype: 'datefield',
    //             hideLabel: true,
    //             hidden:true,
    //             format: 'Y/m/d H:i:s',
    //             reference:'searchDataFieldValue',
    //             fieldLabel: 'From',
    //             name: 'from_date'
    //         }, {
    //             xtype: 'datefield',
    //             hideLabel: true,
    //             hidden:true,
    //             format: 'Y/m/d H:i:s',
    //             reference:'searchDataFieldValue2',
    //             fieldLabel: 'To',
    //             name: 'to_date'
    //      },'-',{
    //             text: 'Search',
    //             iconCls: 'fa fa-search',
    //             handler: 'quickSearch'
    //         }, '-',{
    //             text: 'Search More',
    //             iconCls: 'fa fa-search-plus',
    //             handler: 'openSearchWindow' 
    //         },'-',{
    //             text: 'Clear Text',
    //             iconCls: 'fa fa-eraser',
    //             handler: 'clearText'          
    //         }, 

    //         '->',{
    //             text: 'Add',
    //             tooltip: 'Add a new row',
    //             iconCls: 'fa fa-plus',
    //             handler: 'openAddWindow'    
    //         },'-',{
    //             text: 'Removes',
    //             tooltip: 'Remove the selected item',
    //             iconCls:'fa fa-trash',
    //             handler: 'deleteMoreRows'   
    //         }],     

    bbar: {
        xtype: 'pagingtoolbar',
        displayInfo: true,
        displayMsg: '本页显示 {0} - {1} 条, 总数 {2} 条',
        emptyMsg: "No topics to display",

        // items: ['-', {
        //     bind: '{salaryLists ? "隐藏理由" : "显示理由"}',
        //     pressed: '{salaryLists}',
        //     enableToggle: true,
        //     toggleHandler: 'onToggleExpanded'
        // }]
    },

    header: {
        itemPosition: 1, // after title before collapse tool
        items: [{
                xtype: 'combobox',
                reference:'searchFieldName',
                hideLabel: true,
                store:Ext.create("Ext.data.Store", {
                    fields: ["name", "value"],
                    data: [
                        { name: '发钱日', value: 'salaryTime' },
                        { name: '钱数', value: 'salarySum' }
                    ]
                }),
                displayField: 'name',
                valueField:'value',
                value:'请选择',
                editable: false,
                queryMode: 'local',
                triggerAction: 'all',
                emptyText: 'Select a state...',
                width: 135,
                listeners:{
                    select: 'searchComboboxSelectChuang'
                }
            }, {
                xtype:'textfield',
                reference:'searchFieldValue',
                name:'salaryPanelSearchField'
            }, {
                xtype: 'datefield',
                hideLabel: true,
                hidden:true,
                format: 'Y/m/d H:i:s',
                reference:'searchDataFieldValue',
                fieldLabel: 'From',
                name: 'from_date'
            }, {
                xtype: 'datefield',
                hideLabel: true,
                hidden:true,
                format: 'Y/m/d H:i:s',
                reference:'searchDataFieldValue2',
                fieldLabel: 'To',
                name: 'to_date'
            },{
             //   text: 'Search',
                xtype: 'button',
                iconCls: 'fa fa-search',
                handler: 'quickSearch'
            },{
             //   text: 'Search More',
                xtype: 'button',
                iconCls: 'fa fa-search-plus',
                handler: 'openSearchWindow' 
            },{
             //   text: 'Clear Text',
                xtype: 'button',
                iconCls: 'fa fa-eraser',
                handler: 'clearText'          
            }, {
              //  text: 'Add',
                xtype: 'button',
                tooltip: 'Add a new row',
                iconCls: 'fa fa-plus',
                handler: 'openAddWindow'    
            },{
             //   text: 'Removes',
                xtype: 'button',
                tooltip: 'Remove the selected item',
                iconCls:'fa fa-trash',
                handler: 'deleteMoreRows'   
            },{
            ui: 'default-toolbar',
            xtype: 'button',
            text: '导出到...',
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