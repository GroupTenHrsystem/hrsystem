Ext.define('Admin.view.person.Person', {
    extend: 'Ext.container.Container',
    xtype: 'person',
    //requires: [],
    //controller: 'order',				//viewController:代码与视图分离。声明视图绑定的事件，可以多个视图共享。
    //viewModel: {type: 'orderlist'},	//viewModel：配置Stote数据源。多个视图共享Store。
    
    controller: 'personViewController',
    viewModel: {type: 'personViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'personPanel'}]
    //html:'订单管理模块'
});
