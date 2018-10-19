Ext.define('Admin.view.training.Training', {
    extend: 'Ext.container.Container',
    xtype: 'training',
    //requires: [],
    //controller: 'order',				//viewController:代码与视图分离。声明视图绑定的事件，可以多个视图共享。
    //viewModel: {type: 'orderlist'},	//viewModel：配置Stote数据源。多个视图共享Store。
    
    controller: 'trainingViewController',
    viewModel: {type: 'trainingViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'trainingPanel'}]
});
