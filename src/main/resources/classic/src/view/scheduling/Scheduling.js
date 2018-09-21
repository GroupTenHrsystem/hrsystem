Ext.define('Admin.view.scheduling.Scheduling', {
    extend: 'Ext.container.Container',
    xtype: 'scheduling',
    //requires: [],
    //controller: 'order',				//viewController:代码与视图分离。声明视图绑定的事件，可以多个视图共享。
    //viewModel: {type: 'orderlist'},	//viewModel：配置Stote数据源。多个视图共享Store。
    
 //   controller: 'userViewController',
  //  viewModel: {type: 'userViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'schedulingPanel'}]
  //  html:'行程安排'
});
