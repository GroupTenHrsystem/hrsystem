Ext.define('Admin.view.resume.ResumePanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'resumePanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.grid.column.Date',
        'Ext.form.field.Date',
        'Ext.selection.CheckboxModel'
    ],
    layout: 'fit',
    items: [{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: '简历管理',
            bind: '{resumeLists}',
            scrollable: false,
            selModel:{type:'checkboxmodel',checkOnly:true},
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'key',hidden:true},
                {header: '简历状态',dataIndex: 'processStatus',flex: 1,sortable: true,
                	renderer: function(val) {
                            if (val =='NEW') {
		            return '<span style="color:green;">新建</span>';
		        } else if (val =='COMPLETE') {
		            return '<span style="color:orange;">二面通过</span>';
		        }else if (val =='FIRSTPASS') {
		            return '<span style="color:orange;">一面通过,等待二面安排中..</span>';
		        }else if (val =='PENFAIL') {
		            return '<span style="color:orange;">笔试未通过</span>';
		        }else if (val =='FIRSTAIL') {
		            return '<span style="color:orange;">一面失败</span>';
		        } else if (val =='LASTFAIL') {
		            return '<span style="color:orange;">二面失败</span>';
		        } else if (val =='FIRSTARRANGE') {
		            return '<span style="color:orange;">一面已安排，一面结果审批中..</span>';
		        }else if (val =='LASTARRANGE') {
		            return '<span style="color:orange;">二面已安排，二面结果审批中..</span>';
		        }else if (val =='APPROVAL') {
		            return '<span style="color:blue;">审批中...</span>';
		        } else if (val =='ONFILE') {
		            return '<span style="color:red;">已存档</span>';
		        }else{
		        	return '<span style="color:red;">取消申请</span>';
		        }
		        return val;
                        }
                },
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'name',text: '姓名'},
                {xtype: 'gridcolumn',width: 100,cls: 'content-column',dataIndex: 'sex',text: '性别'},
                {xtype: 'datecolumn',width:100,cls: 'content-column',dataIndex: 'birthday',text: '出生日期'},
                {xtype: 'gridcolumn',width: 40,cls: 'content-column',dataIndex: 'nativePlace',text: '籍贯',hidden:true},
                {xtype: 'gridcolumn',width: 100,cls: 'content-column',dataIndex: 'major',text: '专业'},
                {xtype: 'gridcolumn',width: 40,cls: 'content-column',dataIndex: 'politicsStatus',text: '政治面貌',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'graduateSchool',text: '毕业学校',hidden:true},
                {xtype: 'gridcolumn',width: 150,cls: 'content-column',dataIndex: 'email',text: '邮箱',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'phone',text: '联系方式',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employBranch',text: '应聘职位'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'experience',text: '工作经历',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'selfEvaluation',text: '自我评价',hidden:true},
                {xtype: 'booleancolumn',cls: 'content-column',dataIndex: 'ifrefer',text: '是否推荐'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'referer',text: '推荐人',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'attachment',text: '附件',hidden:true},
                {xtype: 'datecolumn',cls: 'content-column',width:200,dataIndex: 'applyTime',text: '应聘时间',hidden:true},
                {xtype: 'actioncolumn',cls: 'content-column', width: 160,dataIndex: 'bool',text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,tooltip: '简历修改',handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close'	,tooltip: '删除',handler: 'deleteOneRow'},
                        {
			                xtype: 'button',iconCls: 'x-fa fa-star',tooltip: '发起笔试录入',
			                getClass: function(v, meta, rec) {
			                    if (rec.get('processInstanceId')!="") {
			                        return 'x-hidden';
			                    }
			                    return 'x-fa fa-star';
			                },
			                handler: 'startResumeProcess'
			            },{
			                xtype: 'button',iconCls: 'x-fa fa-ban',tooltip: '取消笔试面试流程',
			                getClass: function(v, meta, rec) {
			                    if (rec.get('processInstanceId')=="") {
			                        return 'x-hidden';
			                    }
			                    return 'x-fa fa-ban';
			                },
			                handler: 'cancelResumeProcess'
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
				      	{ name: '姓名', value: 'name' },
						{ name: '专业', value: 'major' },
						{ name: '政治面貌', value: 'politicsStatus' },
						{ name: '简历状态', value: 'processStatus' },
				    ]
				}),
	            displayField: 'name',
	            valueField:'value',
	            value:'name',
	            editable: false,//不可编辑
	            queryMode: 'local',
	            triggerAction: 'all',
	            emptyText: 'Select a state...',
	            width: 135
	        }, '-',{
            	xtype:'textfield',
            	reference:'searchFieldValue',
            	name:'resumePanelSearchField'
		    },'-',{
		        text: 'Search',
		        iconCls: 'fa fa-search',
		        handler:'quickSearch'
			}, '->',{
		        text: '新增',
		        tooltip: 'Add a new row',
		        iconCls: 'fa fa-plus',
				handler: 'openAddWindow'	
		    },'-',{
		        text: 'Removes',
		        tooltip: 'Remove the selected item',
		        iconCls:'fa fa-trash',
		       	handler:'deleteMoreRows',
		        itemId:'resumeGridPanelRemove',
		        disabled: true
		    }],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{resumeLists}'
            }],
            listeners:{
	          selectionchange:function(selModel,selections){
					this.down('#resumeGridPanelRemove').setDisabled(selections.length === 0);}
	          }
        	}]
});
