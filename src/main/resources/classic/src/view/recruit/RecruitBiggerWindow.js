Ext.define('Aria.view.recruit.RecruitBiggerWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.recruitBiggerWindow',
	height: 600,
    minHeight: 100,
    minWidth: 300,
    width: 450,
    scrollable: true,
    title: '招聘发布',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    border:false,
    items: [{
        xtype: 'form',
        padding: '10px',
        ariaLabel: 'Enter your name',
        columnWidth:0.5,
        items: [{
        	xtype:'textfield',
        	value:'汇IT招聘公告',
        	cls:'x-form-textfield-noborder',
	        readOnly: true,
	        margin:'0 150 0 100'
	    }, {
        	xtype: 'textfield',
	        fieldLabel: '部门名称',
	        name:'departmentName',
			cls:'x-form-textfield-noborder',
			labelWidth:70,
			margin:'5 0 0 0',
	        labelAlign:'right',
			readOnly: true
	    }, {
	        xtype: 'textfield',
	        fieldLabel: '职&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp位',
	        name:'position',
	        cls:'x-form-textfield-noborder',
	        labelWidth:70,
	        margin:'5 0 0 0',
	        labelAlign:'right',
	        readOnly: true
	    }, {
	        xtype: 'textfield',
	        fieldLabel: '计划人数',
	        name:'planNum',
	        cls:'x-form-textfield-noborder',
	        labelWidth:70,
	        margin:'5 0 0 0',
	        labelAlign:'right',
	        readOnly: true
	    }, {
	        xtype: 'textfield',
	        fieldLabel: '薪&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp资',
	        name:'salary',
	        cls:'x-form-textfield-noborder',
	        labelWidth:70,
	        margin:'5 0 0 0',
	        labelAlign:'right',
	        readOnly: true
	    }, {
	        xtype: 'datefield',
	        fieldLabel: '开始时间',
	        name:'startTime',
	        cls:'x-form-textfield-noborder',
	        labelWidth:70,
	        margin:'5 0 0 0',
	        labelAlign:'right',
	        readOnly: true
	    }, {
	        xtype: 'datefield',
	        fieldLabel: '截止时间',
	        name:'endTime',
	        margin:'5 0 0 0',
	        labelWidth:70,
	        labelAlign:'right',
	        cls:'x-form-textfield-noborder',
	        readOnly: true
	    }, {
	    	xtype: 'textfield',
	        fieldLabel: '联系方式',
	        name:'contact',
	        labelWidth:70,
	        margin:'5 0 0 0',
	        labelAlign:'right',
	        anchor:'100%',
	        cls:'x-form-textfield-noborder',
	        readOnly: true
	    }, {
	        xtype: 'textfield',
	        fieldLabel: '职位描述',
	        name:'postdesc',
	        margin:'5 0 0 0',
	        labelWidth:70,
	        anchor:'100%',
	        labelAlign:'right',
	        cls:'x-form-textfield-noborder',
	        readOnly: true
	    }, {
	        xtype: 'textarea',
	        fieldLabel: '要&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp求',
	        name:'demand',
	        labelWidth:70,
	        margin:'5 0 0 0',
	        labelAlign:'right',
	        anchor:'100%',
	        cls:'x-form-textfield-noborder',
	        readOnly: true
	    }, {
        	xtype:'textfield',
        	value:'汇IT人力资源招聘部',
        	cls:'x-form-textfield-noborder',
	        readOnly: true,
	        margin:'20 0 0 200'
        }]
    }],
   
    buttons: ['->',{
	    xtype: 'button',
	    text: 'print',
	    handler: 'printInfo'
	},{
	    xtype: 'button',
	    text: 'Close',
	    handler: function(btn) {
	        btn.up('window').close();
   		 }
	},'->']
});
