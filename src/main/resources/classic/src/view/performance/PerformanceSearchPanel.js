Ext.define('Admin.view.performance.PerformanceSearchPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'performanceSearchPanel',
    title: '搜索',
    iconCls: 'fa fa-search',
    collapsible: true,
    items: [{xtype: 'performanceSearchForm'}],

     dockedItems: {
        xtype: 'toolbar',
        dock: 'bottom',
        items: ['->', {
            xtype: 'button',
            text: '提交',
            handler: 'submitSearchForm'
        },{
            xtype: 'button',
            buttonAlign : 'center',
            text: '清空',
            handler: 'clearText'
        },'->']
    }

})    