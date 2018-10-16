Ext.define('Admin.view.main.Main', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.button.Segmented',
        'Ext.list.Tree'
    ],

    controller: 'main',
    viewModel: 'main',

    cls: 'sencha-dash-viewport',
    itemId: 'mainView',

    layout: {
        type: 'vbox',
        align: 'stretch'
    },

    listeners: {
        render: 'onMainViewRender'
    },

    items: [
        {
            xtype: 'toolbar',
            cls: 'sencha-dash-dash-headerbar shadow',
            style:'background-color: #272727',
            height: 84,
            itemId: 'headerBar',
            items: [
                {
                    xtype: 'component',
                    reference: 'senchaLogo',
                    cls: 'sencha-logo',
                    style:'background-color: #FF8000;margin-left: 5px!important;',
                    html: '<div class="main-logo" style="background-color: #FF8000;color: black;font-size:16px"><img src="resources/images/icon.png">汇人事管理系统</div>',
                    width: 240
                },
                {
                    margin: '0 0 0 8',
                    ui: 'header',
                    style:'background-color: #272727;',
                    iconCls:'x-fa fa-fast-backward',
                    id: 'main-navigation-btn',
                    handler: 'onToggleNavigationSize'
                },
                '->',{
                    xtype: 'tbtext',
                    text: '用户名:Admin',
                    style:'color: #FF8000;font-size:16px',
                    id:'loginUserName',
                    cls: 'top-user-name'
                },{
                    xtype: 'image',
                    cls: 'header-right-profile-image',
                    id:'loginUserImage',
                    height: 35,
                    width: 35,
                    alt:'current user image',
                    src: 'resources/images/user-profile/2.png'
                },{
                    iconCls:'x-fa fa-sign-out',
                    ui: 'header',
                    tooltip: 'Logout',
                    handler: 'logoutButton'
                }
                // ,
                // {
                //     xtype: 'tbtext',
                //     text: '用户名:Admin',
                //     cls: 'top-user-name'
                // },
                // {
                //     xtype: 'image',
                //     cls: 'header-right-profile-image',
                //     height: 35,
                //     width: 35,
                //     alt:'current user image',
                //     src: 'resources/images/user-profile/2.png'
                // }
            ]
        },
        {
            xtype: 'maincontainerwrap',
            id: 'main-view-detail-wrap',
            reference: 'mainContainerWrap',
            flex: 1,
            items: [
                {
                    xtype: 'treelist',
                    reference: 'navigationTreeList',
                    itemId: 'navigationTreeList',
                    style:'background-color: #272727',
                    ui: 'nav',
                    store: 'NavigationTree',
                    width: 250,
                    expanderFirst: false,
                    expanderOnly: false,
                    listeners: {
                        selectionchange: 'onNavigationTreeSelectionChange'
                    }
                },
                {
                    xtype: 'container',
                    flex: 1,
                    reference: 'mainCardPanel',
                    cls: 'sencha-dash-right-main-container',
                    itemId: 'contentPanel',
                    layout: {
                        type: 'card',
                        anchor: '100%'
                    }
                }
            ]
        }
    ]
});
