Ext.define('Admin.view.employ.EmployViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.employViewController',

	/* Add */
	openSaveWindow:function(grid, rowIndex, colIndex){
			var win = grid.up('employ').add(Ext.widget('employSaveWindow')).show();
	},
		
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
	
	/* show details */
	openshowDetailsWindow:function(grid, rowIndex, colIndex){
        var record = grid.getStore().getAt(rowIndex);
		if (record ) {
			if(record.data.processStatus=="COMPLETE"){
				var win = grid.up('container').add(Ext.widget('employShowDetailsWindow'));
				win.show();
				win.down('form').getForm().loadRecord(record);
			}else{
					Ext.Msg.alert('提示', "只可以修改'新建'状态的信息！");
			}
		}
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
		
	saveIntoStaffFormSubmit:function(btn){
		var form = btn.up('window').down('form');
		var record = Ext.create('Admin.model.employ.EmployModel');
		var values = form.getValues();
		record.set(values);
		//record.save();
		record.saveIntoUser();
		Ext.data.StoreManager.lookup('employGridStroe').load();
		btn.up('window').close();
	},

});
