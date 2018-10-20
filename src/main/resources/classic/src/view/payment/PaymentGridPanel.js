Ext.define('Admin.view.payment.PaymentGridPanel', {
	extend: 'Ext.panel.Panel',
	xtype: 'paymentGridPanel',
	requires: [
		'Ext.grid.Panel',
		'Ext.toolbar.Paging',
		'Ext.form.field.ComboBox',
		'Ext.selection.CheckboxModel',
		'Ext.form.field.Date',
		'Ext.grid.column.Date'
	],
	layout: 'fit',
    minHeight: 700,
	items: [{
		xtype: 'gridpanel',
		title: '报销管理',
		//routeId: 'user',
		bind: '{paymentLists}',
		scrollable: false,
		selModel: {type: 'checkboxmodel'},
		columns: [
			 {header: 'id',dataIndex:'id',width: 60,sortable: true,hidden:true}
			,{header: '状态',dataIndex: 'processStatus',width: 160,sortable: true,
	            renderer: function(val) {
		            if (val =='NEW') {
			            return '<span style="color:green;">新建</span>';
			        } else if (val =='APPROVAL') {
			            return '<span style="color:blue;">审批中...</span>';
			        } else if (val =='COMPLETE') {
			            return '<span style="color:orange;">完成审批</span>';
			        }else{
			        	return '<span style="color:red;">取消申请</span>';
			        }
			        return val;
	            }
			}
			,{header: '发起人',dataIndex: 'userId',width: 160,sortable: true}
			,{header: '金额',dataIndex: 'price',width: 220,sortable: true}
			,{header: '报销理由',dataIndex: 'reason',flex: 1,sortable: true}
			,{xtype: 'actioncolumn',cls: 'content-column', width: 120,text: '操作',tooltip: 'edit ',
				items: [
					{xtype: 'button', iconCls: 'x-fa fa-pencil',handler: 'openEditWindow'},
					{xtype: 'button',iconCls: 'x-fa fa-close',handler: 'deleteOneRow'},
					{
		                xtype: 'button',iconCls: 'x-fa fa-star',tooltip: '发起请假',
		                getClass: function(v, meta, rec) {
		                    if (rec.get('processInstanceId')!="") {
		                        return 'x-hidden';
		                    }
		                    return 'x-fa fa-star';
		                },
		                handler: 'startPaymentProcess'
		            },{
		                xtype: 'button',iconCls: 'x-fa fa-ban',tooltip: '取消请假',
		                getClass: function(v, meta, rec) {
		                    if (rec.get('processInstanceId')=="") {
		                        return 'x-hidden';
		                    }
		                    return 'x-fa fa-ban';
		                },
		                handler: 'cancelPaymentProcess'
		            }
				]
			}
		],
		tbar: [{
	            xtype: 'combobox',
	           	reference:'searchFieldName',
	            hideLabel: true,
	            store:Ext.create("Ext.data.Store", {
				    fields: ["name", "value"],
				    data: [
				      	{ name: '状态', value: 'processStatus' },
						{ name: '金额', value: 'price' },
						{ name: '报销理由', value: 'reason' }
				    ]
				}),
	            displayField: 'name',
	            valueField:'value',
	            value:'请选择',
	            editable: false,//不可编辑
	            queryMode: 'local',
	            triggerAction: 'all',
	            emptyText: 'Select a state...',
	            width: 135
	    }, '-',{
			xtype: 'textfield',
			hideLabel: true,
			reference:'searchDataFieldValue',
			fieldLabel: 'From',
			name: 'from_date'
		},'-',{
			text: '查找',
			iconCls: 'fa fa-search',
			handler: 'quickSearch'
		}, '-',{
                text: '清空',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
       }, '->',{
			text: '添加',
			tooltip: 'Add a new row',
			iconCls: 'fa fa-plus',
			handler: 'openAddWindow'	
		},'-',{
			text: '删除',
			tooltip: 'Remove the selected item',
			iconCls:'fa fa-trash',
			itemId: 'paymentGridPanelRemove',
			disabled: true,
			handler: 'deleteMoreRows'	
		}],			
		dockedItems: [{
			xtype: 'pagingtoolbar',
			dock: 'bottom',
			displayInfo: true,
			bind: '{paymentLists}'
		}],
		listeners: {
			selectionchange: function(selModel, selections){
				this.down('#paymentGridPanelRemove').setDisabled(selections.length === 0);
			}
		}		
	}]
});