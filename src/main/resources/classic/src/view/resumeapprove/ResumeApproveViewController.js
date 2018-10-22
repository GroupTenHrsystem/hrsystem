Ext.define('Admin.view.resumeapprove.resumeApproveViewController', {
    extend: Ext.app.ViewController,
    alias: 'controller.resumeApproveViewController',
    //1.签收任务
    onClickResumeApproveClaimButton: function(view, recIndex, cellIndex, item, e, record) {
        Ext.Ajax.request({
            url: 'resume/claim/' + record.get('taskId'),
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
			xtype: 'resumeApproveWindow',
			items: [{xtype: form}]
		},{
			title: title
		});
		var win = Ext.widget(cfg);
        view.up('panel').up('container').add(win);
        return win;
    },
    onClickResumeApproveCompleteWindowButton: function(view, recIndex, cellIndex, item, e, record) {
    	//选中点击的行
        var taskDefinitionKey = record.get('taskDefinitionKey');
        if (taskDefinitionKey == 'resumechose') {
            //笔试分数录入
            var win = this.setCurrentView(view,taskDefinitionKey, '笔试分数录入');
            win.down('form').getForm().loadRecord(record);
        } else if (taskDefinitionKey == 'firstAudit') {
        	//一面审批
        	var win = this.setCurrentView(view,taskDefinitionKey,'一面审批表单');
        	win.down('form').getForm().loadRecord(record);
        } else if (taskDefinitionKey == 'lastAudit') {
        	//二面审批
        	var win = this.setCurrentView(view,taskDefinitionKey,'二面审批表单');
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
		var resumeId = form.getValues().id;
		Ext.Ajax.request({
            url: url,
            method: 'post',
            params : { 
			 	keys: keys,
		        values: values,
		        types: types,
		       	id: resumeId
			}, 
            success: function(response, options) {
                var json = Ext.util.JSON.decode(response.responseText);
                if (json.success) {
                    Ext.Msg.alert('操作成功', json.msg, function() {
                    	form.up('window').close();
                        //grid.getStore().reload();
                        Ext.data.StoreManager.lookup('resumeApproveStore').load();
                    });
                } else {
                    Ext.Msg.alert('操作失败', json.msg);
                }
            }
        });
	},
	//笔试分数录入
    onClickDeptleaderAuditFormSubmitButton: function(btn) {
    	var form = btn.up('form');
    	var values = form.getValues();
    	var url = 'resume/complete/' + values.taskId;
    	var variables = [{
			key: 'deptLeaderPass',
			value: values.deptLeaderPass,//获取表单选择的value
			type: 'B'
		},{
			key: 'penScore',
			value: values.penScore,//获取表单选择的value
			type: 'F'
		}];
        this.complete(url,variables,form);
    },
    //一面审批
    onClickFirstAuditFormSubmitButton: function(btn) {
        var form = btn.up('form');
    	var values = form.getValues();
    	var url = 'resume/complete/' + values.taskId;
    	var variables = [{
			key: 'firstPass',
			value: values.firstPass,//获取表单选择的value
			type: 'B'
		},{
			key: 'firstAuditScore',
            value: values.firstAuditScore,//获取表单选择的value
            type: 'F'
        },{
			key: 'firstBackReason',
			value: values.firstBackReason,//获取表单选择的value
			type: 'S'
		}];
        this.complete(url,variables,form);
    },
    	
    //二面审批
    onClickLastAuditFormSubmitButton: function(btn) {
        var form = btn.up('form');
    	var values = form.getValues();
    	var url = 'resume/complete/' + values.taskId;
    	var variables = [{
			key: 'lastPass',
			value: values.lastPass,//获取表单选择的value
			type: 'B'
		},{
			key: 'lastAuditScore',
            value: values.lastAuditScore,//获取表单选择的value
            type: 'F'
        },{
			key: 'lastBackReason',
			value: values.lastBackReason,//获取表单选择的value
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