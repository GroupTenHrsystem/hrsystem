Ext.define('Admin.store.salary.SalaryAnalysisStroe', {
    extend: 'Ext.data.Store',
    storeId: 'salarySum',
    model: 'Admin.model.salary.SalaryAnalysisModel',
    // data: [
    //     { "salaryStarTime": "一月","salarySum": 11359 },
    //     { "salaryStarTime": "二月","salarySum": 12357 },
    //     { "salaryStarTime": "三月", "salarySum": 17755 },
    //     { "salaryStarTime": "四月","salarySum": 19344 },
    //     { "salaryStarTime": "五月","salarySum": 11993 },
    //     { "salaryStarTime": "六月","salarySum": 11551 },
    //     { "salaryStarTime": "七月","salarySum": 12350 },
    //     { "salaryStarTime": "八月","salarySum": 21382 },
    //     { "salaryStarTime": "九月","salarySum": 25750 },
    //     { "salaryStarTime": "十月","salarySum": 26790 },
    //     { "salaryStarTime": "十一月","salarySum": 25740 },
    //     { "salaryStarTime": "十二月","salarySum": 20852 }
    // ],


    proxy: {
        type: 'ajax',
        url: '/salary/getMyPage',
        reader:{
            type:'json',
            rootProperty:'content',//对应后台返回的结果集名称
           // totalProperty: 'totalElements'//分页需要知道总记录数
        },
        writer: {
            type: 'json'
        },
        simpleSortMode: true    //简单排序模式
    },
    autoLoad: true,
    autoSync: true,
    remoteSort: true,//全局排序
});