Ext.define('Admin.store.order.OrderGridStroe', {
    extend: 'Ext.data.Store',
    alias: 'store.orderGridStroe',
	model:'Admin.model.order.OrderModel',
	data: {
		'lists':[ {
            "id": 1,
            "orderNumber": "26",
            "createTime": "2018/09/07 17:43:34"
        },{
            "id": 2,
            "orderNumber": "27",
            "createTime": "2018/09/07 17:43:34"
        }]
    },
    proxy: {
        type: 'memory',
        //url: '~api/search/users'	//mvc url  xxx.json
	    reader:{
	    	type:'json',
	    	rootProperty:'lists'
	    }
    },

    autoLoad: 'true',

    sorters: {
        direction: 'ASC',
        property: 'fullname'
    }
});
