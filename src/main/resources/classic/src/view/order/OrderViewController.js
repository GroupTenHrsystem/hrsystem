Ext.define('Admin.view.order.OrderViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.orderViewController',
    /*Add*/
	openAddWindow:function(grid, rowIndex, colIndex){
			var win = grid.up('order').add(Ext.widget('orderAddWindow')).show();
	},
	submitAddForm:function(btn){
		var form = btn.up('window').down('form');
		//form.getValues();
		//�����¼�
	},
	
    /*Edit*/
	openEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		//��ȡѡ�����ݵ��ֶ�ֵ��console.log(record.get('id')); ���� console.log(record.data.id);
		if (record ) {
			var win = grid.up('container').add(Ext.widget('orderEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitEditForm:function(btn){
		var form = btn.up('window').down('form');
		//form.getValues();
		//�����¼�
	},
	/*Quick Search*/	
	quickSearch:function(btn){
		alert("quickSearch");
	},
	/*Search More*/	
	openSearchWindow:function(toolbar, rowIndex, colIndex){
		toolbar.up('grid').up('container').add(Ext.widget('orderSearchWindow')).show();
	},
	submitSearchForm:function(btn){
		var form = btn.up('window').down('form');
		//form.getValues();
		//�����¼�
	},
	/*Delete*/	
	deleteOneRow:function(grid, rowIndex, colIndex){
		Ext.Msg.alert("Delete One Row","Click Delete Button");
	},
	/*Delete More Rows*/	
	deleteMoreRows:function(grid, rowIndex, colIndex){
		Ext.Msg.alert("Delete More Rows","Click Delete Button");
	},
	/*Disable*/	
	onDisableButton:function(grid, rowIndex, colIndex){
		Ext.Msg.alert("Title","Click Disable Button");
	}
});
