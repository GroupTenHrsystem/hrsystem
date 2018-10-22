Ext.define('Admin.view.email.ReportController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.report',

    init: function() {
        this.setCurrentView('inbox');
    },

    onBackBtnClick: function() {
        this.setCurrentView('inbox');
    },

    onMenuClick: function (menu, item) {
        if (item && item.routeId === 'emailcompose') {
            this.setCurrentView(item.routeId, item.params);
        }
    },

    setCurrentView: function(view, params) {
        var contentPanel = this.getView().down('#contentPanel');

        //We skip rendering for the following scenarios:
        // * There is no contentPanel
        // * view xtype is not specified
        // * current view is the same
        if(!contentPanel || view === '' || (contentPanel.down() && contentPanel.down().xtype === view)){
            return false;
        }

        if (params && params.openWindow) {
            var cfg = Ext.apply({
                xtype: 'emailwindow',
                items: [
                    Ext.apply({
                        xtype: view,
                    }, params.targetCfg)
                ]
            }, params.windowCfg);

            Ext.create(cfg);
        } else {
            Ext.suspendLayouts();

            contentPanel.removeAll(true);
            contentPanel.add(
                Ext.apply({
                    xtype: view
                }, params)
            );

            Ext.resumeLayouts(true);
        }
    },

    onGridCellItemClick: function(view, td, cellIndex, record){
        if(cellIndex > 1){
            console.log(record);
            this.setCurrentView('emaildetails', {record: record});
        } else if (cellIndex === 1) {
            //Invert selection
            record.set('favorite', !record.get('favorite'));
        }
    },

    beforeDetailsRender: function(view) {
        var record = view.record ? view.record : {};
        view.down('#id').setValue(record.data.id);
        view.down('#title').setValue(record.data.title);
        view.down('#time').setValue(record.data.time);
        view.down('#messages').setValue(record.data.messages);
    },
    /*    添加  */
    onSaveBtnClick:function(bt) {
        var form    = bt.up('form');
        if(!form.isValid()){
            Ext.Msg.alert("错误", "请填写正确数据");
        }else{
            var values  =form.getValues();
            var editor = form.down('htmleditor');
            Ext.Ajax.request({ 
                        url : '/report/save', 
                        method : 'post', 
                        params : { 
                            id :values.id,
                            title: values.title,
                            time: values.time,
                            messages: editor.getValue()
                        }, 
                        success: function(response, options) {
                            var json = Ext.util.JSON.decode(response.responseText);
                            if(json.success){
                                Ext.Msg.alert('操作成功', json.msg, function() {
                                    var contentPanel = Ext.getCmp('contentPanel');
                                    var grid = contentPanel.down('grid');
                                    grid.getStore().reload();
                                    //store.reload();
                                });
                            }else{
                                 Ext.Msg.alert('操作失败', json.msg);
                            }
                        }
                    });


          this.onBackBtnClick();
        }
    },
     /*    刷新  */
    onRefuseBtnClick:function(bt) {        
        var form    = bt.up('form');
        var contentPanel = Ext.getCmp('contentPanel');
        var grid = contentPanel.down('grid');
        grid.getStore().reload();
    },
    onDeleteBtnClick:function(bt) {
        var form    = bt.up('form');
        var contentPanel = Ext.getCmp('contentPanel');
        var grid = contentPanel.down('grid');
        var selModel = grid.getSelectionModel();

        if (selModel.hasSelection()) {
            Ext.Msg.confirm("提示", "确定要删除吗？", function (button) {
                if (button == "yes") {
                    var rows = selModel.getSelection();
                    var selectIds = []; //要删除的id
                    Ext.each(rows, function (row) {
                        selectIds.push(row.data.id);
                    });
                    Ext.Ajax.request({ 
                        url : '/report/deletes', 
                        method : 'post', 
                        params : { 
                            //ids[] :selectIds
                            ids :selectIds
                        }, 
                        success: function(response, options) {
                            var json = Ext.util.JSON.decode(response.responseText);
                            if(json.success){
                                Ext.Msg.alert('操作成功', json.msg, function() {
                                    grid.getStore().reload();
                                });
                            }else{
                                 Ext.Msg.alert('操作失败', json.msg);
                            }
                        }
                    });
                }
            });
        }else {
            Ext.Msg.alert("错误", "没有任何行被选中，无法进行删除操作！");
        }
        
    }
});
