Ext.define('Admin.view.scheduling.schedulingPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'schedulingPanel',

    requires: [
        'Ext.calendar.panel.Panel',
        'Ext.data.field.Date',
        'Ext.form.field.Time'
    ],

    width: 1200,
    height: 600,

  viewModel: {
        data: {
            value: new Date()
        },
        stores: {
            calStore: {
                type: 'calendar-calendars',
                autoLoad: true,
                proxy: {
                    type: 'ajax',
                    url: '../calendar/findCalendars',
                    reader: {
                        type: 'json',
                        rootProperty: 'lists'
                    }
                },
                eventStoreDefaults: {
                    proxy: {
                        type: 'ajax',
                        url:'../calendar/findEvents',
                        reader: {
                            type: 'json',
                            rootProperty: 'lists'
                        }
                    }
                }
            }
        }
    },

    layout: 'fit',
    items: [{
        xtype: 'calendar',
        views: {
            day: {
                startTime: 6,
                endTime: 22
            },
            workweek: {
                xtype: 'calendar-week',
                titleTpl: '{start:date("j M")} - {end:date("j M")}',
                label: 'Work Week',
                weight: 15,
                dayHeaderFormat: 'D d',
                firstDayOfWeek: 1,
                visibleDays: 5
            }
        },
        touchAction: {
        panX: true
    },
     bind: {
            value: '{value}',
            store: '{calStore}'
        },
        listeners: {
           eventadd: function(view, context) {
                    console.log('Event ' + context.event.data.title+ ' was added');
                   alter('Event');
                    //Ext.Ajax.request({url: '/add'});
            },
            eventedit:function(view, context) {//更新无法监听?
                     console.log('Event ' + context.event.data.id+ ' was updated');
                     alter('Event');
            },
            eventdrop: function(view, context) {
                console.log("Event "+context.event.data.id + ' was delete');
                alter('Event');
                //Ext.Ajax.request({url: '/delete'});
            }
        },
        timezoneOffset: 0,
        store: {
            // autoLoad: true,
            // proxy: {
            //     type: 'ajax',
            //     url: '/KitchenSink/CalendarFull'
            // }
        }
    }]
});