Ext.define('Admin.view.sign.Sign', {
    extend: 'Ext.container.Container',
    xtype: 'sign',
    //requires: [],
    //controller: 'order',				//viewController:代码与视图分离。声明视图绑定的事件，可以多个视图共享。
    //viewModel: {type: 'orderlist'},	//viewModel：配置Stote数据源。多个视图共享Store。
    
    controller: 'signViewController',
    viewModel: {type: 'signViewModel'},
    	
    layout: 'fit',
    items: [
    	{xtype:'signPanel'}
//    	,{xtype:'attendancePanel'}
    	]
    //html:'订单管理模块'
});
