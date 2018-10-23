Ext.define('Admin.model.user.UserModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'int',name: 'employeNum'},
	    {type: 'string', name: 'staffName'},
	    {type: 'string',name: 'sex'},
	    {type: 'string',name: 'idcard'},
	    {type: 'string',name: 'email'},
	    {type: 'string',name: 'phone'},
	    {type: 'string',name: 'nativePlace'},
	    {type: 'string',name: 'address'},
	    {type: 'string',name: 'password'},
	    {type: 'date',name: 'birthday', dateFormat:'Y/m/d'},
	    {type: 'string',name: 'status'},
	    {type: 'date',name: 'employmentDate', dateFormat:'Y/m/d'},
	    {type: 'date',name: 'leaveDate', dateFormat:'Y/m/d'},
	    {type: 'int',name: 'roleId'},
	    {type: 'string',name: 'roleName'}
	],
	proxy: {
		type: 'rest',
		url: '/Staff',
	}
});
