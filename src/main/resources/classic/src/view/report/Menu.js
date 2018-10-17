Ext.define('Admin.view.email.Menu', {
    extend: 'Ext.menu.Menu',

    alias: 'widget.emailmenu',

    viewModel: {
        type: 'emailmenu'
    },

    title: '汇报',

    iconCls: 'x-fa fa-inbox',

    floating: false,

    items: [
        {
            routeId: 'emailcompose', //xtype and used for url routing
            params: {
                openWindow: true, // Let the controller know that we want this component in the window,
                targetCfg: {
                    //put any extra configs for your view here
                },
                windowCfg: {
                    // Any configs that you would like to apply for window popup goes here
                    title: '工作汇报',
                    header:{
                        cls:'x-panel-header-new'
                    }
                }
            },
            iconCls: 'x-fa fa-edit',
            text: '新建'
        },
        // {
        //     routeId: '',
        //     iconCls: 'x-fa fa-inbox',
        //     text: 'Inbox'
        // },
        // {
        //     routeId: '',
        //     iconCls: 'x-fa fa-check-circle',
        //     text: 'Sent Mail'
        // },
        {
            routeId: '',
            iconCls: 'x-fa fa-exclamation-circle',
            text: '修改'
        },
        {
            routeId: '',
            iconCls: 'x-fa fa-trash-o',
            text: '删除'
        }
    ]
});
