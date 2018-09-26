Ext.define('Admin.view.recruit.RecruitViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.recruitViewController',
    
    /*Add*/
	openAddWindow:function(toolbar, rowIndex, colIndex){
		toolbar.up('panel').up('container').add(Ext.widget('recruitAddWindow')).show();
	},
	submitAddForm:function(btn){
		var form = btn.up('window').down('form');
		var record = Ext.create('Admin.model.recruit.RecruitModel');
		var values = form.getValues();//获取form数据
		record.set(values);
		record.save();
		Ext.data.StoreManager.lookup('recruitGridStroe').load();
		btn.up('window').close();
	},
		
	/*Edit*/
	openEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win = grid.up('container').add(Ext.widget('recruitEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('recruitGridStroe');
		console.log(store);
		var values = win.down('form').getValues();
		console.log(values); 
		var record = store.getById(values.recruitId);
		console.log(record);
		record.set(values);  
		store.load();
		win.close();
	},
			
	/*Delete*/	
	deleteOneRow:function(grid, rowIndex, colIndex){
		 Ext.MessageBox.confirm('提示', '确定要进行删除操作吗？数据将无法还原！',
  			function(btn, text){
            	if(btn=='yes'){
            		var store = grid.getStore();
					var record = store.getAt(rowIndex);
					store.remove(record);//DELETE//http://localhost:8081/order/112
					//store.sync();
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
                    var selectIds = []; //要删除的id
                    Ext.each(rows, function (row) {
                        selectIds.push(row.data.id);
                    });
                  	Ext.Ajax.request({ 
						url : '/recruit/deletes', 
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
	
	/*quickSearch*/
	quickSearch:function(btn){
		alert("quickSearch");
	},
		
	/* Search More*/
	openSearchWindow:function(toolbar, rowIndex, colIndex){
		toolbar.up('panel').up('container').add(Ext.widget('recruitSearchWindow')).show();
	},	
	submitSearchForm:function(btn){
		var store =	Ext.data.StoreManager.lookup('recruitGridStroe');
		var win = btn.up('window');
		var form = win.down('form');
		var values  = form.getValues();
		Ext.apply(store.proxy.extraParams, {orderName:"",createrTimeStart:"",createrTimeEnd:""});
		Ext.apply(store.proxy.extraParams,{
			orderName:values.orderName,
			createrTimeStart:Ext.util.Format.date(values.createrTimeStart, 'Y/m/d H:i:s'),
			createrTimeEnd:Ext.util.Format.date(values.createrTimeEnd, 'Y/m/d H:i:s')
		});
		store.load({params:{start:0, limit:20, page:1}});
		win.close();
	},
	
	searchComboboxSelectChuang:function(combo,record,index){
		//alert(record.data.name);
		var searchField = this.lookupReference('searchFieldName').getValue();
		if(searchField==='createrTime'){
			this.lookupReference('searchFieldValue').hide();
			this.lookupReference('searchDataFieldValue').setValue(null);
			this.lookupReference('searchDataFieldValue2').setValue(null);
			this.lookupReference('searchDataFieldValue').show();
			this.lookupReference('searchDataFieldValue2').show();
		}else{
			this.lookupReference('searchFieldValue').setValue(null);
			this.lookupReference('searchFieldValue').show();
			this.lookupReference('searchDataFieldValue').hide();
			this.lookupReference('searchDataFieldValue2').hide();
		}
	}	

});
