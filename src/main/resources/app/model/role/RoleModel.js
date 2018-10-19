Ext.define('Admin.model.role.RoleModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'string',name: 'position'},
	    {type: 'int', name: 'limite'},
	    {type: 'int',name: 'departmentId'},
	    {type: 'string',name: 'departmentName'}
	],
	proxy: {
		type: 'rest',
		url: '/Role',
	}
});
