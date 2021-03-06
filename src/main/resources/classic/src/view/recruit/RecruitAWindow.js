﻿Ext.define('Aria.view.recruit.RecruitAWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.recruitAWindow',
    x:50,
    y:100,
    height: 650,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '招聘发布',
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
        	xtype: 'combobox',
        	//	xtype: 'treepicker',
            allowBlank:false, 
            name:'departmentName',
            displayField: 'departmentName',
            autoScroll:true,
            scrollable: true,
            width:400,
            minPickerHeight: 400,
            fieldLabel: '选择部门',
            flex: 1,
            //必须这样创建store
            store:Ext.create("Ext.data.TreeStore",{
                    fields: ['id','departmentName'],
                    root: {
                        departmentName: '请选择部门',
                        id:'-1',
                        expanded: true
                    },
                    rootVisible: false,
                    proxy: {
                        type: 'ajax',
                        url: '/department/findNoParent',
                        reader: {
                            type: 'json'
                        }
                    }
                })
            /*xtype: 'combo',
            allowBlank:false, 
            width:400,
            store: {
                type: 'array',
                fields: [ 'id' ,'departmentName'],
                autoLoad: true, //启动自动加载
                proxy: {
                            type: 'rest',
                            url: '/department/department',
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
            valueField:'departmentName',
            displayField: 'departmentName', //显示的field
            fieldLabel: '部门名称',
            anchor: '0',
            queryMode: 'local',
            selectOnTab: false,
            name: 'departmentName',
            emptyText:'请选择...',
            onReplicate: function () {
                this.getStore().clearFilter();
            }*/
        }, {
		    xtype: 'textfield',
		    fieldLabel: '职位',
		    name:'position',
		    allowBlank:false
    	}, {
		    xtype: 'textfield',
		    fieldLabel: '计划人数',
		    name:'planNum',
		   	allowBlank:false
    	}, {
		    xtype: 'textfield',
		    fieldLabel: '薪资',
		    name:'salary'
		}, {
            xtype: 'datefield',
            fieldLabel: '开始时间',
            name:'startTime',
            format: 'Y/m/d'
        }, {
            xtype: 'datefield',
            fieldLabel: '截止时间',
            name:'endTime',
            format: 'Y/m/d'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: '发布人',
		    name:'editName'
    	}, {
    		xtype: 'textfield',
		    fieldLabel: '联系方式',
		    name:'contact'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: '职位描述',
		    name:'postdesc'
        }, {
            xtype: 'textfield',
            fieldLabel: '要求',
            name:'demand'
        }]
    }],

	buttons: ['->',{
	    xtype: 'button',
	    text: '提交',
	    handler: 'submitAddForm'
	},{
	    xtype: 'button',
	    text: '取消',
	    handler: function(btn) {
	        btn.up('window').close();
   		 }
	},'->']
});
