Ext.define('Admin.view.training.TrainingAllViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.trainingAllViewController',
    /*Add*/
	openAddWindow:function(grid, rowIndex, colIndex){
			grid.up('trainingAll').add(Ext.widget('trainingAllAddWindow')).show();
	},   
	submitAddForm:function(btn){
		var win    = btn.up('window');
		var form = win.down('form');
		var record = Ext.create('Admin.model.training.TrainingAllModel');
		var values  =form.getValues();//获取form数据
		var store = Ext.data.StoreManager.lookup('trainingAllGridStroe');
           	record.set(values);
          	record.save();
          	store.load();
          //	Ext.data.StoreManager.lookup('performanceTempletGridStore').load();
          	win.close();
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
			var win = grid.up('trainingAll').add(Ext.widget('trainingAllEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	
	openEditWindowNo:function(grid, rowIndex, colIndex){
        var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win = grid.up('trainingAll').add(Ext.widget('trainingAllEditWindowNo'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('trainingAllGridStroe');
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
		var searchField1 = this.lookupReference('searchFieldName1').getValue();
		var searchValue1 = this.lookupReference('searchFieldValue1').getValue();	
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
		if(searchField1==='courseAuditStatus'){
			var fieldValue1 = searchField1.getValue;
			Ext.apply(store.proxy.extraParams, {courseAuditStatus:searchValue1});			
		}
		
		store.load({params:{start:0, limit:20, page:1}});
	},
	
	quickSearchnow:function(btn){
		var searchField1 = this.lookupReference('searchFieldName1').getValue();
		var searchValue1 = this.lookupReference('searchFieldValue1').getValue();
		var searchField2 = this.lookupReference('searchFieldName2').getValue();
		var searchValue2 = this.lookupReference('searchFieldValue2').getValue();	
		var searchField3 = this.lookupReference('searchFieldName3').getValue();
		var searchValue3 = this.lookupReference('searchFieldValue3').getValue();	
		var searchField4 = this.lookupReference('searchFieldName4').getValue();
		var searchValue4 = this.lookupReference('searchFieldValue4').getValue();	
		var searchField5 = this.lookupReference('searchFieldName5').getValue();
		var searchValue5 = this.lookupReference('searchFieldValue5').getValue();	
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
		
		if(searchField1==='courseAuditStatus'){
			var fieldValue1 = searchField1.getValue;
			Ext.apply(store.proxy.extraParams, {courseAuditStatus:searchValue1});			
		}
		if(searchField3==='courseName'){
			var fieldValue3 = searchField3.getValue;
			console.log(546);
			Ext.apply(store.proxy.extraParams, {courseName:searchValue3});
		}
		if(searchField4==='courseLecturer'){
			var fieldValue4 = searchField4.getValue;
			Ext.apply(store.proxy.extraParams, {courseLecturer:searchValue4});
		}
		if(searchField5==='personLiable'){
			var fieldValue5 = searchField5.getValue;
			Ext.apply(store.proxy.extraParams, {personLiable:searchValue5});
		}
		if(searchField2==='courseCode'){
			var fieldValue2 = searchField2.getValue;
			console.log(546556);
			Ext.apply(store.proxy.extraParams, {courseCode:searchValue2});			
		}
		store.load({params:{start:0, limit:20, page:1}});
	},
	
	/*不通过*/
	submitEditFormYes1:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('trainingAllGridStroe');
    	var values  = win.down('form').getValues();//获取form数据
    	var record = store.getById(values.id);//获取id获取store中的数据
    	if(values.courseAuditStatus !="待审核"){
    		Ext.Msg.alert("错误", "只能审核待审核!!!!!");	 
    	}
    	else{  	
	    	if(win.down('form').isValid()){
	    		values.courseAuditStatus ="审核不通过";
	        	record.set(values);        	
	        	store.load();
	            win.close();
	        }
	        else{
	           	Ext.Msg.alert("错误", "有数据未填");
	        }
    	}
	},
	
	/*通过*/
	submitEditFormYes:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('trainingAllGridStroe');
    	var values  = win.down('form').getValues();//获取form数据
    	var record = store.getById(values.id);//获取id获取store中的数据
    	if(values.courseAuditStatus !="待审核"){
    		Ext.Msg.alert("错误", "只能审核待审核!!!!!");	 
    	}
    	else{  	
	    	if(win.down('form').isValid()){
	    		values.courseAuditStatus ="审核通过";
	        	record.set(values);        	
	        	store.load();
	            win.close();
	        }
	        else{
	           	Ext.Msg.alert("错误", "有数据未填");
	        }
    	}
    	
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
