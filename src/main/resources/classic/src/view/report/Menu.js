Ext.define('Admin.view.email.Menu', {
    extend: 'Ext.menu.Menu',

    alias: 'widget.emailmenu',

    viewModel: {
        type: 'emailmenu'
    },

    title: '工作汇报',

    iconCls: 'x-fa fa-inbox',

    floating: false,

    items: [
        {
            routeId: 'emailcompose', 
            params: {
                openWindow: true, 
                targetCfg: {
                    
                },
                windowCfg: {
                   
                    title: '工作汇报',
                    header:{
                        cls:'x-panel-header-new'
                    }
                }
            },
            iconCls: 'x-fa fa-edit',
            text: '新建'
        },

        {
            routeId: '',
            iconCls: 'fa fa-refresh',
            text: '刷新',
            handler:'onRefuseBtnClick'
        },

        {
            routeId: '',
            iconCls: 'x-fa fa-trash-o',
            text: '删除',
            handler:'onDeleteBtnClick'
        }
    ]
});
