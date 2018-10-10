Ext.define('Admin.store.performance.PerformanceGridStroe', {
    extend: 'Ext.data.Store',
    storeId:'performanceGridStroe',
    alias: 'store.performanceGridStore',
    model:'Admin.model.performance.PerformanceModel',
    groupField: 'performanceName',
    sorters: ['performanceName','id'],
    proxy: {
        type: 'rest',
        url: '/performance',
        reader:{
            type:'json',
            rootProperty:'content',//对应后台返回的结果集名称
            totalProperty: 'totalElements',//分页需要知道总记录数
            //record:'staff'
           // groupRootProperty :'staff'
        },
        writer: {
            type: 'json'
        },
        simpleSortMode: true    //简单排序模式
    },
    // listeners:{load:function(){
    //          var staffName=this.first().get('staff').staffName;
    //          //this.model.setFields()
    //          console.log(staffName);
    //        //  alert(rawData.fields)
    //       }},
    autoLoad: true,
    autoSync: true,
    remoteSort: true,//全局排序
    pageSize: 20,
    sorters: {
        direction: 'DESC',property: 'id'
    }
});