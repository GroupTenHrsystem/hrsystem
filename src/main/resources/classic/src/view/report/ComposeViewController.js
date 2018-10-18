Ext.define('Admin.view.email.ComposeViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.emailcompose',

    onComposeDiscardClick: function(bt) {
        var win = bt.up('window');
        if (win) {
            win.close();
        }
    },

    onSaveComposeClick:function(bt) {
    	var win    = bt.up('window');
    	var form = win.down('form');
    	var contentPanel = Ext.getCmp('contentPanel');
    	var grid = contentPanel.down('grid');
		if(!form.isValid()){
			Ext.Msg.alert("错误", "请填写正确数据");
		}else{
			var values  =form.getValues();
			var editor = form.down('htmleditor');
            Ext.Ajax.request({ 
						url : '/report/save', 
						method : 'post', 
						params : { 
							//ids[] :selectIds
							title: values.title,
							time: values.time,
							messages: editor.getValue()
						}, 
						success: function(response, options) {
			                var json = Ext.util.JSON.decode(response.responseText);
				            if(json.success){
				            	Ext.Msg.alert('操作成功', json.msg, function() {
				                    grid.getStore().reload();
				                    //store.reload();
				                });
					        }else{
					        	 Ext.Msg.alert('操作失败', json.msg);
					        }
			            }
					});


	        win.close();
		}
    }
});
