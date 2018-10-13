Ext.define('Admin.view.person.PersonPanel', {
    extend: 'Ext.container.Container',
    xtype: 'personPanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.grid.property.*',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.layout.container.VBox',
        'Ext.layout.container.HBox',
        'Ext.form.field.ComboBox',
        'Ext.form.field.Date',
        'Ext.grid.column.Date'
    ],

  //  controller: 'searchresults',
 		viewModel: {type: 'personViewModel'},
        layout: 'fit',
        width: 350,
            //bind:'{personLists}',
            //var store = Ext.data.StoreManager.lookup('userGridStore');
            
        items: [{
            xtype: 'propertygrid',
            nameColumnWidth: 165,
    		reference: 'myGrid',
	    	listeners:{
	    		render:function(view){
					var store = Ext.data.StoreManager.lookup('personGridStore');
					store.load(function(){
						view.setSource(store.getAt(0).data);
					});
				}
				    		
	    	}
        
        ,tbar: [
        	{
		        text: 'Update',
		        tooltip: 'Update data',
		        iconCls: 'fa fa-plus',
		        handler: 'openUpdateWindow'	
		    }
        ] 
        }],

    //controller: 'searchresults',
   // viewModel: {type: 'orderViewModel'},
    layout: 'fit',
   width: 350,
    

            items: [{
                xtype: 'container',
                layout: 'hbox',
                defaultType: 'textfield',
                margin: '0 0 5 0',
                items: [{
                    xtype: 'propertygrid',
                    nameColumnWidth: 165,
                    source: {
                        employeNum:  1,
                        staffName: 1,
                        sex: 1,
                        idcard:1,
                        email: 1,
                        phone: 1,
                        password: 1,
                        address: 1,
                        nativePlace: 1,
                        status: 1,
                        createTimeStart: 1,
                        createTimeEnd:1,
                        birthday: 1
                    },
                    sourceConfig: {
                        borderWidth: {
                            displayName: 'Border Width'
                        },
                        tested: {
                            displayName: 'QA'
                        }
                    }
                }]
        }]   


});

