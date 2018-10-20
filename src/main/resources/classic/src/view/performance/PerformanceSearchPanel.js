Ext.define('Admin.view.performance.PerformanceSearchPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'performanceSearchPanel',
    title: '搜索',
    iconCls: 'fa-arrow-circle-o-up',
    collapsible: true,
    items: [{xtype: 'performanceSearchForm'}],

     dockedItems: {
        dock: 'bottom',
        items: [{
            xtype: 'button',
            text: '提交',
            handler: 'submitSearchForm'
        }]
    }

})    