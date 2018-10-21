Ext.define('Admin.view.resumeapprove.resumeApproveGrid', {
    extend: 'Ext.grid.Panel',
	xtype:'resumeApproveGrid',
	title: '面试管理',		//需要修改
	iconCls: 'fa-arrow-circle-o-up',
	bind: '{resumeApproveStore}',//调用组件4
	columns: [{
			xtype: 'actioncolumn',
			items: [{
				xtype: 'button',
				iconCls: 'x-fa fa-pencil',
				tooltip: '签收任务',
				getClass: function(v, meta, rec) {
		            if (rec.get('assignee')!='') {
		                  return 'x-hidden';
		            }
		            return 'x-fa fa-pencil';
				},
				handler: 'onClickResumeApproveClaimButton'	//ajax  taskId
			},{
				xtype: 'button',
				iconCls: 'x-fa fa-edit',
				tooltip: '审批任务',
				getClass: function(v, meta, rec) {
		            if (rec.get('assignee')=='') {
		                  return 'x-hidden';
		            }
		            return 'x-fa fa-edit';
				},
				handler: 'onClickResumeApproveCompleteWindowButton'	//taskDefinitionKey 动态表单
			},{
				xtype: 'button',
				iconCls: 'x-fa fa-object-group',
				tooltip: '任务跟踪',
				handler: 'onClickGraphTraceButton'	//流程跟踪
			}],
			cls: 'content-column',
			width: 120,
			dataIndex: 'bool',
			text: 'Actions',
			tooltip: 'edit '
		}
		,{header: 'id' 			,dataIndex: 'id',width: 60,sortable: true	,hidden:true}
		,{header: '简历状态',dataIndex: 'processStatus',width: 60,sortable: true,
            renderer: function(val) {
	            if (val =='NEW') {
		            return '<span style="color:green;">新建</span>';
		        } else if (val =='APPROVAL') {
		            return '<span style="color:blue;">审批中...</span>';
		        } else if (val =='COMPLETE') {
		            return '<span style="color:orange;">二面通过</span>';
		        }else if (val =='FIRSTPASS') {
		            return '<span style="color:orange;">一面通过</span>';
		        }else if (val =='FIRSTAIL') {
		            return '<span style="color:orange;">一面失败</span>';
		        } else if (val =='LASTFAIL') {
		            return '<span style="color:orange;">二面失败</span>';
		        } else if (val =='FIRSTARRANGE') {
		            return '<span style="color:orange;">一面安排中...</span>';
		        }else if (val =='LASTARRANGE') {
		            return '<span style="color:orange;">二面安排中</span>';
		        }else{
		        	return '<span style="color:red;">取消申请</span>';
		        }
		        return val;
            }
		}
		,{header: '审批人'  		,dataIndex: 'userId',width: 60,sortable: true}
		,{header: '应聘者姓名'  		,dataIndex: 'name',width: 60,sortable: true}
		,{header: '应聘部门'  		,dataIndex: 'employBranch',width: 60,sortable: true,hidden:true}
		,{header: '评价'  		,dataIndex: 'estimate',width: 60,sortable: true,hidden:true}
		,{header: '面试官'  		,dataIndex: 'interviewer',width: 60,sortable: true,hidden:true}
		,{header: '审批时间' 	,dataIndex: 'interviewTime',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true}
		,{header: '简历退回理由'  		,dataIndex: 'resumeBackReason',width: 60,sortable: true}
		,{header: '一面分数' ,dataIndex: 'firstAuditScore',width: 80,sortable: true}	
		,{header: '一面原因' ,dataIndex: 'firstBackReason',width: 80,sortable: true,hidden:true}	
		,{header: '二面分数' ,dataIndex: 'lastAuditScore',width: 80,sortable: true}
		,{header: '二面原因' ,dataIndex: 'lastBackReason',width: 80,sortable: true,hidden:true}
		,{header: 'processInstanceId' ,dataIndex: 'processInstanceId',width: 80,sortable: true}
		,{header: 'taskId'  		,dataIndex: 'taskId',width: 80,sortable: true,hidden:true}
		,{header: 'taskName'  		,dataIndex: 'taskName',width: 80,sortable: true,hidden:true}
		,{header: 'taskCreateTime'  ,dataIndex: 'taskCreateTime',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true}
		,{header: 'assignee'  		,dataIndex: 'assignee',width: 80,sortable: true}
		,{header: 'taskDefinitionKey',dataIndex: 'taskDefinitionKey',width: 80,sortable: true,hidden:true}
		,{header: 'processDefinitionId'	,dataIndex: 'processDefinitionId',width: 80,sortable: true,hidden:true}
		,{header: 'suspended'  		,dataIndex: 'suspended',width: 80,sortable: true,hidden:true}
		,{header: 'version'  		,dataIndex: 'version',width: 60,sortable: true,hidden:true}
	],
	dockedItems: [{
	    xtype: 'pagingtoolbar',
	    dock: 'bottom',
		bind: '{resumeApproveStore}',	//调用组件4
	    displayInfo: true,
	    items: ['-',{
            text: 'Add',
            iconCls: 'x-fa fa-plus',
			listeners: {
				click: 'onClickResumeApproveGridAddButton'
            }
        }, '-',{
            text: 'Update',
            iconCls: 'x-fa fa-pencil',
            listeners: {
				click: 'onClickResumeApproveGridUpdateButton'
            }
        }, '-', {
            text: 'Delete',
            iconCls: 'x-fa fa-close',
			listeners: {
				click: 'onClickResumeApproveGridDeleteButton'
            }
        }]
	}]
});
