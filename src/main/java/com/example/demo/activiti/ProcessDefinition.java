package com.example.demo.activiti;

public interface ProcessDefinition {
	  String getId();
	  String getCategory();
	  String getName();
	  String getKey();
	  String getDescription();
	  int getVersion();
	  String getResourceName();
	  String getDeploymentId();
	  String getDiagramResourceName();
	  boolean hasStartFormKey();
	  boolean hasGraphicalNotation();
	  boolean isSuspended();
	  String getTenantId();
	  String getEngineVersion();
}
