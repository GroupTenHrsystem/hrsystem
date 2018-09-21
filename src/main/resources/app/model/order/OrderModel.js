Ext.define('Admin.model.order.OrderModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'string',name: 'orderNumber'},
	    {type: 'date', name: 'createTime', dateFormat:'Y/m/d H:i:s'}
	],
	proxy: {
		type: 'rest',
		url: '/order',
	}
});
