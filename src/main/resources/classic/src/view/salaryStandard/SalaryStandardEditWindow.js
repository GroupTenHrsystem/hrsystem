Ext.define('Aria.view.salaryStandard.SalaryStandardEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.salaryStandardEditWindow',
    height: 400,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Edit salaryStandard Window',
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
        items: [
         {
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '基本工资',
            name:'basis',
            allowBlank:false, 
            regex: /^\d+(\.\d{1,2})?$/,
            regexText: '请输入正确的整数或小数'
        },  {
            xtype: 'textfield',
            fieldLabel: '补贴',
            name:'subsidy',
            allowBlank:false, 
            regex: /^\d+(\.\d{1,2})?$/,
            regexText: '请输入正确的整数或小数'
        },  {
            xtype: 'textfield',
            fieldLabel: '加班费/天',
            name:'overtime',
            allowBlank:false, 
            regex: /^\d+(\.\d{1,2})?$/,
            regexText: '请输入正确的整数或小数'
        },  {
            xtype: 'textfield',
            fieldLabel: '养老保险比例',
            name:'pensionBenefits',
            allowBlank:false, 
            regex: /^\d+(\.\d{1,2})?$/,
            regexText: '请输入正确的整数或小数'
        },  {
            xtype: 'textfield',
            fieldLabel: '医疗保险比例',
            name:'medicareBenefits',
            allowBlank:false, 
            regex: /^\d+(\.\d{1,2})?$/,
            regexText: '请输入正确的整数或小数'
        },  {
            xtype: 'textfield',
            fieldLabel: '失业保险比例',
            name:'unemploymentBenefits',
            allowBlank:false, 
            regex: /^\d+(\.\d{1,2})?$/,
            regexText: '请输入正确的整数或小数'
        },  {
            xtype: 'textfield',
            fieldLabel: '工伤保险比例',
            name:'injuryBenefits',
            allowBlank:false, 
            regex: /^\d+(\.\d{1,2})?$/,
            regexText: '请输入正确的整数或小数'
        }, {
            xtype: 'textfield',
            fieldLabel: '生育保险比例',
            name:'maternityBenefits',
            allowBlank:false, 
            regex: /^\d+(\.\d{1,2})?$/,
            regexText: '请输入正确的整数或小数'
        }, {
            xtype: 'textfield',
            fieldLabel: '住房公积金比例',
            name:'houseFund',
            allowBlank:false, 
            regex: /^\d+(\.\d{1,2})?$/,
            regexText: '请输入正确的整数或小数'
        }, {
            xtype: 'textfield',
            fieldLabel: '绩效比例',
            name:'kpi',
            allowBlank:false, 
            regex: /^\d+(\.\d{1,2})?$/,
            regexText: '请输入正确的整数或小数'
        }, {
            xtype: 'textfield',
            fieldLabel: '缺勤比例',
            name:'absence',
            allowBlank:false, 
            regex: /^\d+(\.\d{1,2})?$/,
            regexText: '请输入正确的整数或小数'
        }]
    }],
   
    dockedItems: {
        dock: 'bottom',
        items: [{
            xtype: 'button',
            text: 'Submit',
            handler: 'submitEditForm'
        },{
            xtype: 'button',
            text: 'Close',
            handler: function(btn) {
                btn.up('window').close();
            }
        }]
    }
});
