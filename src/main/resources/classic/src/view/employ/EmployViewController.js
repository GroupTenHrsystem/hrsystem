Ext.define('Admin.view.employ.EmployViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.employViewController',

		
	/*Edit*/
	openEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		if (record ) {
			if(record.data.processStatus=="NEW"){
				var win = grid.up('container').add(Ext.widget('employEditWindow'));
				win.show();
				win.down('form').getForm().loadRecord(record);
			}else{
					Ext.Msg.alert('提示', "只可以修改'新建'状态的信息！");
			}
		}
	},
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('employGridStroe');
		var values = win.down('form').getValues();
		console.log(values);
		var record = store.getById(values.id);
		record.set(values);  
		setTimeout(store.load(),"500");
		win.close();
	},
			
	/*Delete*/	
	deleteOneRow:function(grid, rowIndex, colIndex){
		 Ext.MessageBox.confirm('提示', '确定要进行删除操作吗？数据将无法还原！',
  			function(btn, text){
            	if(btn=='yes'){
            		var store = grid.getStore();
					var record = store.getAt(rowIndex);
					store.remove(record);
				}
        	}
        , this);
	},
	/*Delete More Rows*/	
	deleteMoreRows:function(btn, rowIndex, colIndex){
		var grid = btn.up('gridpanel');
		var selModel = grid.getSelectionModel();
        if (selModel.hasSelection()) {
            Ext.Msg.confirm("警告", "确定要删除吗？", function (button) {
                if (button == "yes") {
                    var rows = selModel.getSelection();
                    var selectIds = []; 
                    Ext.each(rows, function (row) {
                        selectIds.push(row.data.id);
                    });
                  	Ext.Ajax.request({ 
						url : '/resume/deletes', 
						method : 'post', 
						params : { 
							ids :selectIds
						}, 
						success: function(response, options) {
			                var json = Ext.util.JSON.decode(response.responseText);
				            if(json.success){
				            	Ext.Msg.alert('操作成功', json.msg, function() {
				                    grid.getStore().reload();
				                });
					        }else{
					        	 Ext.Msg.alert('操作失败', json.msg);
					        }
			            }
					});
                }
            });
        }else {
            Ext.Msg.alert("错误", "没有任何行被选中，无法进行删除操作！");
        }
	},
	
	/*quickSearch*/
	quickSearch:function(btn){
		alert("quickSearch");
	},
		
	/*存档*/	
	saveIntoUser:function(grid, rowIndex, colIndex){
		 Ext.MessageBox.confirm('提示', '确定要将该简历存入员工表吗？',
  			function(btn, text){
            	if(btn=='yes'){
            	/*	var store = grid.getStore();
					var record = store.getAt(rowIndex);
					Ext.Ajax.request({
						url:'resume/employ',
						method:'post',
				 		params:{
							resume:record				 		
				 		},
						success: function(response, options) {
			                var json = Ext.util.JSON.decode(response.responseText);
				            if(json.success){
				            	Ext.Msg.alert('操作成功', json.msg, function() {
				                    grid.getStore().reload();
				                });
					        }else{
					        	 Ext.Msg.alert('操作失败', json.msg);
					        }
			            }
					});*/
					//record.saveIntoUser();
					Ext.data.StoreManager.lookup('employGridStroe');
				//	win.close();
				}
        	}
        , this);
	}
		

});
