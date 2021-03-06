Ext.define('Admin.view.user.UserViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.userViewController',
    /*Add*/
	openAddWindow:function(grid, rowIndex, colIndex){
			grid.up('user').add(Ext.widget('userAddWindow')).show();
	},
	submitAddForm:function(btn){
		var win    = btn.up('window');
		var form = win.down('form');
		var record = Ext.create('Admin.model.user.UserModel');
		var values  =form.getValues();//获取form数据
           	record.set(values);
          	record.save();
          	Ext.data.StoreManager.lookup('userGridStore').load();
          	win.close();
	},
	/* Clear Text */
	clearText:function(btn){
		this.lookupReference('searchFieldValue').setValue("");
		this.lookupReference('searchDataFieldValue').setValue("");
		this.lookupReference('searchDataFieldValue2').setValue("");
		
	},
    /*Edit*/
	openEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win = grid.up('user').add(Ext.widget('userEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('userGridStore');
    	var values  = win.down('form').getValues();//获取form数据
    	var record = store.getById(values.id);//获取id获取store中的数据
    	record.set(values);
    	
    	store.load();
        win.close();
	},
	/*combobox选中后控制对应输入（文本框和日期框）框显示隐藏*/
	searchComboboxSelectChuang:function(combo,record,index){
		//alert(record.data.name);
		var searchField = this.lookupReference('searchFieldName').getValue();
		if(searchField==='employmentDate'){
			this.lookupReference('searchFieldValue').hide();
			this.lookupReference('searchDataFieldValue').show();
			this.lookupReference('searchDataFieldValue2').show();
		}else{
			this.lookupReference('searchFieldValue').show();
			this.lookupReference('searchDataFieldValue').hide();
			this.lookupReference('searchDataFieldValue2').hide();
		}
	},
	/*Quick Search*/
	    quickSearch:function(btn){
	    var searchField = this.lookupReference('searchFieldName').getValue();
		var searchValue = this.lookupReference('searchFieldValue').getValue();
		var searchDataFieldValue = this.lookupReference('searchDataFieldValue').getValue();
		var searchDataFieldValue2 = this.lookupReference('searchDataFieldValue2').getValue();
		
		var store =	btn.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, {staffName:"",createTimeStart:"",createTimeEnd:""});
		
		if(searchField==='staffName'){
			Ext.apply(store.proxy.extraParams, {staffName:searchValue});
		}
		if(searchField==='employmentDate'){
			Ext.apply(store.proxy.extraParams,{
				createTimeStart:Ext.util.Format.date(searchDataFieldValue, 'Y/m/d'),
				createTimeEnd:Ext.util.Format.date(searchDataFieldValue2, 'Y/m/d')
			});
		}
		store.load({params:{start:0, limit:20, page:1}});
	},
	/*Search More*/	
	openSearchWindow:function(toolbar, rowIndex, colIndex){
		toolbar.up('grid').up('container').add(Ext.widget('userSearchWindow')).show();
	},
	submitSearchForm:function(btn){
		var store =	Ext.data.StoreManager.lookup('userGridStore');
		var win = btn.up('window');
		var form = win.down('form');
		var values  = form.getValues();
		Ext.apply(store.proxy.extraParams, {staffName:"",createTimeStart:"",createTimeEnd:""});
		Ext.apply(store.proxy.extraParams,{
			staffName:values.staffName,
			createTimeStart:Ext.util.Format.date(values.createTimeStart, 'Y/m/d'),
			createTimeEnd:Ext.util.Format.date(values.createTimeEnd, 'Y/m/d')
		});
		store.load({params:{start:0, limit:20, page:1}});
		win.close();
	},
	/*Delete*/	
	deleteOneRow:function(grid, rowIndex, colIndex){
		Ext.Msg.confirm('提示信息','确认要删除这条信息吗？',function(op){
		if(op == 'yes'){
			var store = grid.getStore();
			var record = store.getAt(rowIndex);
			store.remove(record);//GET //http://localhost:8081/order/112
			store.sync({ 
		    success: function (proxy, operations) { 
		     // pop success message 
		     Ext.Msg.alert('操作成功');
		    }, failure: function (proxy, operations) { 
		     // resume records 
		      Ext.Msg.alert('操作失败');
		     store.rejectChanges(); 
		    } 
		}); 
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
						url : '/Staff/deletes', 
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
