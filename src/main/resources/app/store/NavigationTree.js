Ext.define('Admin.store.NavigationTree', {
    extend: 'Ext.data.TreeStore',

    storeId: 'NavigationTree',

    fields: [{
        name: 'text'
    }],

    root: {
        expanded: true,
        children: [
            {
                text: '订单管理模块',
                iconCls: 'x-fa fa-address-card',
                //rowCls: 'nav-tree-badge nav-tree-badge-new',
                viewType: 'order',
                leaf: true
            },{
               text: '用户管理模块',
                iconCls: 'x-fa fa-address-card',
                rowCls: 'nav-tree-badge nav-tree-badge-new',
                viewType: 'user',
                leaf: true
            },{
               text: '日程安排',
                iconCls: 'x-fa fa-address-card',
                rowCls: 'nav-tree-badge nav-tree-badge-new',
                viewType: 'scheduling',
                leaf: true
            },{
                text: '流程定义模块',
                iconCls: 'x-fa fa-address-card',
                viewType: 'processDefinitionCenterPanel',
                leaf: true
            },{
                text: '请假管理模块',
                iconCls: 'x-fa fa-address-card',
                viewType: 'leaveCenterPanel',
                leaf: true
            },{
                text: 'Login',
                iconCls: 'x-fa fa-check',
                viewType: 'login',
                leaf: true
           }
        ]
    }
});
