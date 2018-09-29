package com.hrsystem.activiti.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.image.ProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrsystem.activiti.util.CustomProcessDiagramGenerator;



@Controller
public class ProcessDiagramController {
	@Autowired
	private ProcessEngineConfiguration processEngineConfiguration;
	
	@Autowired
    private RepositoryService repositoryService;

	@Autowired
	private HistoryService historyService;
	
    //升级到Activiti6.0.0  之后，发现pvm 包整个被删掉了。。。。这样一来就导致之前的跟踪流失效了。代码连编译都通过不了。
    //因为pvm包没了，所以就不能再使用ActivityImpl 等相关类了。只能改成用org.activiti.bpmn.model包下的FlowNode类来替代。好在他们差不多，所以代码改动也不大。下面是完整代码：

	/**
	 * 根据流程实例Id,获取实时流程图片
	 * 
	 * @param processInstanceId
	 * @param outputStream
	 * @return
	 */
	@RequestMapping("/process-trace")
	public  void getFlowImgByInstanceId(String processInstanceId, OutputStream outputStream) {
		try {
			if (processInstanceId != null) {
				// 获取历史流程实例
				HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

				// 获取流程中已经执行的节点，按照执行先后顺序排序
				List<HistoricActivityInstance> historicActivityInstances = historyService
						.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId)
						.orderByHistoricActivityInstanceId().asc().list();

				// 获取需要高亮显示的流程节点
				List<String> highLightedActivitiIds = getHighLightedActivitis(processInstanceId);

				// 获取已完成的历史流程节点
				List<HistoricProcessInstance> historicFinishedProcessInstances = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).finished().list();

				// Activiti生成流程图核心类
				ProcessDiagramGenerator processDiagramGenerator = null;

				// 如果还没完成，流程图高亮颜色为绿色，如果已经完成，流程图高亮颜色为红色
				if (!CollectionUtils.isEmpty(historicFinishedProcessInstances)) {
					// 不为空，说明已经完成
					processDiagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
				} else {
					processDiagramGenerator = new CustomProcessDiagramGenerator();
				}

				// bpmn模型
				BpmnModel bpmnModel = repositoryService.getBpmnModel(historicProcessInstance.getProcessDefinitionId());

				// 获取需要高亮显示的流程连接线集合
				List<String> highLightedFlowIds = getHighLightedFlows(bpmnModel, historicActivityInstances);

				/**
				 * 生成流程图类核心方法: public InputStream generateDiagram(BpmnModel bpmnModel, String
				 * imageType, List<String> highLightedActivities, List<String> highLightedFlows,
				 * StringctivityFontName, String labelFontName, String annotationFontName,
				 * ClassLoader customClassLoader, double scaleFactor);
				 */
				// 使用默认配置获得流程图表生成器，并生成追踪图片字符流
				InputStream imageStream = processDiagramGenerator.generateDiagram(bpmnModel, "png",
						highLightedActivitiIds, highLightedFlowIds, "宋体", "宋体", "宋体", null, 2.0);

				// 输出图片内容
				byte[] b = new byte[1024];
				int len = -1;
				while ((len = imageStream.read(b, 0, 1024)) != -1) {
					outputStream.write(b, 0, len);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取需要高亮显示的执行流程节点集合
	 * 
	 * @param processInstanceId
	 * @return
	 */
	public  List<String> getHighLightedActivitis(String processInstanceId) {
		// 获取流程中已经执行的节点，按照执行先后顺序排序
		List<HistoricActivityInstance> historicActivityInstances = historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId)
				.orderByHistoricActivityInstanceId().asc().list();
		// 高亮已经执行流程节点ID集合
		List<String> highLightedActivitiIds = new ArrayList<>();
		for (HistoricActivityInstance historicActivityInstance : historicActivityInstances) {
			highLightedActivitiIds.add(historicActivityInstance.getActivityId());
		}
		return highLightedActivitiIds;
	}

	/**
	 * 获取需要高亮显示的流程连接线集合
	 * 
	 * @param bpmnModel
	 * @param historicActivityInstances
	 * @return
	 */
	public  List<String> getHighLightedFlows(BpmnModel bpmnModel,
			List<HistoricActivityInstance> historicActivityInstances) {
		// 需要高亮的流程连接线的id集合
		List<String> highLightedFlowIds = new ArrayList<>();

		// 全部历史活动节点
		List<FlowNode> historicActivityNodes = new ArrayList<>();

		// 已完成的历史活动节点
		List<HistoricActivityInstance> finishedActivityInstances = new ArrayList<>();

		for (HistoricActivityInstance historicActivityInstance : historicActivityInstances) {
			FlowNode flowNode = (FlowNode) bpmnModel.getMainProcess()
					.getFlowElement(historicActivityInstance.getActivityId(), true);
			historicActivityNodes.add(flowNode);
			if (historicActivityInstance.getEndTime() != null) {
				finishedActivityInstances.add(historicActivityInstance);
			}
		}

		FlowNode currentFlowNode = null;
		FlowNode targetFlowNode = null;
		// 遍历已完成的活动实例，从每个实例的outgoingFlows中找到已执行的
		for (HistoricActivityInstance currentActivityInstance : finishedActivityInstances) {
			// 获得当前活动对应的节点信息及outgoingFlows信息
			currentFlowNode = (FlowNode) bpmnModel.getMainProcess()
					.getFlowElement(currentActivityInstance.getActivityId(), true);
			List<SequenceFlow> sequenceFlows = currentFlowNode.getOutgoingFlows();

			/**
			 * 遍历outgoingFlows并找到已流转的，满足如下条件认为已流转：
			 * 1.当前节点是并行网关或兼容网关，则通过outgoingFlows能够在历史活动中找到的全部节点均为已流转
			 * 2.当前节点是以上两种类型之外的，则通过outgoingFlows查找到的时间最早的流转节点视为有效流转
			 */
			if ("parallelGateway".equals(currentActivityInstance.getActivityType())
					|| "inclusiveGateway".equals(currentActivityInstance.getActivityType())) {
				// 遍历历史活动节点，找到匹配流程目标节点的
				for (SequenceFlow sequenceFlow : sequenceFlows) {
					targetFlowNode = (FlowNode) bpmnModel.getMainProcess().getFlowElement(sequenceFlow.getTargetRef(),
							true);
					if (historicActivityNodes.contains(targetFlowNode)) {
						highLightedFlowIds.add(targetFlowNode.getId());
					}
				}
			} else {
				List<Map<String, Object>> tempMapList = new ArrayList<>();
				for (SequenceFlow sequenceFlow : sequenceFlows) {
					for (HistoricActivityInstance historicActivityInstance : historicActivityInstances) {
						if (historicActivityInstance.getActivityId().equals(sequenceFlow.getTargetRef())) {
							Map<String, Object> map = new HashMap<>();
							map.put("highLightedFlowId", sequenceFlow.getId());
							map.put("highLightedFlowStartTime", historicActivityInstance.getStartTime().getTime());
							tempMapList.add(map);
						}
					}
				}

				if (!CollectionUtils.isEmpty(tempMapList)) {
					// 遍历匹配的集合，取得开始时间最早的一个
					long earliestStamp = 0L;
					String highLightedFlowId = null;
					for (Map<String, Object> map : tempMapList) {
						long highLightedFlowStartTime = Long.valueOf(map.get("highLightedFlowStartTime").toString());
						if (earliestStamp == 0 || earliestStamp >= highLightedFlowStartTime) {
							highLightedFlowId = map.get("highLightedFlowId").toString();
							earliestStamp = highLightedFlowStartTime;
						}
					}
					highLightedFlowIds.add(highLightedFlowId);
				}
			}
		}
		return highLightedFlowIds;
	}
}
