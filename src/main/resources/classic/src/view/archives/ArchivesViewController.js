Ext.define('Admin.view.archives.ArchivesViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.archivesViewController',
	/*Add*/
	openAddWindow:function(grid, rowIndex, colIndex){
		grid.up('archives').add(Ext.widget('archivesAddWindow')).show();
	},
	openAddWindowUpload:function(grid, rowIndex, colIndex){
		grid.up('archives').add(Ext.widget('archivesAddWindowUpload')).show();
	},
	submitAddForm:function(btn){
		var win    = btn.up('window');
		var form   = win.down('form');
		
		var record = Ext.create('Admin.model.archives.ArchivesModel');
		var values = form.getValues();//获取form数据
		var store = Ext.data.StoreManager.lookup('archivesGridStroe');		
		var loadin = Ext.getCmp('uploadinput').getValue();
			console.log(loadin);
			values.attach = loadin;
			if(win.down('form').isValid()){
	       	record.set(values);
	      	record.save();
	      	store.load();
	      	
	      //	Ext.data.StoreManager.lookup('performanceTempletGridStore').load();
	      	win.close();
	      	}else{

           		Ext.Msg.alert("错误", "有数据未填");
           		}
	      	//window.location.reload(); //整个页面刷新
	},

	onClickUploadFormSumbitButton: function (btn) {
		var form = btn.up('window').down('form');
		form.getForm().submit({       
			url:'/archives/upload',
			method : 'POST',
			waitMsg: '正在上传，请耐心等待....',
			success: function(form, action){    
				Ext.Msg.alert('Success', action.result.msg,function(){
					Ext.data.StoreManager.lookup('archivesGridStroe').load();
					//form.getViewModel().getStore('processDefinitionStroe').load();
					win.close();
				});       
			}, 
			failure: function(form, action){
				Ext.Msg.alert('Error', action.result.msg);
			}
		});
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
			var win = grid.up('archives').add(Ext.widget('archivesEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('archivesGridStroe');
    	var values  = win.down('form').getValues();//获取form数据
    	var record = store.getById(values.id);//获取id获取store中的数据
    	if(values.arstatus!="作废"){
    		console.log(values.arstatus);
	    	values.arstatus ="待审核";
	    	record.set(values);
	    	console.log(values.arstatus);
	    	store.load();
	        win.close();
	        }
    	else{console.log(values.arstatus);
    		Ext.Msg.alert("错误", "不能修改作废！");
    		}
	},
	
	openEditWindowDelete:function(grid, rowIndex, colIndex){
        var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win = grid.up('archives').add(Ext.widget('archivesEditWindowDelete'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},

	submitEditFormDelete:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('archivesGridStroe');
    	var values  = win.down('form').getValues();//获取form数据
    	var record = store.getById(values.id);//获取id获取store中的数据
    	if(values.arstatus!="审核通过"){
	    values.arstatus ="作废";
	    record.set(values);
	    	
	    store.load();
	    win.close();
	    }
    	else{
		Ext.Msg.alert("错误", "不能作废审核通过！");
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
						url : '/archives/deletes', 
						method : 'post', 
						params : { 
							//ids[] :selectIds
							ids :selectIds
						}, 
						success: function(response, options) {
			                var json = Ext.util.JSON.decode(response.responseText);
				            if(json.success){
				            	Ext.Msg.alert('提示', json.msg, function() {
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
	quickSearch:function(btn){
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchValue = this.lookupReference('searchFieldValue').getValue();		
		var store =	btn.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, 
				{
					archivesId:"",
					ssCard:"",
					bankCard:"",
					education:"",
					major:"",
					graduateSchool:"",
					record:"",
					family:"",
					remark:"",
					attach:"",
					arstatus:""
				});
		
		if(searchField==='archivesId'){
			var fieldValue = searchField.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {archivesId:searchValue});			
		}
		if(searchField==='ssCard'){
			var fieldValue = searchField.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {ssCard:searchValue});			
		}
		if(searchField==='bankCard'){
			var fieldValue = searchField.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {bankCard:searchValue});			
		}
		if(searchField==='education'){
			var fieldValue = searchField.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {education:searchValue});			
		}
		if(searchField==='major'){
			var fieldValue = searchField.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {major:searchValue});			
		}
		if(searchField==='graduateSchool'){
			var fieldValue = searchField.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {graduateSchool:searchValue});			
		}
		if(searchField==='record'){
			var fieldValue = searchField.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {record:searchValue});			
		}
		if(searchField==='family'){
			var fieldValue = searchField.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {family:searchValue});			
		}
		if(searchField==='remark'){
			var fieldValue = searchField.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {remark:searchValue});			
		}
		if(searchField==='attach'){
			var fieldValue = searchField.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {attach:searchValue});			
		}
		
		if(searchField==='arstatus'){
			var fieldValue = searchField.getValue;
			console.log(783);
			Ext.apply(store.proxy.extraParams, {arstatus:searchValue});			
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
		var searchField6 = this.lookupReference('searchFieldName6').getValue();
		var searchValue6 = this.lookupReference('searchFieldValue6').getValue();
		var searchField7 = this.lookupReference('searchFieldName7').getValue();
		var searchValue7 = this.lookupReference('searchFieldValue7').getValue();	
		var searchField8 = this.lookupReference('searchFieldName8').getValue();
		var searchValue8 = this.lookupReference('searchFieldValue8').getValue();	
		var searchField9 = this.lookupReference('searchFieldName9').getValue();
		var searchValue9 = this.lookupReference('searchFieldValue9').getValue();	
		var searchField10 = this.lookupReference('searchFieldName10').getValue();
		var searchValue10 = this.lookupReference('searchFieldValue10').getValue();
		var searchField11 = this.lookupReference('searchFieldName11').getValue();
		var searchValue11 = this.lookupReference('searchFieldValue11').getValue();
		var store =	btn.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, 
				{
					archivesId:"",
					ssCard:"",
					bankCard:"",
					education:"",
					major:"",
					graduateSchool:"",
					record:"",
					family:"",
					remark:"",
					attach:"",
					arstatus:""
				});
		
		if(searchField1==='archivesId'){
			var fieldValue1 = searchField1.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {archivesId:searchValue1});			
		}
		if(searchField2==='ssCard'){
			var fieldValue2 = searchField2.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {ssCard:searchValue2});			
		}
		if(searchField3==='bankCard'){
			var fieldValue3 = searchField.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {bankCard:searchValue3});			
		}
		if(searchField4==='education'){
			var fieldValue4 = searchField4.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {education:searchValue4});			
		}
		if(searchField5==='major'){
			var fieldValue5 = searchField5.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {major:searchValue5});			
		}
		if(searchField6==='graduateSchool'){
			var fieldValue6 = searchField6.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {graduateSchool:searchValue6});			
		}
		if(searchField7==='record'){
			var fieldValue = searchField7.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {record:searchValue7});			
		}
		if(searchField8==='family'){
			var fieldValue8 = searchField.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {family:searchValue8});			
		}
		if(searchField9==='remark'){
			var fieldValue9 = searchField9.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {remark:searchValue9});			
		}
		if(searchField10==='attach'){
			var fieldValue10 = searchField10.getValue;
			console.log(782);
			Ext.apply(store.proxy.extraParams, {attach:searchValue10});			
		}
		
		if(searchField11==='arstatus'){
			var fieldValue11 = searchField.getValue11;
			console.log(783);
			Ext.apply(store.proxy.extraParams, {arstatus:searchValue11});			
		}
		
		store.load({params:{start:0, limit:20, page:1}});
	},
	/*Disable*/	
	onDisableButton:function(grid, rowIndex, colIndex){
		Ext.Msg.alert("Title","Click Disable Button");
	},
	/*查*/
	
	openSearchWindow:function(toolbar, rowIndex, colIndex){
		toolbar.up('grid').up('container').add(Ext.widget('archivesSearchWindow')).show();
	},
	submitSearchForm:function(btn){
		var store =	Ext.data.StoreManager.lookup('archivesGridStroe');
		var win = btn.up('window');
		var form = win.down('form');
		var values  = form.getValues();
		Ext.apply(store.proxy.extraParams, {
					archivesId:"",
					ssCard:"",
					bankCard:"",
					education:"",
					major:"",
					graduateSchool:"",
					record:"",
					family:"",
					remark:"",
					attach:"",
					arstatus:""
			});

		Ext.apply(store.proxy.extraParams,{
			archivesId:values.archivesId,
			ssCard:values.ssCard,
			bankCard:values.bankCard,
			education:values.education,
			major:values.major,
			graduateSchool:values.graduateSchool,
			record:values.record,
			family:values.family,
			remark:values.remark,
			attach:values.attach,
			arstatus:values.arstatus
		});
		store.load({params:{start:0, limit:20, page:1}});
		win.close();
	},

});
