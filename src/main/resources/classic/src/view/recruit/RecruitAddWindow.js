Ext.define('Aria.view.recruit.RecruitAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.recruitAddWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Add recruit Window',
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
            name:'recruitId',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: 'department Name',
            name:'departmentname'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: 'Position',
		    name:'position'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: 'Plan Num',
		    name:'planNum'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: 'Salary',
		    name:'salary'
		}, {
            xtype: 'datefield',
            fieldLabel: 'Start Time',
            name:'startTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: 'End Time',
            name:'endTime',
            format: 'Y/m/d H:i:s'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: 'editName',
		    name:'editName'
    	}, {
		    xtype: 'textfield',
		    fieldLabel: 'postdesc',
		    name:'postdesc'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Demand',
            name:'demand'
        }]
    }],

	buttons: ['->',{
	    xtype: 'button',
	    text: 'Submit',
	    handler: 'submitAddForm'
	},{
	    xtype: 'button',
	    text: 'Close',
	    handler: function(btn) {
	        btn.up('window').close();
   		 }
	},'->']
});
