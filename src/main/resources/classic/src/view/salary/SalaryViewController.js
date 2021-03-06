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

    onTabChange: function(tabs, newTab, oldTab) {
        Ext.suspendLayouts();
        newTab.setTitle('薪资查询');
        oldTab.setTitle('薪资分析');
        Ext.resumeLayouts(true);
    },

    exportTo: function(btn){
        var cfg = Ext.merge({
           // title: '数钱',
            fileName: '薪资' + '.' + (btn.cfg.ext || btn.cfg.type)
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
    /*Add*/
	openAddWindow:function(grid, rowIndex, colIndex){
			grid.up('salary').add(Ext.widget('salaryAddWindow')).show();
	},
	toggleDisabled:function(checkbox, checked){
        var staffTag = this.lookupReference('staffTag');    //获取下拉框组件
        
        var arrayObj = new Array();
         	staffTag.reset();    // 清空已存在结果
         	staffTag.getStore().each(function (record) {
         		arrayObj.push(record.get('id'));	//全选下拉框的内容
		    	//console.log(record.get('id'));
			});
			staffTag.setValue(arrayObj);

      
        
	},
	submitAddForm:function(btn){
		var win    = btn.up('window');
		var form = win.down('form');
		if(!form.isValid()){
			Ext.Msg.alert("错误", "请填写正确数据")
		}else{
			var record = Ext.create('Admin.model.salary.SalaryModel');

			var values  =form.getValues();//获取form数据
			var store = Ext.data.StoreManager.lookup('salaryGridStroe');
	           	record.set(values);
	          	record.save();

	          	setTimeout(store.load(),"500");
	          //	Ext.data.StoreManager.lookup('performanceGridStore').load();
	          	win.close();
	    }
	},
	/* Clear Text */
	clearText:function(btn){
		this.lookupReference('searchFieldValue').setValue("");
		this.lookupReference('staffNameValue').setValue("");
		this.lookupReference('salaryStandardValue').setValue("");
		this.lookupReference('searchDataFieldValue').query('datepicker')[0].setValue("");
		this.lookupReference('searchDataFieldValue2').query('datepicker')[0].setValue("");		
		this.lookupReference('searchDataFieldValue3').query('datepicker')[0].setValue("");
		this.lookupReference('searchDataFieldValue4').query('datepicker')[0].setValue("");
		this.lookupReference('searchDataFieldValue5').query('datepicker')[0].setValue("");		
		this.lookupReference('searchDataFieldValue6').query('datepicker')[0].setValue("");
		Ext.getCmp('salarySumCheck').setChecked(false);
		Ext.getCmp('staffNameCheck').setChecked(false);
		Ext.getCmp('salaryStandardCheck').setChecked(false);
		Ext.getCmp('salaryStarTimeCheck').setChecked(false);
		Ext.getCmp('salaryStarTimeDetailCheck').setChecked(false);
		Ext.getCmp('salaryStarTimeStartCheck').setChecked(false);
		Ext.getCmp('salaryStarTimeEndCheck').setChecked(false);
		Ext.getCmp('salaryEndTimeDetailCheck').setChecked(false);
		Ext.getCmp('salaryEndTimeStartCheck').setChecked(false);
		Ext.getCmp('salaryEndTimeEndCheck').setChecked(false);
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
    	record.set(values);   	
    	setTimeout(store.load(),"500");
        win.close();
	},
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
		var searchValue = this.lookupReference('searchFieldValue').getValue();
		var staffNameValue = this.lookupReference('staffNameValue').getValue();
		var salaryStandardValue = this.lookupReference('salaryStandardValue').getValue();
		//开始时间
		var searchDataFieldValue = this.lookupReference('searchDataFieldValue').query('datepicker')[0].getValue();
		var searchDataFieldValue2 = this.lookupReference('searchDataFieldValue2').query('datepicker')[0].getValue();		
		var searchDataFieldValue3 = this.lookupReference('searchDataFieldValue3').query('datepicker')[0].getValue();
		//结束时间
		var searchDataFieldValue4 = this.lookupReference('searchDataFieldValue4').query('datepicker')[0].getValue();
		var searchDataFieldValue5 = this.lookupReference('searchDataFieldValue5').query('datepicker')[0].getValue();		
		var searchDataFieldValue6 = this.lookupReference('searchDataFieldValue6').query('datepicker')[0].getValue();
		var store =	btn.up('gridpanel').getStore();
		store.getProxy().setExtraParams({});
		// Ext.apply(store.proxy.extraParams, 
		// 		{
		// 			salarySum:"",
		// 			//staffName:"",name:"",
		// 			salaryStarTimeStart:"",salaryStarTimeEnd:"",salaryStarTime:"",
		// 			salaryEndTimeStart:"",salaryEndTimeEnd:"",salaryEndTime:""
		// 	});
		if(Ext.getCmp('salarySumCheck').checked){
			Ext.apply(store.proxy.extraParams, {salarySum:searchValue});
		}
		if(Ext.getCmp('staffNameCheck').checked){
			Ext.apply(store.proxy.extraParams, {staffName:staffNameValue});
		}
		if(Ext.getCmp('salaryStandardCheck').checked){
			Ext.apply(store.proxy.extraParams, {name:salaryStandardValue});
		}
		if(Ext.getCmp('salaryStarTimeCheck').checked){	//开始时间
			if(Ext.getCmp('salaryStarTimeDetailCheck').checked){
				Ext.apply(store.proxy.extraParams,{
					salaryStarTime:Ext.util.Format.date(searchDataFieldValue3, 'Y/m/d H:i:s')
				});
			}else{
				if(Ext.getCmp('salaryStarTimeStartCheck').checked){
					Ext.apply(store.proxy.extraParams,{
						salaryStarTimeStart:Ext.util.Format.date(searchDataFieldValue, 'Y/m/d H:i:s')
					});
				}
				if(Ext.getCmp('salaryStarTimeEndCheck').checked){
					Ext.apply(store.proxy.extraParams,{
						salaryStarTimeEnd:Ext.util.Format.date(searchDataFieldValue2, 'Y/m/d H:i:s')
					});
				}	
			}				
		}
		if(Ext.getCmp('salaryEndTimeCheck').checked){	//结束时间
			if(Ext.getCmp('salaryEndTimeDetailCheck').checked){
				Ext.apply(store.proxy.extraParams,{
					salaryEndTime:Ext.util.Format.date(searchDataFieldValue6, 'Y/m/d H:i:s')
				});
			}else{
				if(Ext.getCmp('salaryEndTimeStartCheck').checked){
					Ext.apply(store.proxy.extraParams,{
						salaryEndTimeStart:Ext.util.Format.date(searchDataFieldValue4, 'Y/m/d H:i:s')
					});
				}
				if(Ext.getCmp('salaryEndTimeEndCheck').checked){
					Ext.apply(store.proxy.extraParams,{
						salaryEndTimeEnd:Ext.util.Format.date(searchDataFieldValue5, 'Y/m/d H:i:s')
					});
				}	
			}				
		}
		console.log(store.proxy);
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
					salaryStarTimeStart:"",
					salaryStarTimeEnd:""
			});
		Ext.apply(store.proxy.extraParams,{
			salarySum:values.performanceName
		});
		if(values.salaryStarTimeStart!=""){
			Ext.apply(store.proxy.extraParams,{
				salaryStarTimeStart:Ext.util.Format.date(values.salaryStarTimeStart, 'Y/m/d H:i:s')
			});
		}
		if(values.salaryStarTimeEnd!=""){
			Ext.apply(store.proxy.extraParams,{
				salaryStarTimeEnd:Ext.util.Format.date(values.salaryStarTimeEnd, 'Y/m/d H:i:s')
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
	},
	/*柱状图刷新数据*/
	onReloadData:function(btn){
		var analysisPanel = btn.up('salaryAnalysis');
		var chart = Ext.getCmp("chart");
       	chart.getStore().removeAll();
       	setTimeout(function(){
     			chart.getStore().load();
		},1000);      
	},
	onDownload: function() {
        if (Ext.isIE8) {
            Ext.Msg.alert('Unsupported Operation', 'This operation requires a newer version of Internet Explorer.');
            return;
        }
        var chart = Ext.getCmp("chart");
        if (Ext.os.is.Desktop) {
            chart.download({
                filename: 'Redwood City Climate Data Chart'
            });
        } else {
            chart.preview();
        }
    },

});
