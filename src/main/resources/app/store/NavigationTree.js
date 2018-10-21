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
                text: '流程定义模块',
                iconCls: 'fa fa-files-o',
                viewType: 'processDefinitionCenterPanel',
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
                        text: '个人信息管理',
		                iconCls: 'x-fa fa-address-card',
		                rowCls: 'nav-tree-badge nav-tree-badge-new',
		                viewType: 'person',
		                leaf: true
		                
		                
                    },
                    {
                        text: '组织架构管理',
                        iconCls: 'x-fa fa-exclamation-triangle',
                        viewType: 'department',
                        leaf: true
                    },
                    {
                        text: '职位管理',
                        iconCls: 'x-fa fa-lightbulb-o',
                        viewType: 'role',
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
	                    text: '档案登记与变更',
		                iconCls: 'x-fa fa-address-card',
		                viewType:'archives',
		                leaf: true
	                },
	                {
	                    text: '人事档案复核',
	                    iconCls: 'x-fa fa-exclamation-triangle',
	                    viewType: 'archivesCheck',
	                    leaf: true
	                },
	                {
	                    text: '人事档案查询',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    viewType: 'archivesAll',
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
	                    text: '招聘信息发布',
		                iconCls: 'x-fa fa-address-card',
                		viewType: 'recruit',
		                leaf: true
	                },
	                {
	                    text: '简历管理',
	                    iconCls: 'x-fa fa-exclamation-triangle',
	                    viewType: 'resume',
	                    leaf: true
	                },
	                {
	                    text: '面试安排',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    viewType: 'resumeArrangePanel',
	                    leaf: true
	                },
	                {
	                    text: '面试结果审核录入',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    viewType: 'resumeApprovePanel',
	                    leaf: true
	                },
	                {
	                    text: '录用管理',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    viewType: 'employ',
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
                		viewType: 'training',
		                leaf: true
	                },
	                {
	                    text: '培训人员报名',
	                    iconCls: 'x-fa fa-exclamation-triangle',
	                    viewType: 'enroll',
	                    leaf: true
	                },
	                {
	                    text: '培训复核',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    viewType: 'trainingAll',
	                    leaf: true
	                },
	               	{
	                    text: '报名复核',
	                    iconCls: 'x-fa fa-exclamation-triangle',
	                    viewType: 'enrollAll',
	                    leaf: true
	                },
	                {
	                    text: '培训反馈表',
	                    iconCls: 'x-fa fa-lightbulb-o',
	                    viewType: 'feedback',
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
                		viewType: 'sign',
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
	                    viewType: 'attendance',
	                    leaf: true
	                }
	            ]
           	},{
            	text: '资金管理模块',
                iconCls: 'fa fa-cc-visa',
                expanded: false,
                selectable: false,
            	children: [
	                {
	                    text: '薪资标准管理',
		                iconCls: 'fa fa-cc-paypal',
                		viewType: 'salaryStandard',
		                leaf: true
	                },
	                {
	                    text: '薪资查询',
	                    iconCls: '	fa fa-cc-jcb',
	                    viewType: 'salary',
	                    leaf: true
	                },
	                {
	                    text: '薪资分析',
	                    iconCls: 'fa fa-paypal',
	                    viewType: 'salaryAnalysis',
	                    leaf: true
	                },
	                {
	                    text: '报销管理',
		                iconCls: 'fa fa-dollar',
                		viewType: 'paymentCenterPanel',
		                leaf: true
	                },
	                {
	                text: '报销审批',
	                    iconCls: 'fa fa-money',
	                    viewType: 'paymentApproveCenterPanel',
	                    leaf: true
	            	}
	            ]
            },{
            	text: '绩效管理模块',
                iconCls: 'fa fa-area-chart',
                expanded: false,
                selectable: false,
            	children: [
            		// {
            		//  	text: '我的绩效',
		            //     iconCls: 'x-fa fa-address-card',
		            //     rowCls: 'nav-tree-badge nav-tree-badge-new',
		            //   //  viewType: 'performanceTemplet',
		            //     leaf: true
		            // },
            		{
	                    text: '绩效模板',
		                iconCls: 'fa fa-bar-chart',
		                viewType: 'performanceTemplet',
		                leaf: true
	                },
	                {
	                    text: '绩效考核',
		                iconCls: 'fa fa-line-chart',
		                viewType: 'performance',
		                leaf: true
	                },
	                {
	                	text: '待考核',
		                iconCls: 'fa fa-pie-chart',
		                viewType: 'performanceApproveCenterPanel',
		                leaf: true
	                }		
            	]
            },{
               	text: '日程安排模块',
                iconCls: 'fa fa-table',
                viewType: 'scheduling',
                leaf: true
            },{
               	text: '工作汇报',
                iconCls: 'fa fa-cab',
                 expanded: false,
                selectable: false,
            	children: [
	                {
	                    text: '工作汇报',
		                iconCls: 'fa fa-car',
		                viewType: 'report',
		                leaf: true
	                },
	                {
	                    text: '查询全部',
	                    iconCls: 'fa fa-ship',
	                    viewType: 'reportAll',
	                    leaf: true
	                }
	            ]
            },{
                text: 'Login',
                iconCls: 'fa fa-rocket',
                viewType: 'login',
                visible:false,
                leaf: true
           	}
        ]
    }
});