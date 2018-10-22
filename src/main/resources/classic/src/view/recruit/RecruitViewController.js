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
		var values = form.getValues();
		record.set(values);
		record.save();
		Ext.data.StoreManager.lookup('recruitGridStroe').load();
		btn.up('window').close();
	},
		
	/*Edit*/
	openEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		if (record ) {
			var win = grid.up('container').add(Ext.widget('recruitEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('recruitGridStroe');
		var values = win.down('form').getValues();
		var record = store.getById(values.id);
		//console.log(record);
		record.set(values);  
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
						url : '/recruit/deletes', 
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
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchValue = this.lookupReference('searchFieldValue').getValue();
		var store =	btn.up('gridpanel').getStore();
		Ext.apply(store.proxy.extraParams, {departmentname:"",position:""});
		if(searchField==='departmentname'){
			Ext.apply(store.proxy.extraParams, {departmentname:searchValue});
		}
		if(searchField==='position'){
			Ext.apply(store.proxy.extraParams, {position:searchValue});
		}
		store.load({params:{start:0, limit:20, page:1}});
	},
		
	/*Bigger*/
	openBiggerWindow:function(grid,rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		if (record ) {
			var win = grid.up('container').add(Ext.widget('recruitBiggerWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	printInfo:function(btn){
		alert("printInfo");
	}	

});
