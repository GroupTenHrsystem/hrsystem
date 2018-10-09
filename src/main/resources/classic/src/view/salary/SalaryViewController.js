Ext.define('Admin.view.salary.SalaryViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.salaryViewController',
    requires: [
        'Ext.exporter.text.CSV',
        'Ext.exporter.text.TSV',
        'Ext.exporter.text.Html',
        'Ext.exporter.excel.Xml',
        'Ext.exporter.excel.Xlsx'
    ],

    exportTo: function(btn){
        var cfg = Ext.merge({
           // title: '数钱',
            fileName: '等死' + '.' + (btn.cfg.ext || btn.cfg.type)
        }, btn.cfg);
        this.doExport(cfg);
        //this.getView().saveDocumentAs(cfg);
    },
    
    doExport: function (config) {
        this.getView().saveDocumentAs(config).then(null, this.onError);
    },

	 onBeforeDocumentSave: function(view){
	        this.timeStarted = Date.now();
	        view.mask('Document is prepared for export. Please wait ...');
	        Ext.log('export started');
	},

    onDocumentSave: function(view){
        view.unmask();
        Ext.log('export finished; time passed = ' + (Date.now() - this.timeStarted));
    },

    onDataReady: function(){
        Ext.log('data ready; time passed = ' + (Date.now() - this.timeStarted));
    },
    //  onToggleExpanded: function (btn, pressed) {
    //     var view = this.getView(),
    //         plugin = view.findPlugin('preview'),
    //         vm = this.getViewModel();

    //     plugin.toggleExpanded(pressed);
    //     vm.set({
    //         expanded: pressed
    //     });
    // },
    /*Add*/
	openAddWindow:function(grid, rowIndex, colIndex){
			grid.up('salary').add(Ext.widget('salaryAddWindow')).show();
	},
	submitAddForm:function(btn){
		var win    = btn.up('window');
		var form = win.down('form');
		var record = Ext.create('Admin.model.salary.SalaryModel');

		var values  =form.getValues();//获取form数据
		var store = Ext.data.StoreManager.lookup('salaryGridStroe');
           	record.set(values);
          	record.save();

          	setTimeout(store.load(),"500");
          //	Ext.data.StoreManager.lookup('performanceGridStore').load();
          	win.close();
	},
	/* Clear Text */
	clearText:function(btn){
		this.lookupReference('searchFieldValue').setValue("");
		this.lookupReference('searchDataFieldValue').query('datepicker')[0].setValue("");
		this.lookupReference('searchDataFieldValue2').query('datepicker')[0].setValue("");		
		this.lookupReference('searchDataFieldValue3').query('datepicker')[0].setValue("");
		Ext.getCmp('salarySumCheck').setChecked(false);
		Ext.getCmp('salaryTimeCheck').setChecked(false);
		Ext.getCmp('salaryTimeDetailCheck').setChecked(false);
		Ext.getCmp('salaryTimeStartCheck').setChecked(false);
		Ext.getCmp('salaryTimeEndCheck').setChecked(false);
	},
    /*Edit*/
	openEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win = grid.up('salary').add(Ext.widget('salaryEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('salaryGridStroe');
    	var values  = win.down('form').getValues();//获取form数据
    	var record = store.getById(values.id);//获取id获取store中的数据
    	console.log(values);
    	record.set(values);   	
    	setTimeout(store.load(),"500");
        win.close();
	},
	/*combobox选中后控制对应输入（文本框和日期框）框显示隐藏*/
	// searchComboboxSelectChuang:function(combo,record,index){
	// 	//alert(record.data.name);
	// 	var searchField = this.lookupReference('searchFieldName').getValue();
	// 	if(searchField==='salaryTime'){
	// 		this.lookupReference('searchFieldValue').hide();
	// 		this.lookupReference('searchDataFieldValue').show();
	// 		this.lookupReference('searchDataFieldValue2').show();
	// 	}else{
	// 		this.lookupReference('searchFieldValue').show();
	// 		this.lookupReference('searchDataFieldValue').hide();
	// 		this.lookupReference('searchDataFieldValue2').hide();
	// 	}
	// },
	/*Quick Search*/
	quickSearch:function(btn){
//	var searchField = this.lookupReference('searchFieldName').getValue();
		var searchValue = this.lookupReference('searchFieldValue').getValue();
		var searchDataFieldValue = this.lookupReference('searchDataFieldValue').query('datepicker')[0].getValue();
		var searchDataFieldValue2 = this.lookupReference('searchDataFieldValue2').query('datepicker')[0].getValue();		
		var searchDataFieldValue3 = this.lookupReference('searchDataFieldValue3').query('datepicker')[0].getValue();
		var store =	btn.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, 
				{
					salarySum:"",
					salaryTimeStart:"",
					salaryTimeEnd:"",
					salaryTime:""
			});
		// console.log(salaryTimeEndCheck.checked);
		// console.log(searchDataFieldValue);
		// console.log(searchDataFieldValue2);
		if(Ext.getCmp('salarySumCheck').checked){
			Ext.apply(store.proxy.extraParams, {salarySum:searchValue});
		}
		if(Ext.getCmp('salaryTimeCheck').checked){
			if(Ext.getCmp('salaryTimeDetailCheck').checked){
				Ext.apply(store.proxy.extraParams,{
					salaryTime:Ext.util.Format.date(searchDataFieldValue3, 'Y/m/d H:i:s')
				});
			}else{
				if(Ext.getCmp('salaryTimeStartCheck').checked){
					Ext.apply(store.proxy.extraParams,{
						salaryTimeStart:Ext.util.Format.date(searchDataFieldValue, 'Y/m/d H:i:s')
					});
				}
				if(Ext.getCmp('salaryTimeEndCheck').checked){
					Ext.apply(store.proxy.extraParams,{
						salaryTimeEnd:Ext.util.Format.date(searchDataFieldValue2, 'Y/m/d H:i:s')
					});
				}	
			}				
		}
		store.load({params:{start:0, limit:20, page:1}});
	},
	/*Search More*/	
	openSearchWindow:function(toolbar, rowIndex, colIndex){
		toolbar.up('grid').up('container').add(Ext.widget('salarySearchWindow')).show();
	},
	submitSearchForm:function(btn){
		var store =	Ext.data.StoreManager.lookup('salaryGridStroe');
		var win = btn.up('window');
		var form = win.down('form');
		var values  = form.getValues();
		Ext.apply(store.proxy.extraParams, {
					salarySum:"",
					salaryTimeStart:"",
					salaryTimeEnd:""
			});
		Ext.apply(store.proxy.extraParams,{
			salarySum:values.performanceName
		});
		if(values.salaryTimeStart!=""){
			Ext.apply(store.proxy.extraParams,{
				salaryTimeStart:Ext.util.Format.date(values.salaryTimeStart, 'Y/m/d H:i:s')
			});
		}
		if(values.salaryTimeEnd!=""){
			Ext.apply(store.proxy.extraParams,{
				salaryTimeEnd:Ext.util.Format.date(values.salaryTimeEnd, 'Y/m/d H:i:s')
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
						url : '/salary/deletes', 
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
