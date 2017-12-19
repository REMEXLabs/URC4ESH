package org.eclipse.smarthome.urc4esh.api;

public interface ContextManager {

	String createEquipmentcontextDefinition(EquipmentContextDefinition equipmentContextDefinition);

	String createEnvironmentContextDefinition(EnvironmentContextDefinition environmentContextDefinition);

	String createTaskContextDefinition(TaskContextDefinition taskContextDefinition);

	EquipmentContextDefinition getEquipmentContextDefinition(String id);

	EnvironmentContextDefinition getEnvironmentContextDEfinition(String id);

	TaskContextDefinition getTaskContextDefinition(String id);

}