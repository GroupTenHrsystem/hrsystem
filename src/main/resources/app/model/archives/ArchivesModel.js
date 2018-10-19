Ext.define('Admin.model.archives.ArchivesModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
    	{type: 'int',name: 'id'},
	    {type: 'string',name: 'archivesId'},
	    {type: 'string',name: 'ssCard'},
		{type: 'string',name: 'bankCard'},
		{type: 'string',name: 'education'},
		{type: 'string',name: 'major'},
		{type: 'string',name: 'graduateSchool'},
		{type: 'string',name: 'record'},
		{type: 'string',name: 'family'},
		{type: 'string',name: 'remark'},
		{type: 'string',name: 'attach'},
		{type: 'string',name: 'arstatus'},
	],
	proxy: {
		type: 'rest',
		url: '/archives',
	}
});
