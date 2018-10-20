Ext.define('Admin.view.scheduling.schedulingPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'schedulingPanel',

    requires: [
        'Ext.calendar.panel.Panel',
        'Ext.data.field.Date',
        'Ext.form.field.Time'
    ],

    width: 1100,
    height: 710,

    title: '日程安排',
    iconCls: 'fa fa-calendar',
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
        timezoneOffset: 0
    }]
});