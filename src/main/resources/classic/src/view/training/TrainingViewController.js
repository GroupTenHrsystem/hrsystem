Ext.define('Admin.view.training.TrainingViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.trainingViewController',
    /*Add*/
	openAddWindow:function(grid, rowIndex, colIndex){
			grid.up('training').add(Ext.widget('trainingAddWindow')).show();
	},   
	submitAddForm:function(btn){
		var win    = btn.up('window');
		var form = win.down('form');
		var record = Ext.create('Admin.model.training.TrainingModel');
		var values  =form.getValues();//获取form数据
		var store = Ext.data.StoreManager.lookup('trainingGridStroe');
		if(win.down('form').isValid()){
           	record.set(values);
          	record.save();
          	store.load();
          //	Ext.data.StoreManager.lookup('performanceTempletGridStore').load();
          	win.close();
          	}else{

           		Ext.Msg.alert("错误", "有数据未填");
           		}
	},
	/* Clear Text */
	clearText:function(btn){
		this.lookupReference('searchFieldValue').setValue("");
	},
    /*Edit*/
	openEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win = grid.up('training').add(Ext.widget('trainingEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('trainingGridStroe');
    	var values  = win.down('form').getValues();//获取form数据
    	var record = store.getById(values.id);//获取id获取store中的数据
    	record.set(values);
    	
    	store.load();
        win.close();
	},
	
	/*Quick Search*/
	quickSearch:function(btn){
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchValue = this.lookupReference('searchFieldValue').getValue();		
		var store =	btn.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, 
				{
					courseCode:"",
					courseName:"",
					courseLecturer:"",
					personLiable:"",
					courseAuditStatus:""
			});
		
		if(searchField==='courseCode'){
			var fieldValue = searchField.getValue;
			console.log(123);
			Ext.apply(store.proxy.extraParams, {courseCode:searchValue});			
		}
		if(searchField==='courseName'){
			var fieldValue = searchField.getValue;
			console.log(546);
			Ext.apply(store.proxy.extraParams, {courseName:searchValue});
		}
		if(searchField==='courseLecturer'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {courseLecturer:searchValue});
		}
		if(searchField==='personLiable'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {personLiable:searchValue});
		}
		if(searchField==='courseAuditStatus'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {courseAuditStatus:searchValue});
		}
		store.load({params:{start:0, limit:20, page:1}});
	},

	/*Delete*/	
	deleteOneRow:function(grid, rowIndex, colIndex){
		Ext.Msg.confirm('提示信息','确认要删除这条信息吗？',function(op){
		if(op == 'yes'){
			var store = grid.getStore();
			var record = store.getAt(rowIndex);
			store.remove(record);
		// 	store.sync({ 
		//     success: function (proxy, operations) { 
		//      // pop success message 
		//      Ext.Msg.alert('操作成功');
		//     }, failure: function (proxy, operations) { 
		//      // resume records 
		//       Ext.Msg.alert('操作失败');
		//      store.rejectChanges(); 
		//     } 
		// }); 
			//store.sync();
		}else{
			//alert("取消了");
		}
	})

		
	},
	/*Delete More Rows*/	
	deleteMoreRows:function(btn, rowIndex, colIndex){
				var grid = btn.up('gridpanel');
		var selModel = grid.getSelectionModel();
        if (selModel.hasSelection()) {
            Ext.Msg.confirm("警告", "确定要删除吗？", function (button) {
                if (button == "yes") {
                    var rows = selModel.getSelection();
                    var selectIds = []; //要删除的id
                    Ext.each(rows, function (row) {
                        selectIds.push(row.data.id);
                    });
                  	Ext.Ajax.request({ 
						url : '/training/deletes', 
						method : 'post', 
						params : { 
							//ids[] :selectIds
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
	/*Disable*/	
	onDisableButton:function(grid, rowIndex, colIndex){
		Ext.Msg.alert("Title","Click Disable Button");
	}
});
