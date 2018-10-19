Ext.define('Admin.view.archives.ArchivesAllViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.archivesAllViewController',
	/*Add*/
	openAddWindow:function(grid, rowIndex, colIndex){
		grid.up('archivesAll').add(Ext.widget('archivesAllAddWindow')).show();
	},
	submitAddForm:function(btn){
		var win    = btn.up('window');
		var form   = win.down('form');
		var record = Ext.create('Admin.model.archives.ArchivesAllModel');
		var values = form.getValues();//获取form数据
		var store = Ext.data.StoreManager.lookup('archivesAllGridStroe');
	       	record.set(values);
	      	record.save();
	      	store.load();
	      //	Ext.data.StoreManager.lookup('performanceTempletGridStore').load();
	      	win.close();
	      	//window.location.reload(); //整个页面刷新
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
			var win = grid.up('archivesAll').add(Ext.widget('archivesAllEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('archivesAllGridStroe');
    	var values  = win.down('form').getValues();//获取form数据
    	var record = store.getById(values.id);//获取id获取store中的数据
    	record.set(values);    	
    	store.load();
        win.close();
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
	/*Disable*/	
	onDisableButton:function(grid, rowIndex, colIndex){
		Ext.Msg.alert("Title","Click Disable Button");
	},
	/*查*/
	
	openSearchWindow:function(toolbar, rowIndex, colIndex){
		toolbar.up('grid').up('container').add(Ext.widget('archivesAllSearchWindow')).show();
	},
	submitSearchForm:function(btn){
		var store =	Ext.data.StoreManager.lookup('archivesAllGridStroe');
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
	}
/*
	submitSearchForm:function(btn){	
		var win = btn.up('window');
		var form = win.down('form');
		var values = form.getValues();
		var archivesId = values.archivesId;
		console.log(archivesId);
		Ext.Ajax.request({
            url: '/archives/searchs',
            method: 'get',
            params:{
            	archivesId :values.archivesId,
				ssCard :values.ssCard,
				bankCard :values.bankCard,
				arstatus :values.arstatus
				},
				dataType: "json",
		        async: false,
		        cache:false,
            success: function() {
            	var store =	Ext.data.StoreManager.lookup('archivesAllGridStroe');
            	var win = btn.up('window');
        		var form = win.down('form');
        		var values=form.getValues();
        		Ext.apply(store.proxy.extraParams, {
        			archivesId:"",
        			ssCard:"",
        			bankCard:"",
        			arstatus:""
        		});
        		Ext.apply(store.proxy.extraParams, {
        			archivesId:values.archivesId,
        			ssCard:values.ssCardId,
        			bankCard:values.bankCard,
        			arstatus:values.arstatus
        		});        		
        	
        		store.load({params:{start:0, limit:20, page:1}});
        		win.close();
            }
        	});
       }		
	*/

});
