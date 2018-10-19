Ext.define('Admin.view.reportAll.ReportAllViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.reportAllViewController',
    requires: [
        'Ext.exporter.text.CSV',
        'Ext.exporter.text.TSV',
        'Ext.exporter.text.Html',
        'Ext.exporter.excel.Xml',
        'Ext.exporter.excel.Xlsx'
    ],

	/* Clear Text */
	clearText:function(btn){
		this.lookupReference('searchFieldValue0').setValue("");
		this.lookupReference('searchFieldValue1').setValue("");
		this.lookupReference('searchDataFieldValue1').query('datepicker')[0].setValue("");
		this.lookupReference('searchDataFieldValue2').query('datepicker')[0].setValue("");		
		this.lookupReference('searchDataFieldValue3').query('datepicker')[0].setValue("");
		Ext.getCmp('titleCheck').setChecked(false);
		Ext.getCmp('staffNameCheck').setChecked(false);
		Ext.getCmp('timeCheck').setChecked(false);
		Ext.getCmp('timeDetailCheck').setChecked(false);
		Ext.getCmp('timeStartCheck').setChecked(false);
		Ext.getCmp('timeEndCheck').setChecked(false);
	},
 	/* Detail */
	openDetailWindow:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		console.log(record.get('id'));
		//rocord.data.staff.setValue(333);
		// var obj = {"id":1,"salarySum":2};
		//record.data['salarySum'] = 2;
		console.log(record);
		if (record ) {
			var win = grid.up('salary').add(Ext.widget('salaryDetailWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},

	/*Quick Search*/
	quickSearch:function(btn){
//	var searchField = this.lookupReference('searchFieldName').getValue();	
		var titleValue = this.lookupReference('searchFieldValue0').getValue();
		var staffNameValue = this.lookupReference('searchFieldValue1').getValue();
		//开始时间
		var searchDataFieldValue1 = this.lookupReference('searchDataFieldValue1').query('datepicker')[0].getValue();
		var searchDataFieldValue2 = this.lookupReference('searchDataFieldValue2').query('datepicker')[0].getValue();		
		var searchDataFieldValue3 = this.lookupReference('searchDataFieldValue3').query('datepicker')[0].getValue();
		
		var store =	btn.up('gridpanel').getStore();
		store.getProxy().setExtraParams({});
		
		if(Ext.getCmp('titleCheck').checked){
			Ext.apply(store.proxy.extraParams, {title:titleValue});
		}
		if(Ext.getCmp('staffNameCheck').checked){
			Ext.apply(store.proxy.extraParams, {staffName:staffNameValue});
		}
		if(Ext.getCmp('timeCheck').checked){	//时间
			if(Ext.getCmp('timeDetailCheck').checked){
				Ext.apply(store.proxy.extraParams,{
					time:Ext.util.Format.date(searchDataFieldValue3, 'Y/m/d H:i:s')
				});
			}else{
				if(Ext.getCmp('timeStartCheck').checked){
					Ext.apply(store.proxy.extraParams,{
						timeStart:Ext.util.Format.date(searchDataFieldValue1, 'Y/m/d H:i:s')
					});
				}
				if(Ext.getCmp('timeEndCheck').checked){
					Ext.apply(store.proxy.extraParams,{
						timeEnd:Ext.util.Format.date(searchDataFieldValue2, 'Y/m/d H:i:s')
					});
				}	
			}				
		}
		console.log(store.proxy);
		store.load({params:{start:0, limit:20, page:1}});
	}

});
