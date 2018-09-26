package com.hrsystem.activiti.domain;

import javax.persistence.Table;

import lombok.Data;

@Data
public class ProcessDefinitionDTO 
{
	private String id;
	private String category;
	private String name;
	private String key;
	private String description;
	private int    version;
	private String resourceName;
	private String deploymentId;
	private String diagramResourceName;
	private String tenantId;
	private boolean startFormKey;
	private boolean graphicalNotation;
	private boolean suspended;
}
