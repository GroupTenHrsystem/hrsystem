Ext.define('Admin.model.person.PersonModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'int',name: 'employeNum'},
	    {type: 'string', name: 'staffName'}
	],
	proxy: {
		type: 'rest',
		url: '/Staff',
	}
});
