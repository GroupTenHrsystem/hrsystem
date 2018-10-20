Ext.define('Admin.model.attendance.AttendanceModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'string', name: 'employeName'},
	    {type: 'int',name: 'employeNum'},
	    {type: 'int',name: 'delateCount'},
	    {type: 'int',name: 'leaveEarlyCount'},
	    {type: 'int',name: 'leaveCount'},
	    {type: 'int',name: 'absenTime'},
	    {type: 'int',name: 'totalTime'},
	    {type: 'int',name: 'extraTime'}
	],
	proxy: {
		type: 'rest',
		url: '/Attendance',
	}
});
