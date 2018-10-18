Ext.define('Admin.view.person.PersonViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.personViewController',

    /*Edit*/
    openUpdateWindow:function(btn,rowIndex, colIndex){
         
    	var person    = btn.up('person');
    	var grid       = person.down('propertygrid');
    	var record = Ext.data.StoreManager.lookup('personGridStore');
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win =grid.up('person').add(Ext.widget('personEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record.getAt(0));
//			alert(record.data);
		}
	},
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('personGridStore');
    	var values  = win.down('form').getValues();//获取form数据
    	store.getAt(0).set(values); 	
    	store.load();
        win.close();
	}
	
});
