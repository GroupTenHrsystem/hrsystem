Ext.define('Admin.view.report.Compose', {
    extend: 'Ext.form.Panel',
    alias: 'widget.emailcompose',
    requires: [
        'Ext.button.Button',
        'Ext.form.field.Text',
        'Ext.form.field.File',
        'Ext.form.field.HtmlEditor'
    ],

    viewModel: {
        type: 'emailcompose'
    },

    controller: 'emailcompose',

    cls: 'email-compose',

    layout: {
        type:'vbox',
        align:'stretch'
    },

    bodyPadding: 10,
    scrollable: true,

    defaults: {
        labelWidth: 60,
        labelSeparator: ''
    },

    items: [
        {
            xtype: 'textfield',
            fieldLabel: '标题',
            name:'title',
            allowBlank:false, 
        },{
            xtype: 'datefield',
            fieldLabel: '日期',
            editable:false,
            name:'time',
            allowBlank:false, 
            regexText: '请选择日期',
            width:400,
            format: 'Y/m/d'
        },
        {
            xtype: 'htmleditor',
            name:'messages',
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

    bbar: {
        overflowHandler: 'menu',
        items: [
            // {
            //     xtype: 'filefield',
            //     width: 400,
            //     labelWidth: 80,
            //     fieldLabel: '附件:',
            //     labelSeparator: '',
            //     buttonConfig: {
            //         xtype: 'filebutton',
            //         glyph:'',
            //         iconCls: 'x-fa fa-cloud-upload',
            //         style:'background-color:black',
            //         text: '上传附件'
            //     }
            // },
            '->',
            {
                xtype: 'button',
                ui: 'soft-red',
                text: '取消',
                handler: 'onComposeDiscardClick'
            },
            {
                xtype: 'button',
                ui: 'soft-green',
                text: '保存',
                handler:'onSaveComposeClick'
            }
        ]
    }
});
