﻿Ext.define('Admin.view.performanceApprove.PerformanceApproveViewController', {
    extend: Ext.app.ViewController,
    alias: 'controller.performanceApproveViewController',
    //1.签收任务
    onClickPerformanceApproveClaimButton: function(view, recIndex, cellIndex, item, e, record) {
        Ext.Ajax.request({
            url: 'performance/claim/' + record.get('taskId'),
            method: 'post',
            success: function(response, options) {
                var json = Ext.util.JSON.decode(response.responseText);
                if (json.success) {
                    Ext.Msg.alert('操作成功', json.msg, function() {
                        view.getStore().reload();
                    });
                } else {
                    Ext.Msg.alert('操作失败', json.msg);
                }
            }
        });
    },
    //2.创建审批表单（并绑定Task id）
    setCurrentView: function(view, form, title) {
		var cfg = Ext.apply({
			xtype: 'performanceApproveWindow',
			items: [{xtype: form}]
		},{
			title: title
		});
		var win = Ext.widget(cfg);
        view.up('panel').up('container').add(win);
        return win;
    },

    onClickPerformanceApproveCompleteWindowButton: function(view, recIndex, cellIndex, item, e, record) {
    	//选中点击的行
        var taskDefinitionKey = record.get('taskDefinitionKey');
        if(taskDefinitionKey == 'selfAudit'){
            //自评
            var win = this.setCurrentView(view,taskDefinitionKey, '自评');
            win.down('form').getForm().loadRecord(record);
        }
        else if (taskDefinitionKey == 'deptLeaderAudit') {
            //部门领导审批
            var win = this.setCurrentView(view,taskDefinitionKey, '部门领导审批');
            win.down('form').getForm().loadRecord(record);
        } else if (taskDefinitionKey == 'hrAudit') {
        	//人事审批
        	var win = this.setCurrentView(view,taskDefinitionKey,'人事审批表单');
        	win.down('form').getForm().loadRecord(record);
        }
        else if (taskDefinitionKey == 'reportBack') {
        	//申请人销假
        	var win = this.setCurrentView(view,taskDefinitionKey,'销假表单');
        	win.down('form').getForm().loadRecord(record);
        }
        else if (taskDefinitionKey == 'modifyApply') {
        	//申请人调整申请：可以编写到工具类中
        	var win = this.setCurrentView(view,taskDefinitionKey,'调整申请表单');
        	win.down('form').getForm().loadRecord(record);
        }
    },
    //3.封装审批表单数据,并以Ajax提交到后台完成任务的流程变量封装对象中。
	complete: function(url, variables,form){
		// 转换JSON为字符串
	    var keys = "", values = "", types = "";
		if (variables) {
			Ext.each(variables, function (item) {
				if (keys != "") {
					keys += ",";
					values += ",";
					types += ",";
				}
				keys += item.key;
				values += item.value;
				types += item.type;
            });
		}
        var performanceId = form.getValues().id;
		Ext.Ajax.request({
            url: url,
            method: 'post',
            params : { 
			 	keys: keys,
		        values: values,
		        types: types,
                id: performanceId
			}, 
            success: function(response, options) {
                var json = Ext.util.JSON.decode(response.responseText);
                if (json.success) {
                    Ext.Msg.alert('操作成功', json.msg, function() {
                    	form.up('window').close();
                        //grid.getStore().reload();
                        Ext.data.StoreManager.lookup('performanceApproveStore').load();
                    });
                } else {
                    Ext.Msg.alert('操作失败', json.msg);
                }
            }
        });
	},
    //自评
    onClickSelfAuditFormSubmitButton: function(btn) {
        var form = btn.up('form');
        var values = form.getValues();
        var url = 'performance/complete/' + values.taskId; 
        var variables = [{
            key: 'selfPass',
            value: values.selfPass,//获取表单选择的value
            type: 'B'
        },{
            key: 'selfScore',
            value: values.selfScore,//获取表单选择的value
            type: 'F'
        },{
            key: 'selfScoreReason',
            value: values.selfScoreReason,//获取表单选择的value
            type: 'S'
        }];
        this.complete(url,variables,form);
    },
	//部门经理审批
    onClickDeptleaderAuditFormSubmitButton: function(btn) {
    	var form = btn.up('form');
    	var values = form.getValues();
    	var url = 'performance/complete/' + values.taskId;
    	var variables = [{
			key: 'deptLeaderPass',
			value: values.deptLeaderPass,//获取表单选择的value
			type: 'B'
		},{
			key: 'deptLeaderScore',
			value: values.deptLeaderScore,//获取表单选择的value
			type: 'F'
		},{
            key: 'deptLeaderScoreReason',
            value: values.deptLeaderScoreReason,//获取表单选择的value
            type: 'S'
        }];
        this.complete(url,variables,form);
    },
    //人事文员审批
    onClickHrAuditFormSubmitButton: function(btn) {
        var form = btn.up('form');
    	var values = form.getValues();
    	var url = 'performance/complete/' + values.taskId;
    	var variables = [{
			key: 'hrPass',
			value: values.hrPass,//获取表单选择的value
			type: 'B'
		},{
			key: 'hrBackReason',
			value: values.hrBackReason,//获取表单选择的value
			type: 'S'
		}];
        this.complete(url,variables,form);
    },
    //销假
    onClickReportBackFormSubmitButton: function(btn) {
    	var form = btn.up('form');
     	var values = form.getValues();
     	var url = 'performance/complete/' + values.taskId;
     	var variables = [{
 			key: 'confirmResult',
 			value: values.confirmResult,//获取表单选择的value
 			type: 'B'
 		}];
        this.complete(url,variables,form);
    },
    //调整申请
    onClickModifyApplyFormSubmitButton: function(btn) {
        var form = btn.up('form');
    	var values = form.getValues();
    	var url = 'performance/complete/' + values.taskId;
    	var variables = [{
			key: 'reApply',
			value: values.reApply,//获取表单选择的value
			type: 'B'
		},{
			key: 'leaveType',
			value: values.leaveType,//获取表单选择的value
			type: 'S'
		},{
			key: 'startTime',
			value: values.startTime,//获取表单选择的value
			type: 'D'
		},{
			key: 'endTime',
			value: values.endTime,//获取表单选择的value
			type: 'D'
		},{
			key: 'reason',
			value: values.reason,//获取表单选择的value
			type: 'S'
		}];
        this.complete(url,variables,form);
    },
    //流程跟踪
    onClickGraphTraceButton : function(view, recIndex, cellIndex, item, e, record) {
 		var diagramResourceUrl = 'process-trace?processInstanceId=' + record.get('processInstanceId');
        var win = new Ext.window.Window({
            title: '流程跟踪',
            width : 860,
			height : 500,
            layout: 'fit',
            items:[new Ext.Panel({         
	           resizeTabs :true,
	           autoScroll : true,
	           html:'<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src='+diagramResourceUrl+'></iframe>'
	       })]
        });
        win.show();
    }
});