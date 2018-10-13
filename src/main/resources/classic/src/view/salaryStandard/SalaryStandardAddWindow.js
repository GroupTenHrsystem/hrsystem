Ext.define('Aria.view.salaryStandard.SalaryStandardAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.salaryStandardAddWindow',
    x: 50,  
    y: 100,  
    height: 570,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '添加绩效考核信息',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        items: [
        // { 
        //      xtype:"textfield", 
        //      fieldLabel:"你的姓名" , 
        //      allowBlank:false, 
        //      blankText :'姓名不能为空', 
        //      minLength :2 , 
        //      minLengthText : "姓名最少2个字符", 
        //      maxLength : 4 , 
        //      maxLengthText :"姓名至多4个字符", 
        //      width : 80, 
        //      regex : /^[abc]{2,4}$/, 
        //      regexText : "只能输入abc" 
        //  },
         {
            xtype: 'datefield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'createTime',
            format: 'Y/m/d H:i:s',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '名字',
            name:'name',
            allowBlank:false, 
        },{
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
            handler: 'submitAddForm'
        },{
            xtype: 'button',
            text: 'Close',
            handler: function(btn) {
                btn.up('window').close();
            }
        }]
    }
});
