Ext.define('Admin.view.department.DepartmentViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.departmentViewController',

    openEditWindow:function(grid, rowIndex, colIndex){
    	 var record = grid.getStore().getAt(rowIndex);
 		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
 		if (record ) {
 			var win = grid.up('department').add(Ext.widget('departmentEditWindow'));
 			win.show();
 			win.down('form').getForm().loadRecord(record);
 		}
    },
    submitEditForm:function(btn){
		var win    = btn.up('window');
		var values  = win.down('form').getValues();//获取form数据
		console.log(values);
			Ext.Ajax.request({ 
				url : '/department/update', 
				method : 'post', 
				params : { 
					//ids[] :selectIds
					id :values.id,
					departmentName:values.departmentName,
					introduce:values.introduce
				}
			})
	    win.close();
	},
	saveOneRow:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		if (record ) {
		var win =grid.up('department').add(Ext.widget('departmentAddWindow'));
		win.show();
		record.set('departmentName','');
		record.set('introduce','');
		win.down('form').getForm().loadRecord(record);
		}
		grid.getStore().reload();
	},
	submitAddForm:function(btn){
		var win    = btn.up('window');
		var form = win.down('form');
		var values  =form.getValues();//获取form数据           	         
          	console.log(values);
			Ext.Ajax.request({ 
				url : '/department/save', 
				method : 'post', 
				params : { 
					//ids[] :selectIds
//					id :record.id,
					departmentName:values.departmentName,
					introduce:values.introduce,
					superId:values.id
				}
			});
          	win.close();
	},
	onDeleteButton:function(grid, rowIndex, colIndex){
		Ext.Msg.confirm('提示信息','确认要删除这条信息吗？',function(op){
			if(op == 'yes'){
				var store = grid.getStore();
				var record = store.getAt(rowIndex);
				
				Ext.Ajax.request({ 
					url : '/department/delete', 
					method : 'post', 
					params : { 
						//ids[] :selectIds
						id :record.id
					}, 
					success: function(response, options) {
		                var json = Ext.util.JSON.decode(response.responseText);
			            if(json.success){
			            	Ext.Msg.alert('操作成功', json.msg, function() {
			                    grid.getStore().reload();
			                });
				        }else{
				        	 Ext.Msg.alert('操作失败，请先删除部门下的职位', json.msg);
				        }
		            }
				});
				//store.sync();
			}else{
				//alert("取消了");
			}
		})
		}
});