﻿Ext.define('Admin.view.performanceApprove.PerformanceApproveGrid', {
    extend: 'Ext.grid.Panel',
	xtype:'performanceApproveGrid',
	title: 'tiele',		//需要修改
	iconCls: 'fa-arrow-circle-o-up',
	bind: '{performanceApproveStore}',//调用组件4
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
				handler: 'onClickPerformanceApproveClaimButton'	//ajax  taskId
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
				handler: 'onClickPerformanceApproveCompleteWindowButton'	//taskDefinitionKey 动态表单
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
		,{header: '状态',dataIndex: 'processStatus',width: 60,sortable: true,
            renderer: function(val) {
	            if (val =='NEW') {
		            return '<span style="color:green;">新建</span>';
		        } else if (val =='APPROVAL') {
		            return '<span style="color:blue;">审批中...</span>';
		        } else if (val =='COMPLETE') {
		            return '<span style="color:orange;">完成审批</span>';
		        }else{
		        	return '<span style="color:red;">取消申请</span>';
		        }
		        return val;
            }
		}
		,{header: '发起人'  		,dataIndex: 'userId',width: 60,sortable: true}
		,{header: '绩效名字' ,dataIndex: 'performanceName',width: 80,sortable: true}	
		,{header: '考核开始时间' 	,dataIndex: 'startTime',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d')}
		,{header: '考核结束时间' 			,dataIndex: 'endTime',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d')}
		,{header: '发起时间' 	,dataIndex: 'applyTime',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d')}
		
		,{header: '自评分数' ,dataIndex: 'selfScore',width: 80,sortable: true}	
		,{header: '自评细节' ,dataIndex: 'selfScoreReason',width: 80,sortable: true}	
		,{header: '领导评分' ,dataIndex: 'deptLeaderScore',width: 80,sortable: true}	
		,{header: '领导评分细节' ,dataIndex: 'deptLeaderScoreReason',width: 80,sortable: true}	
		,{header: '申诉理由' ,dataIndex: 'confirmResult',width: 80,sortable: true}	



		// ,{header: 'reason' 		,dataIndex: 'reason',width: 80,sortable: true}
		// ,{header: 'processInstanceId' ,dataIndex: 'processInstanceId',width: 80,sortable: true}
		 ,{header: 'taskId'  		,dataIndex: 'taskId',width: 80,sortable: true,hidden:true}
		// ,{header: 'taskName'  		,dataIndex: 'taskName',width: 80,sortable: true}
		// ,{header: 'taskCreateTime'  ,dataIndex: 'taskCreateTime',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		// ,{header: 'assignee'  		,dataIndex: 'assignee',width: 80,sortable: true}
		// ,{header: 'taskDefinitionKey',dataIndex: 'taskDefinitionKey',width: 80,sortable: true}
		// ,{header: 'processDefinitionId'	,dataIndex: 'processDefinitionId',width: 80,sortable: true}
		// ,{header: 'suspended'  		,dataIndex: 'suspended',width: 80,sortable: true}
		// ,{header: 'version'  		,dataIndex: 'version',width: 60,sortable: true}
	],
	dockedItems: [{
	    xtype: 'pagingtoolbar',
	    dock: 'bottom',
		bind: '{performanceApproveStore}',	//调用组件4
	    displayInfo: true,
	    items: ['-',{
            text: 'Add',
            iconCls: 'x-fa fa-plus',
			listeners: {
				click: 'onClickPerformanceApproveGridAddButton'
            }
        }, '-',{
            text: 'Update',
            iconCls: 'x-fa fa-pencil',
            listeners: {
				click: 'onClickPerformanceApproveGridUpdateButton'
            }
        }, '-', {
            text: 'Delete',
            iconCls: 'x-fa fa-close',
			listeners: {
				click: 'onClickPerformanceApproveGridDeleteButton'
            }
        }]
	}]
});
