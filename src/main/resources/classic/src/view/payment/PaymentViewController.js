Ext.define('Admin.view.payment.PaymentViewController', {
	extend: 'Ext.app.ViewController',
	alias: 'controller.paymentViewController',
	/*Add*/
	openAddWindow:function(toolbar, rowIndex, colIndex){
		toolbar.up('panel').up('container').add(Ext.widget('paymentAddWindow')).show();
	},
	/*Edit*/
	openEditWindow:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		
		if (record ) {
			if(record.data.processStatus=="NEW"){
				var win = grid.up('container').add(Ext.widget('paymentEditWindow'));
				win.show();
				win.down('form').getForm().loadRecord(record);
			}else{
				Ext.Msg.alert('提示', "只可以修改'新建'状态的信息！");
			}
		}
	},

	/********************************************** Submit / Ajax / Rest *****************************************************/
	/*Add Submit*/	
	submitAddForm:function(btn){
		var win    = btn.up('window');
		var form = win.down('form');
		var record = Ext.create('Admin.model.payment.PaymentModel');
		var values  =form.getValues();//获取form数据
		record.set(values);
		record.save();
		Ext.data.StoreManager.lookup('paymentStroe').load();
		win.close();
	},
	/*Edit Submit*/	
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('paymentStroe');
		var values  = win.down('form').getValues();//获取form数据
		var record = store.getById(values.id);//获取id获取store中的数据
		record.set(values);//rest put 
		//store.load();
		win.close();
	},
	/*Quick Search*/	
	quickSearch:function(btn){
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchDataFieldValue = this.lookupReference('searchDataFieldValue').getValue();
		var store =	btn.up('gridpanel').getStore();
		Ext.apply(store.proxy.extraParams, 
				{
					processStatus:"",
				//	cycle:"",
					price:"",
					reason:""
			});		
		if(searchField==='processStatus'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {processStatus:searchDataFieldValue});
		}
		if(searchField==='price'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {price:searchDataFieldValue});
		}
		if(searchField==='reason'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {reason:searchDataFieldValue});
		}
		store.load({params:{start:0, limit:20, page:1}});
	},

	clearText:function(btn){
		this.lookupReference('searchDataFieldValue').setValue("");	
	},

	submitSearchForm:function(btn){

	},
	/*Delete One Row*/	
	deleteOneRow:function(grid, rowIndex, colIndex){
		var store = grid.getStore();
		var record = store.getAt(rowIndex);
		if(record.data.processStatus=="NEW"){
			Ext.MessageBox.confirm('提示', '确定要进行删除操作吗？数据将无法还原！',function(btn, text){
				if(btn=='yes'){
					store.remove(record);
				}
			}, this);
		}else{
			Ext.Msg.alert('提示', "只可以删除'新建'状态的信息！");
		}
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
						if(row.data.processStatus=="NEW"){
							selectIds.push(row.data.id);
						}
					});
					Ext.Ajax.request({ 
						url : '/payment/deletes', 
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
	/*Star Payment Process*/	
	startPaymentProcess:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		Ext.Ajax.request({ 
			url : '/payment/start', 
			method : 'post', 
			params : {
				id :record.get("id"),
				price:record.get("price")
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
	},	
	/*Cancel Payment Process*/	
	cancelPaymentProcess:function(grid, rowIndex, colIndex){
		Ext.Msg.alert("Title","Cancel Leave Process");
	}
});
