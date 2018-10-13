Ext.define('Admin.view.performanceApprove.PerformanceApproveDetailWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.performanceApproveDetailWindow',
    y:50,
    resizable : false,
    minWidth: 520,
    maxWidth: 520,
    width: 520,
    scrollable: true,
    title: '绩效详情',
    width: 600,
    bodyPadding: 10,
    defaults: {
        anchor: '100%',
        labelWidth: 100
    },
    items: [{
        xtype: 'form',
        ariaLabel: 'Enter your name',
        // height: 600,
        // minHeight: 600,
        // maxHeight: 600,
       
    items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'displayfield',
            fieldLabel: '自评分数',
            name:'selfScore',
            readOnly: true
        }, {
            xtype: 'displayfield',
            fieldLabel: '领导评分',
            name:'deptLeaderScore'
        },{
            xtype: 'displayfield',
            fieldLabel: '最终分数',
            name:'resultScore'
        }, {
            xtype: 'displayfield',
            fieldLabel: '自评细节',
            name:'selfScoreReason'
        }, {
            xtype: 'displayfield',
            fieldLabel: '领导评分细节',
            name:'deptLeaderScoreReason'
        }, {
            xtype: 'displayfield',
            fieldLabel: '申诉理由',
            name:'confirmResult'
        }]
    }]
});
