Ext.define('Admin.view.employ.EmployPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'employPanel',

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
            bind: '{employLists}',
            scrollable: false,
            selModel:{type:'checkboxmodel',checkOnly:true},
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'key',hidden:true},
                {header: '简历状态',dataIndex: 'processStatus',width: 60,flex: 1,sortable: true,
                	renderer: function(val) {
                            if (val =='COMPLETE') {
                                return '<span style="color:orange;">二面通过</span>';
                            } else{
                                return '<span style="color:red;">已存档</span>';
                            }
                            return val;
                        }
                },
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'name',text: '姓名',flex: 1},
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
                    	{xtype: 'button',iconCls: 'x-fa fa-search-plus'	,tooltip: '面试详细',handler: 'openshowDetailsWindow'},
            			{xtype: 'button',iconCls: 'x-fa fa-sign-in'	,tooltip: '存档',handler: 'openSaveWindow'}
                    ]
                }
            ],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{employLists}'
            }]
 		}]
});
