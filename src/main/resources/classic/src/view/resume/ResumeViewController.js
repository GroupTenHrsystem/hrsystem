Ext.define('Admin.view.resume.ResumeViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.resumeViewController',
    
    /*Add*/
	openAddWindow:function(toolbar, rowIndex, colIndex){
		toolbar.up('panel').up('container').add(Ext.widget('resumeAddWindow')).show();
	},
	submitAddForm:function(btn){
		var win    = btn.up('window');
		var form = win.down('form');
		if(!form.isValid()){
			Ext.Msg.alert("错误", "请正确填写所有信息！");
		}else{
			var record = Ext.create('Admin.model.resume.ResumeModel');
			var values = form.getValues();  //获取form数据
			record.set(values);
			record.save();
			Ext.data.StoreManager.lookup('resumeGridStroe');
			win.close();
		}
	},
		
	/*Edit*/
	openEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		if (record ) {
			if(record.data.processStatus=="NEW"){
				var win = grid.up('container').add(Ext.widget('resumeEditWindow'));
				win.show();
				win.down('form').getForm().loadRecord(record);
			}else{
					Ext.Msg.alert('提示', "只可以修改'新建'状态的信息！");
			}
		}
	},
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('resumeGridStroe');
		var values = win.down('form').getValues();
		console.log(values);
		var record = store.getById(values.id);
		record.set(values);  
		//setTimeout(store.load(),"500");
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
		Ext.apply(store.proxy.extraParams, {name:"",major:"",politicsStatus:"",processStatus:""});
		if(searchField==='name'){
			Ext.apply(store.proxy.extraParams, {name:searchValue});
		}
		if(searchField==='major'){
			Ext.apply(store.proxy.extraParams, {major:searchValue});
		}
		if(searchField==='politicsStatus'){
			Ext.apply(store.proxy.extraParams, {politicsStatus:searchValue});
		}
		if(searchField==='processStatus'){
			Ext.apply(store.proxy.extraParams, {processStatus:searchValue});
		}
		store.load({params:{start:0, limit:20, page:1}});
	},
		
		
	/*Start Resume Process*/	
	startResumeProcess:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		Ext.Ajax.request({ 
			url : '/resume/start', 
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

	/*Cancel Resume Process*/	
	cancelResumeProcess:function(grid, rowIndex, colIndex){
		Ext.Msg.alert("Title","Cancel Leave Process");
	},
		
	/* 文件上传 */	
	onClickresumeUploadButton: function (btn) {
		var form = btn.up('window').down('form');;
		form.getForm().submit({       
			url:'/resumeupload',
			method : 'POST',
			waitMsg: '正在上传，请耐心等待....',
			success: function(form, action){    
				Ext.Msg.alert('Success', action.result.msg,function(){
					btn.up('window').close();
				});       
			}, 
			failure: function(form, action){
				Ext.Msg.alert('Error', action.result.msg);
			}
		});
    }

});
