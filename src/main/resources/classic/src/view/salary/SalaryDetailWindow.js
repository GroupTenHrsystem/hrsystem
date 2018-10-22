Ext.define('Aria.view.salary.SalaryDetailWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.salaryDetailWindow',
    y:50,
    resizable : false,
    minWidth: 520,
    maxWidth: 520,
    width: 520,
    scrollable: true,
    title: '薪资详情',
    width: 600,
    bodyPadding: 10,
    defaults: {
        anchor: '100%',
        labelWidth: 100
    },
    items: [{
        xtype: 'form',
        //ariaLabel: 'Enter your name',
        // height: 600,
        // minHeight: 600,
        // maxHeight: 600,
       
    items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, 
        {
            xtype: 'displayfield',
            fieldLabel: '基本工资',
            name:'basis'
        }, {
            xtype: 'displayfield',
            fieldLabel: '补贴',
            //name:'salarySum',
            //value: '300'
        }, {
            xtype: 'displayfield',
            fieldLabel: '加班',
            //name:'salarySum',
            //value: '300'
        }, {
            xtype: 'displayfield',
            fieldLabel: '绩效',
            name:'performancesSalary',
            //value: '1000'
        }, {
            xtype: 'displayfield',
            fieldLabel: '缺勤',
            //name:'salarySum',
            //value: '-50'
        }, {
            xtype: 'displayfield',
            fieldLabel: '合计',
            name:'salarySum',
            //value: '3540'
        }, {
            xtype: 'fieldset',
            title: '补充',
            collapsible: true,
            collapsed: true,
            width:480,
            items: [{
                xtype: 'fieldcontainer',
                fieldLabel: '五险一金',
                labelWidth:100, 
                combineErrors: true,
                layout: 'hbox',
                items: [{
                            xtype: 'displayfield',
                            fieldLabel: '养老保险',
                            labelWidth:80, 
                            labelAlign:'right',  
                            name:'pension',
                            //value: '-10'
                        }, {
                            xtype: 'displayfield',
                            fieldLabel: '医疗保险',
                            name:'medicare',
                            //value: '-10',
                            labelWidth:80,
                            labelAlign:'right'
                        }]
            },{
                    xtype: 'fieldcontainer',
                    combineErrors: true,
                    layout: 'hbox',
                    items: [{
                            xtype: 'displayfield',
                            fieldLabel: '工伤保险',
                            labelWidth:185, 
                            labelAlign:'right', 
                            name:'injury',
                            //value: '-10'
                        }, {
                            xtype: 'displayfield',
                            fieldLabel: '失业保险',
                            labelWidth:80, 
                            labelAlign:'right', 
                            name:'unemployment',
                            //value: '-10'
                        }]
            },{
                    xtype: 'fieldcontainer',
                    combineErrors: true,
                    layout: 'hbox',
                    items: [{
                            xtype: 'displayfield',
                            fieldLabel: '生育保险',
                            labelWidth:185, 
                            labelAlign:'right', 
                            name:'maternity',
                            //value: '-10'
                        }, {
                            xtype: 'displayfield',
                            fieldLabel: '住房公积金',
                            labelWidth:80, 
                            labelAlign:'right', 
                            name:'house',
                            //value: '-10'
                        }]
            }]
        }]
    }]
});
