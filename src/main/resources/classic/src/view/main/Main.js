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
           // style:'background-color: #272727;top: 93%;',
            style:'background:url(http://localhost:8084/resources/images/%E7%AD%89%E6%AD%BB.gif); background-repeat:repeat-x;',
            height: 74,
            itemId: 'headerBar',
            items: [    
                {
                    xtype: 'tbtext',
                    text: '   ',
                },{
                    xtype: 'tbtext',
                    text: '   ',
                },{
                    xtype: 'tbtext',
                    text: '用户名:Admin',
                    style:'color: #FF8000;font-size:16px',
                    id:'loginUserName',
                    cls: 'top-user-name'
                },
                {
                    xtype: 'image',
                    cls: 'header-right-profile-image',
                    id:'loginUserImage',
                    height: 35,
                    width: 35,
                    alt:'current user image',
                    src: 'resources/images/user-profile/21.png'
                },
                {
                    iconCls:'x-fa fa-sign-out',
                    ui: 'header',
                    tooltip: 'Logout',
                    handler: 'logoutButton'
                },
                {
                    margin: '0 0 0 8',
                    ui: 'header',
                    style:'background-color: #272727;',
                    iconCls:'x-fa fa-fast-backward',
                    id: 'main-navigation-btn',
                    handler: 'onToggleNavigationSize'
                },{
                    xtype: 'tbtext',
                    text: '  ',
                },{
                    xtype: 'component',
                    html:'<div style="pointer-events: none;background-color: #ADADAD;"><iframe name="weather_inc" src="http://i.tianqi.com/index.php?c=code&id=1" width="310" height="25" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe></div>',
                },'->', {
                    xtype: 'component',
                    reference: 'senchaLogo',
                  //  cls: 'sencha-logo',
                    style:'margin-left: 5px!important;',
                    html: '<div  style="font-size:16px"><img src="resources/images/icon_2.png" style="margin-top: -10px;"></div>',
                    width: 240
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
                    id:'navigationTreeList',
                    itemId: 'navigationTreeList',
                    style:'background-color: #272727',
                    ui: 'nav',
                    store:Ext.create("Ext.data.TreeStore",{
                        fields: [{
                            name: 'text'
                        }],

                        root: {
                            expanded: true,
                        },

                        proxy: {
                            type: 'ajax',
                            url: '/navigationTree/findNoParent',
                            reader: {
                                type: 'json'
                            } 
                        },
                        autoLoad:false

                }),

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
