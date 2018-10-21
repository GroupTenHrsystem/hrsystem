Ext.define('Admin.view.resumeArrange.resumeArrangeViewController', {
    extend: Ext.app.ViewController,
    alias: 'controller.resumeArrangeViewController',
    //1.签收任务
    onClickResumeArrangeClaimButton: function(view, recIndex, cellIndex, item, e, record) {
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
    //2.创建面试安排表单（并绑定Task id）
    setCurrentView: function(view, form, title) {
		var cfg = Ext.apply({
			xtype: 'resumeArrangeWindow',
			items: [{xtype: form}]
		},{
			title: title
		});
		var win = Ext.widget(cfg);
        view.up('panel').up('container').add(win);
        return win;
    },
    onClickResumeArrangeCompleteWindowButton: function(view, recIndex, cellIndex, item, e, record) {
    	//选中点击的行
        var taskDefinitionKey = record.get('taskDefinitionKey');
        if (taskDefinitionKey == 'resumechose') {
            //简历筛选
            var win = this.setCurrentView(view,taskDefinitionKey, '简历筛选');
            win.down('form').getForm().loadRecord(record);
        } else if (taskDefinitionKey == 'firstarrange') {
        	//一面安排
        	var win = this.setCurrentView(view,taskDefinitionKey,'一面安排');
        	win.down('form').getForm().loadRecord(record);
        } else if (taskDefinitionKey == 'lastarrange') {
        	//二面安排
        	var win = this.setCurrentView(view,taskDefinitionKey,'二面安排');
        	win.down('form').getForm().loadRecord(record);
        } 
    },
    //简历审批
    onClickDeptleaderAuditFormSubmitButton: function(btn) {
    	var form = btn.up('form');
    	var values = form.getValues();
    	var url = 'resume/complete/' + values.taskId;
    	var variables = [{
			key: 'deptLeaderPass',
			value: values.deptLeaderPass,//获取表单选择的value
			type: 'B'
		},{
			key: 'resumeBackReason',
			value: values.resumeBackReason,//获取表单选择的value
			type: 'S'
		}];
        this.complete(url,variables,form);
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
	//一面安排
    onClickFirstarrangeFormSubmitButton: function(btn) {
    	var form = btn.up('form');
    	var values = form.getValues();
    	var url = 'resume/complete/' + values.taskId;
    	var variables = [{
			key: 'firstarr',
			value: values.firstarr,//获取表单选择的value
			type: 'S'
		},{
			key: 'firstTime',
			value: values.firstTime,//获取表单选择的value
			type: 'D'
		}];
        this.complete(url,variables,form);
    },
    //二面安排
    onClickLastarrangeFormSubmitButton: function(btn) {
        var form = btn.up('form');
    	var values = form.getValues();
    	var url = 'resume/complete/' + values.taskId;
    	var variables = [{
			key: 'lastarr',
			value: values.lastarr,//获取表单选择的value
			type: 'S'
		},{
			key: 'lastTime',
            value: values.lastTime,//获取表单选择的value
            type: 'D'
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