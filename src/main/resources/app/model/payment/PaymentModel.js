Ext.define('Admin.model.payment.PaymentModel', {
	extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type:'int',name:'id'}
		,{type:'string',name:'userId'}
		,{type:'float',name:'price'}
		,{type:'string',name:'processStatus'}
		,{type:'string',name:'processInstanceId'}
	],
	proxy: {
		type: 'rest',
		url: '/payment',
	}
});
