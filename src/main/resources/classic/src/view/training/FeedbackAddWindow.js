Ext.define('Aria.view.training.FeedbackAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.feedbackAddWindow',
    height: 400,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '反馈表录入',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Enter your name',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '反馈表编号',
            name:'feedbackId',
            allowBlank:false
        }, 
       /* {
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'employeeId'
        }, */
        
        {
            xtype: 'combo',
            allowBlank:false, 
            width:400,
            store: {
                type: 'array',
                fields: [ 'id' ,'courseCode'],
                autoLoad: true, //启动自动加载
                proxy: {
                            type: 'rest',
                            url: '/training/trainingpass',
                            reader:{
                                type:'json',
                                rootProperty:'content',//对应后台返回的结果集名称
                                totalProperty: 'totalElements'//分页需要知道总记录数
                            },
                            writer: {
                                type: 'json',
                            },
                            simpleSortMode: true    //简单排序模式
                    },
                autoSync: true
            },
            mode:'local' ,
            editable: false,
            valueField:'courseCode',
            displayField: 'courseCode', //显示的field
            fieldLabel: '培训',
            anchor: '0',
            queryMode: 'local',
            selectOnTab: false,
            name: 'courseId',
            emptyText:'请选择...',
            allowBlank:false,
            listeners:{
            select:function(combo,record,index){
                    var courseId=record.get('courseCode');
                    //testfunction()//对应的处理函数
                    console.log(courseId);
                    var enroll = Ext.getCmp("courseId");    //获取staff Combo组件
                    enroll.getStore().removeAll(); // 清空已加载列表
                    enroll.reset();    // 清空已存在结果
                    enroll.getStore().load({
                                     params: {'courseId': courseId}
                                });
                }
            },
            onReplicate: function () {
                this.getStore().clearFilter();
            }
        },
        /*
        {
            xtype: 'combo',
            allowBlank:false, 
            width:400,
            store: {
                type: 'array',
                fields: [ 'id' ,'courseId'],
                autoLoad: true, //启动自动加载
                proxy: {
                            type: 'rest',
                            url: '/enroll/enrollpass',
                            reader:{
                                type:'json',
                                rootProperty:'content',//对应后台返回的结果集名称
                                totalProperty: 'totalElements'//分页需要知道总记录数
                            },
                            writer: {
                                type: 'json',
                            },
                            simpleSortMode: true    //简单排序模式
                    },
                autoSync: true
            },
            mode:'local' ,
            editable: false,
            valueField:'courseId',
            displayField: 'courseId', //显示的field
            fieldLabel: '培训编号',
            anchor: '0',
            queryMode: 'local',
            selectOnTab: false,
            name: 'courseId',
            emptyText:'请选择...',
            onReplicate: function () {
                this.getStore().clearFilter();
            }
        },
        
        
        {
            xtype: 'combo',
            store: {
                type: 'array',
                fields: [ 'courseId' ,'courseId'],
                data: [
                    // ['test@example.com','name'],         //假数据
                    // ['someone@example.com','name'],
                    // ['someone-else@example.com','name']
                ],
                autoLoad: true, //启动自动加载
                proxy: {
                            type: 'rest',
                            url: '/enroll/enrollpass',
                            reader:{
                                type:'json',
                                rootProperty:'content',//对应后台返回的结果集名称
                                totalProperty: 'totalElements'//分页需要知道总记录数
                            },
                            writer: {
                                type: 'json',
                            },
                            simpleSortMode: true    //简单排序模式
                    },
                autoSync: true
            },
            mode:'local' ,
            editable: false,
            valueField:'courseId',
            displayField: 'courseId', //显示的field
         //   plugins: 'fieldreplicator',   //选中后追加文本框
            fieldLabel: '选择培训',
            anchor: '0',
            queryMode: 'local',
            selectOnTab: false,
            name: 'courseId',
            emptyText:'请选择...',
            listeners:{
            select:function(combo,record,index){
                    var courseId=record.get('courseId');
                    //testfunction()//对应的处理函数
                    console.log(courseId);
                    var enroll = Ext.getCmp("courseId");    //获取staff Combo组件
                    enroll.getStore().removeAll(); // 清空已加载列表
                    enroll.reset();    // 清空已存在结果
                    enroll.getStore().load({
                                     params: {'courseId': courseId}
                                });
                }
            },
          // blankText: '请选择', // 该项如果没有选择，则提示错误信息,
            onReplicate: function () {
                this.getStore().clearFilter();
            }
        },
		*/
        {
            xtype: 'combo',
            fieldLabel: '选择员工编号',
            id:'courseId',
            store: {
                type: 'array',
                fields: [ 'employeeId' ,'employeeId'],
           //     autoLoad: true, //启动自动加载
                proxy: {
                            type: 'rest',
                            url: '/enroll/enrollfind',
                            reader:{
                                type:'json',
                                rootProperty:'content',//对应后台返回的结果集名称
                                totalProperty: 'totalElements'//分页需要知道总记录数
                            },
                            writer: {
                                type: 'json',
                            },
                            simpleSortMode: true    //简单排序模式
                    },
             //   autoSync: true
            },
            valueField:'employeeId',
            displayField: 'employeeId',
            name:'employeeId',
            filterPickList: true,
            queryMode: 'local',
            allowBlank:false,
            publishes: 'value'
        },
        
        {
            xtype: 'textfield',
            fieldLabel: '培训收获',
            name:'courseHarvest'
        },/* {
            xtype: 'textfield',
            fieldLabel: '培训评价',
            name:'courseEvaluate'
        },*/ {
            xtype: 'numberfield',
            allowBlank:false,
            fieldLabel: '培训评价(0-100)',
            name: 'courseEvaluate',
            minValue: 0,
            maxValue: 100,
            allowDecimals: true,
            decimalPrecision: 2,
            step: 1
        }, {
            xtype: 'textfield',
            fieldLabel: '培训意见',
            name:'courseOpinion'
        }]
    }],
    buttons: ['->',{
	    xtype: 'button',
	    text: '提交',
	    handler: 'submitAddForm'
	},{
	    xtype: 'button',
	    text: '关闭',
	    handler: function(btn) {
	        btn.up('window').close();
	    }
	},'->']

});
