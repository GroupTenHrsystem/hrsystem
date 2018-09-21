Ext.define('Admin.store.process.definition.ProcessDefinitionStroe', {
    extend: 'Ext.data.Store',
    storeId:'processDefinitionStroe',
    alias: 'store.processDefinitionStroe',
    model:'Admin.model.process.definition.ProcessDefinitionModel',
    pageSize: 15,
    data:[{
    "content": [
        {
            "id": "leaveProcess:1:3",
            "category": "http://www.activiti.org/test",
            "name": "Leave Process",
            "key": "leaveProcess",
            "description": null,
            "version": 1,
            "resourceName": "D:\\soft\\workspace-sts\\activiti-springboot\\target\\classes\\processes\\LeaveProcess.bpmn",
            "deploymentId": "1",
            "diagramResourceName": null,
            "tenantId": "",
            "startFormKey": false,
            "graphicalNotation": false,
            "suspended": false
        },
        {
            "id": "leaveProcess:2:6",
            "category": "http://www.activiti.org/test",
            "name": "Leave Process",
            "key": "leaveProcess",
            "description": null,
            "version": 2,
            "resourceName": "processes/LeaveProcess.bpmn",
            "deploymentId": "4",
            "diagramResourceName": null,
            "tenantId": "",
            "startFormKey": false,
            "graphicalNotation": false,
            "suspended": false
        },
        {
            "id": "leaveProcess:3:2503",
            "category": "http://www.activiti.org/test",
            "name": "Leave Process",
            "key": "leaveProcess",
            "description": null,
            "version": 3,
            "resourceName": "processes/LeaveProcess.bpmn",
            "deploymentId": "2501",
            "diagramResourceName": null,
            "tenantId": "",
            "startFormKey": false,
            "graphicalNotation": false,
            "suspended": false
        },
        {
            "id": "leaveProcess:4:7504",
            "category": "http://www.activiti.org/test",
            "name": "Leave Process",
            "key": "leaveProcess",
            "description": null,
            "version": 4,
            "resourceName": "D:\\soft\\workspace-sts\\activiti-springboot\\target\\classes\\processes\\LeaveProcess.bpmn",
            "deploymentId": "7501",
            "diagramResourceName": "D:\\soft\\workspace-sts\\activiti-springboot\\target\\classes\\processes\\LeaveProcess.leaveProcess.png",
            "tenantId": "",
            "startFormKey": false,
            "graphicalNotation": false,
            "suspended": false
        },
        {
            "id": "leaveProcess:5:7508",
            "category": "http://www.activiti.org/test",
            "name": "Leave Process",
            "key": "leaveProcess",
            "description": null,
            "version": 5,
            "resourceName": "processes/LeaveProcess.bpmn",
            "deploymentId": "7505",
            "diagramResourceName": "processes/LeaveProcess.leaveProcess.png",
            "tenantId": "",
            "startFormKey": false,
            "graphicalNotation": false,
            "suspended": false
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "pageSize": 20,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "totalPages": 1,
    "totalElements": 5,
    "last": true,
    "size": 20,
    "number": 0,
    "sort": {
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 5
}
        ],
    proxy: {
        type: 'ajax',
        url: '/process-definition',
        reader : {  
            type : 'json',  
            rootProperty  : 'content',
            totalProperty : 'totalElements'
        }
        ,simpleSortMode: true
    },
    remoteSort: true,
    sorters: [{ property: 'id',direction: 'desc'}],
    autoLoad: true,
    listeners: {}
});
