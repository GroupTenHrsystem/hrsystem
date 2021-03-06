Ext.define('Admin.view.email.Details', {
    extend: 'Ext.form.Panel',
    xtype: 'emaildetails',

    requires: [
        'Admin.view.email.DetailsViewModel',
        'Ext.container.Container',
        'Ext.form.field.HtmlEditor',
        'Ext.layout.container.Anchor',
        'Ext.layout.container.HBox'
    ],

    viewModel: {
        type: 'emaildetails'
    },

    cls: 'shadow',

    bodyPadding: 10,

    layout : {
        type : 'anchor',
        anchor : '100%'
    },

    listeners: {
        beforerender: 'beforeDetailsRender'
    },

    tbar: [
        // Default item type for toolbar is button, thus we can skip it's definition in
        // the array items
        {
            iconCls: 'x-fa fa-angle-left',
            listeners: {
                click: 'onBackBtnClick'
            }
        },
        {
            iconCls: 'x-fa fa-trash'
        }
    ],

    bbar: {
        cls: 'single-mail-action-button',
        defaults: {
            margin:'0 15 0 0'
        },
        items: [
            '->',
            {
                ui: 'soft-green',
                text: 'Save',
                listeners: {
                    click: 'onSaveBtnClick'
                }
            }
        ]
    },

    items: [
        {
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            itemId: 'id',
            allowBlank:false,
            hidden:true
        },{
            xtype: 'textfield',
            fieldLabel: '标题',
            name:'title',
            itemId: 'title',
            allowBlank:false, 
        },{
            xtype: 'datefield',
            fieldLabel: '日期',
            editable:false,
            name:'time',
            itemId: 'time',
            allowBlank:false, 
            regexText: '请选择日期',
            width:400,
            format: 'Y/m/d'
        },
        {
            xtype: 'htmleditor',
            name:'messages',
            itemId: 'messages',
            // Make tips align neatly below buttons.
            buttonDefaults: {
                tooltip: {
                    align: 't-b',
                    anchor: true
                }
            },
            flex: 1,
            minHeight: 100,
            labelAlign: 'top',
            fieldLabel: '内容',
            allowBlank:false
        }
    ],
});
