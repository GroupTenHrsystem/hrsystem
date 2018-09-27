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
            	text: '订单管理模板',
                iconCls: 'x-fa fa-address-card',
                rowCls: 'nav-tree-badge nav-tree-badge-new',
                viewType: 'order',
                leaf: true
            },{
                text: '系统管理模块',
                iconCls: 'x-fa fa-address-card',
                expanded: false,
                selectable: false,
                children: [
                    {
                        text: '用户管理',
		                iconCls: 'x-fa fa-address-card',
		                rowCls: 'nav-tree-badge nav-tree-badge-new',
		                viewType: 'user',
		                leaf: true
                    },
                    {
                        text: '组织架构管理',
                        iconCls: 'x-fa fa-exclamation-triangle',
                        viewType: 'page404',
                        leaf: true
                    },
                    {
                        text: '职位管理',
                        iconCls: 'x-fa fa-lightbulb-o',
                        viewType: 'passwordreset',
                        leaf: true
                    }
                ]
	        },{
            	text: '人事管理模块',
                iconCls: 'x-fa fa-address-card',
                expanded: false,
                selectable: false,
            	children: [
	                {
	                    text: '人事档案登记',
		                iconCls: 'x-fa fa-address-card',
		                rowCls: 'nav-tree-badge nav-tree-badge-new',
		                //viewType: ',
		                leaf: true
	                },
	                {
	                    text: '人事档案复核',
	                    iconCls: 'x-fa fa-exclamation-triangle',
	                    //viewType: 'page404',
	                    leaf: true
	                },
	                {
	                    text: '人事档案查询',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    //viewType: 'passwordreset',
	                    leaf: true
	                },
	                {
	                    text: '人事变动',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    //viewType: 'passwordreset',
	                    leaf: true
	                },
	                {
	                    text: '人事档案删除',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    //viewType: 'passwordreset',
	                    leaf: true
	                }
	            ]
	        },{
            	text: '招聘管理模块',
                iconCls: 'x-fa fa-address-card',
                expanded: false,
                selectable: false,
            	children: [
	                {
	                    text: '职位发布',
		                iconCls: 'x-fa fa-address-card',
                		viewType: 'recruit',
		                leaf: true
	                },
	                {
	                    text: '简历管理',
	                    iconCls: 'x-fa fa-exclamation-triangle',
	                    //viewType: 'page404',
	                    leaf: true
	                },
	                {
	                    text: '面试管理',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    //viewType: 'passwordreset',
	                    leaf: true
	                },
	                {
	                    text: '录用管理',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    //viewType: 'passwordreset',
	                    leaf: true
	                }
	            ]
            },{
            	text: '培训管理模块',
                iconCls: 'x-fa fa-address-card',
                expanded: false,
                selectable: false,
            	children: [
	                {
	                    text: '培训计划录入',
		                iconCls: 'x-fa fa-address-card',
                		//viewType: '',
		                leaf: true
	                },
	                {
	                    text: '培训人员报名',
	                    iconCls: 'x-fa fa-exclamation-triangle',
	                    //viewType: '',
	                    leaf: true
	                },
	                {
	                    text: '培训复核',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    //viewType: '',
	                    leaf: true
	                },
	                {
	                    text: '培训反馈表',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    //viewType: '',
	                    leaf: true
	                }
	            ]
            },{
            	text: '薪资管理模块',
                iconCls: 'x-fa fa-address-card',
                expanded: false,
                selectable: false,
            	children: [
	                {
	                    text: '薪资标准管理',
		                iconCls: 'x-fa fa-address-card',
                		//viewType: '',
		                leaf: true
	                },
	                {
	                    text: '薪资计算',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    //viewType: '',
	                    leaf: true
	                },
	                {
	                    text: '绩效模板',
		                iconCls: 'x-fa fa-address-card',
		                rowCls: 'nav-tree-badge nav-tree-badge-new',
		                viewType: 'performanceTemplet',
		                leaf: true
	                },
	                {
	                    text: '绩效考核',
		                iconCls: 'x-fa fa-address-card',
		                rowCls: 'nav-tree-badge nav-tree-badge-new',
		                viewType: 'performance',
		                leaf: true
	                },
	                {
	                    text: '流程定义模块',
		                iconCls: 'x-fa fa-address-card',
		                viewType: 'processDefinitionCenterPanel',
		                leaf: true
	                }		
	            ]
            },{
            	text: '考勤管理模块',
                iconCls: 'x-fa fa-address-card',
                expanded: false,
                selectable: false,
            	children: [
	                {
	                    text: '签到签退',
		                iconCls: 'x-fa fa-address-card',
                		//viewType: '',
		                leaf: true
	                },
	                {
	                    text: '请假管理',
		                iconCls: 'x-fa fa-address-card',
		                viewType: 'leaveCenterPanel',
		                leaf: true
	                },
	                {
	                    text: '请假审批',
		                iconCls: 'x-fa fa-address-card',
		                viewType: 'leaveApproveCenterPanel',
		                leaf: true
	                },
	                {
	                    text: '请假统计',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    //viewType: '',
	                    leaf: true
	                },
	                {
	                    text: '考勤情况查看',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    //viewType: '',
	                    leaf: true
	                }
	            ]
           	},{
               text: '日程安排模块',
                iconCls: 'x-fa fa-address-card',
                rowCls: 'nav-tree-badge nav-tree-badge-new',
                viewType: 'scheduling',
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
