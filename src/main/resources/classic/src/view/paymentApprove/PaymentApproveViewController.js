Ext.define('Admin.view.paymentApprove.PaymentApproveViewController', {
    extend: Ext.app.ViewController,
    alias: 'controller.paymentApproveViewController',
    //1.签收任务
    onClickPaymentApproveClaimButton: function(view, recIndex, cellIndex, item, e, record) {
        Ext.Ajax.request({
            url: 'payment/claim/' + record.get('taskId'),
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
			xtype: 'paymentApproveWindow',
			items: [{xtype: form}]
		},{
			title: title
		});
		var win = Ext.widget(cfg);
        view.up('panel').up('container').add(win);
        return win;
    },
    onClickPaymentApproveCompleteWindowButton: function(view, recIndex, cellIndex, item, e, record) {
    	//选中点击的行
        var taskDefinitionKey = record.get('taskDefinitionKey');
        if (taskDefinitionKey == 'paymentAudit') {
            //普通人事审批
            var win = this.setCurrentView(view,taskDefinitionKey, '普通人事审批');
            win.down('form').getForm().loadRecord(record);
        } else if (taskDefinitionKey == 'paymentmanagerAudit') {
        	//人事经理审批
        	var win = this.setCurrentView(view,taskDefinitionKey,'人事经理表单');
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
		var paymentId = form.getValues().id;
		Ext.Ajax.request({
            url: url,
            method: 'post',
            params : { 
			 	keys: keys,
		        values: values,
		        types: types,
		       	id: paymentId
			}, 
            success: function(response, options) {
                var json = Ext.util.JSON.decode(response.responseText);
                if (json.success) {
                    Ext.Msg.alert('操作成功', json.msg, function() {
                    	form.up('window').close();
                        //grid.getStore().reload();
                        Ext.data.StoreManager.lookup('paymentApproveStore').load();
                    });
                } else {
                    Ext.Msg.alert('操作失败', json.msg);
                }
            }
        });
	},
	//普通人事审批
    onClickPaymentAuditFormSubmitButton: function(btn) {
    	var form = btn.up('form');
    	var values = form.getValues();
    	var url = 'payment/complete/' + values.taskId;
    	var variables = [{
			key: 'paymentPass',
			value: values.paymentPass,//获取表单选择的value
			type: 'B'
		},{
			key: 'backReason',
			value: values.backReason,//获取表单选择的value
			type: 'S'
		}];
        this.complete(url,variables,form);
    },
    	
    //人事经理审批
    onClickPaymentmanagerAuditFormSubmitButton: function(btn) {
    	var form = btn.up('form');
    	var values = form.getValues();
    	var url = 'payment/complete/' + values.taskId;
    	var variables = [{
			key: 'paymentmanagerPass',
			value: values.paymentmanagerPass,//获取表单选择的value
			type: 'B'
		},{
			key: 'backReason',
			value: values.backReason,//获取表单选择的value
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