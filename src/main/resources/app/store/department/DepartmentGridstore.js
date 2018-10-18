Ext.define('Admin.store.department.DepartmentGridStore', {
    extend: 'Ext.data.TreeStore',
    storeId:'departmentGridStore',
    alias: 'store.departmentGridStore',
    //model:'Admin.model.department.DepartmentModel',

    fields: ['id','departmentName',"introduce"],
    root: {
//        departmentName: '请选择部门',
        id:'1',
        expanded: true
    },
    rootVisible: true,
    proxy: {
        type: 'ajax',
        url: '/department/findNoParent',
        reader: {
            type: 'json'
        }
    }
//hasmany:
});