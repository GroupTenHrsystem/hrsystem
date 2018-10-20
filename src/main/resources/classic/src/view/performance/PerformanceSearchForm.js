Ext.define('Aria.view.performance.PerformanceSearchForm', {
    	extend: 'Ext.form.Panel',
    	id:'performanceAddForm',
        xtype: 'performanceSearchForm',
        bodyPadding: 10,
	    defaults: {
	        anchor: '100%',
	        labelWidth: 100
	    },
        items: [
			{
	            items:[{
	            	xtype:'container',
	            	layout:'hbox',
	            	items:[

									{xtype: 'textfield',fieldLabel:'绩效考核名称',allowBlank:false, name:'performanceName'},	
							{items:[
									{xtype: 'textfield',fieldLabel:'id',name:'id',hidden:true,readOnly:true},
									{xtype: 'textfield',fieldLabel:'processStatus',name:'processStatus',hidden:true,readOnly:true},	
						    		{xtype: 'datefield',fieldLabel:'开始时间开始',name:'startTimeStart',editable:false,format: 'Y/m/d H:i:s'},
									{xtype: 'datefield',fieldLabel: '结束时间开始',name:'endTimeStart',editable:false,format: 'Y/m/d H:i:s'},
						    	]
						    },

							{items:[
								{xtype: 'datefield',fieldLabel:' 开始时间结束',name:'startTimeEnd',editable:false,format: 'Y/m/d H:i:s'},
								{xtype: 'datefield',fieldLabel: '结束时间结束',name:'endTimeEnd',editable:false,format: 'Y/m/d H:i:s'},
							]}
					]
				}]
	   		},
    	],


})
