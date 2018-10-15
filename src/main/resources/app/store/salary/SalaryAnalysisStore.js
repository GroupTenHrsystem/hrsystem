Ext.define('Admin.store.salary.SalaryAnalysisStroe', {
    extend: 'Ext.data.Store',
    storeId: 'salarySum',
    model: 'Admin.model.salary.SalaryAnalysisModel',
    data: [
        { "month": "一月","salarySum": 11359 },
        { "month": "二月","salarySum": 12357 },
        { "month": "三月", "salarySum": 17755 },
        { "month": "四月","salarySum": 19344 },
        { "month": "五月","salarySum": 11993 },
        { "month": "六月","salarySum": 11551 },
        { "month": "七月","salarySum": 12350 },
        { "month": "八月","salarySum": 21382 },
        { "month": "九月","salarySum": 25750 },
        { "month": "十月","salarySum": 26790 },
        { "month": "十一月","salarySum": 25740 },
        { "month": "十二月","salarySum": 20852 }
    ]
});