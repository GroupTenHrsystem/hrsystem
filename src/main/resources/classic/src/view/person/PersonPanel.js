Ext.define('Admin.view.person.PersonPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'personPanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.form.field.Date',
        'Ext.grid.column.Date'
    ],
    //controller: 'searchresults',
   // viewModel: {type: 'orderViewModel'},
    layout: 'fit',
   width: 350,
    

            items: [{
            xtype: 'container',
            layout: 'hbox',
            defaultType: 'textfield',
            margin: '0 0 5 0',
            {
                xtype: 'propertygrid',
                nameColumnWidth: 165,
                source: {
                    employeNum:  1,
                    staffName: 1,
                    sex: 1,
                    idcard:1,
                    email: 1,
                    phone: 1,
                    password: 1,
                    address: 1,
                    nativePlace: 1,
                    status: 1,
                    createTimeStart: 1,
                    createTimeEnd:1,
                    birthday: 1
                },
                sourceConfig: {
                    borderWidth: {
                        displayName: 'Border Width'
                    },
                    tested: {
                        displayName: 'QA'
                    }
                }
            }
        }]   

});
        //     items: [{
        //         fieldLabel: 'Employe Num',
        //         name: 'employeNum',
        //         labelWidth: 110,
        //         flex: 1,
        //     }, {
        //         fieldLabel: 'Staff Name',
        //         name: 'staffName',
        //         labelWidth: 100,
        //         width: 220,
        //     }]
        // },{
        //     xtype: 'propertygrid',
        //     layout: 'hbox',
        //     defaultType: 'textfield',
        //     margin: '0 0 5 0',
        //     items: [{
        //         fieldLabel: 'Sex',
        //         name: 'sex',
        //         labelWidth: 110,
        //         flex: 1,
        //     }, {
        //         fieldLabel: 'Phone',
        //         name: 'phone',

        //         labelWidth: 100,
        //         width: 220,
        //     }]
        // },{
        //     xtype: 'container',
        //     layout: 'hbox',
        //     defaultType: 'textfield',
        //     margin: '0 0 5 0',

        //     items: [{
        //         fieldLabel: 'Idcard',
        //         name: 'idcard',

        //         labelWidth: 100,
        //         width: 220,
        //     }]
        // },{
        //     xtype: 'container',
        //     layout: 'hbox',
        //     defaultType: 'textfield',
        //     margin: '0 0 5 0',

        //     items: [{
        //         fieldLabel: 'Password',
        //         name: 'password',

        //         labelWidth: 100,
        //         width: 220,
        //     }]
        // },{
        //     xtype: 'container',
        //     layout: 'hbox',
        //     defaultType: 'textfield',
        //     margin: '0 0 5 0',

        //     items: [{
        //         fieldLabel: 'Birthday',
        //         name: 'birthday',
        //         labelWidth: 100,
        //         width: 220,
        //     }]
        // },{
        //     xtype: 'container',
        //     layout: 'hbox',
        //     defaultType: 'textfield',
        //     margin: '0 0 5 0',

        //     items: [ {
        //         fieldLabel: 'Address',
        //         name: 'address',
        //         labelWidth: 100,
        //         width: 220,
        //     }]
        // },{
        //     xtype: 'container',
        //     layout: 'hbox',
        //     defaultType: 'textfield',
        //     margin: '0 0 5 0',

        //     items: [{
        //         fieldLabel: 'Native Place',
        //         name: 'nativePlace',
        //         labelWidth: 100,
        //         width: 220,
        //     }]
        // },{
        //     xtype: 'container',
        //     layout: 'hbox',
        //     defaultType: 'textfield',
        //     margin: '0 0 5 0',

        //     items: [{
        //         fieldLabel: 'Create Time Start',
        //         name: 'createTimeStart',
        //         labelWidth: 110,
        //         flex: 1,
        //     }, {
        //         fieldLabel: 'Create Time End',
        //         name: 'createTimeEnd',
        //         labelWidth: 100,
        //         width: 220,
        //     }]
        // },{
        //     xtype: 'container',
        //     layout: 'hbox',
        //     defaultType: 'textfield',
        //     margin: '0 0 5 0',

        //     items: [{
        //         fieldLabel: 'Status',
        //         name: 'status',
        //         labelWidth: 110,
        //         flex: 1,
        //     }]
        // }]
        			
//         }]   
//         })
//     }
// });
