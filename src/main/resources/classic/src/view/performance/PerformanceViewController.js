Ext.define('Admin.view.performance.PerformanceViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.performanceViewController',
    onTabChange: function(tabs, newTab, oldTab) {
        Ext.suspendLayouts();
        newTab.setTitle('绩效管理');
        oldTab.setTitle('参与的绩效');
        Ext.resumeLayouts(true);
    },
    /*Add*/
	openAddWindow:function(grid, rowIndex, colIndex){
			grid.up('performance').add(Ext.widget('performanceAddWindow')).show();
	},
	submitAddForm:function(btn){
		var win    = btn.up('window');
		var form = win.down('form');
		var record = Ext.create('Admin.model.performance.PerformanceModel');

		var values  =form.getValues();//获取form数据
		var store = Ext.data.StoreManager.lookup('performanceGridStroe');
           	record.set(values);
          	record.save();

          	setTimeout(store.load(),"500");
          //	Ext.data.StoreManager.lookup('performanceGridStore').load();
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
			var win = grid.up('performance').add(Ext.widget('performanceEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('performanceGridStroe');
    	var values  = win.down('form').getValues();//获取form数据
    	var record = store.getById(values.id);//获取id获取store中的数据
    	console.log(record);
    	record.set(values);   	
    	setTimeout(store.load(),"500");
        win.close();
	},
	/*combobox选中后控制对应输入（文本框和日期框）框显示隐藏*/
	searchComboboxSelectChuang:function(combo,record,index){
		//alert(record.data.name);
		var searchField = this.lookupReference('searchFieldName').getValue();
		if(searchField==='startTime' || searchField==='endTime'){
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
		Ext.apply(store.proxy.extraParams, 
				{
					performanceName:"",
					cycle:"",
					startTimeStart:"",
					startTimeEnd:"",
					endTimeStart:"",
					endTimeEnd:""
			});
		
		if(searchField==='performanceName'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {performanceName:searchValue});
		}
		if(searchField==='cycle'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {cycle:searchValue});
		}
		if(searchField==='startTime'){
			Ext.apply(store.proxy.extraParams,{
				startTimeStart:Ext.util.Format.date(searchDataFieldValue, 'Y/m/d H:i:s'),
				startTimeEnd:Ext.util.Format.date(searchDataFieldValue2, 'Y/m/d H:i:s')
			});
		}
		if(searchField==='endTime'){
			Ext.apply(store.proxy.extraParams,{
				endTimeStart:Ext.util.Format.date(searchDataFieldValue, 'Y/m/d H:i:s'),
				endTimeEnd:Ext.util.Format.date(searchDataFieldValue2, 'Y/m/d H:i:s')
			});
		}
		store.load({params:{start:0, limit:20, page:1}});
	},
	/*Search More*/	
	openSearchWindow:function(toolbar, rowIndex, colIndex){
		toolbar.up('grid').up('container').add(Ext.widget('performanceSearchWindow')).show();
	},
	submitSearchForm:function(btn){
		var store =	Ext.data.StoreManager.lookup('performanceGridStroe');
		var win = btn.up('window');
		var form = win.down('form');
		var values  = form.getValues();
		Ext.apply(store.proxy.extraParams, {
					performanceName:"",
					cycle:"",
					startTimeStart:"",
					startTimeEnd:"",
					endTimeStart:"",
					endTimeEnd:""
			});
		Ext.apply(store.proxy.extraParams,{
			performanceName:values.performanceName,
			cycle:values.cycle
		});
		if(values.startTimeStart!=""){
			Ext.apply(store.proxy.extraParams,{
				startTimeStart:Ext.util.Format.date(values.startTimeStart, 'Y/m/d H:i:s')
			});
		}
		if(values.startTimeEnd!=""){
			Ext.apply(store.proxy.extraParams,{
				startTimeEnd:Ext.util.Format.date(values.startTimeEnd, 'Y/m/d H:i:s')
			});
		}
		if(values.endTimeStart!=""){
			Ext.apply(store.proxy.extraParams,{
				endTimeStart:Ext.util.Format.date(values.endTimeStart, 'Y/m/d H:i:s')
			});
		}
		if(values.endTimeEnd!=""){
			Ext.apply(store.proxy.extraParams,{
				endTimeEnd:Ext.util.Format.date(values.endTimeEnd, 'Y/m/d H:i:s')
			});
		}
		store.load({params:{start:0, limit:20, page:1}});
		win.close();
	},
	/*Delete*/	
	deleteOneRow:function(grid, rowIndex, colIndex){
		Ext.Msg.confirm('提示信息','确认要删除这条信息吗？',function(op){
		if(op == 'yes'){
			var store = grid.getStore();
			var record = store.getAt(rowIndex);
			store.remove(record);
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
						url : '/performance/deletes', 
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
	// onDisableButton:function(grid, rowIndex, colIndex){
	// 	Ext.Msg.alert("Title","Click Disable Button");
	// }
	
	/*Star Leave Process*/	
	starLeaveProcess:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		Ext.Ajax.request({ 
			url : '/performance/start', 
			method : 'post', 
			params : {
				id :record.get("id")
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
	/*Cancel Leave Process*/	
	cancelLeaveProcess:function(grid, rowIndex, colIndex){
		Ext.Msg.alert("Title","Cancel Leave Process");
	}
	
});
