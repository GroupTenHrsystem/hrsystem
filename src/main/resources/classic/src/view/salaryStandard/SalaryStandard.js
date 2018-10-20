Ext.define('Admin.view.salaryStandard.SalaryStandard', {
    extend: 'Ext.container.Container',
    xtype: 'salaryStandard',
    //requires: [],
    //controller: 'order',				//viewController:代码与视图分离。声明视图绑定的事件，可以多个视图共享。
    //viewModel: {type: 'orderlist'},	//viewModel：配置Stote数据源。多个视图共享Store。
  //bodyStyle :'overflow-x:scroll;overflow-y:scroll',
    controller: 'salaryStandardViewController',
    viewModel: {type: 'salaryStandardViewModel'},
    //layout: 'fit',
    layout: {
        type: 'hbox',
        align: 'stretch'
    },
    items: [
    //{xtype:'salaryStandardPanel'}
            {
                xtype: 'container',
                style:'margin: 25px;',
                itemId: 'navigationPanel',

                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },

                width: '30%',
                minWidth: 1140,
                maxWidth: 1140,

                defaults: {
                    margin: '0 20 20 0'
                },

                items: [
                    {
                        xtype: 'salaryStandardPanel'
                    }
                ]
            }
    ]
});
