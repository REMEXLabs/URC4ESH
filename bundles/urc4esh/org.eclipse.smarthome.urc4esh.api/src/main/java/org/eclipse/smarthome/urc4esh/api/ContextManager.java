package org.eclipse.smarthome.urc4esh.api;

import org.openape.api.taskcontext.TaskContext;

public interface ContextManager {

    String createEquipmentcontextDefinition(EquipmentContextDefinition equipmentContextDefinition);

    String createEnvironmentContextDefinition(EnvironmentContextDefinition environmentContextDefinition);

    String createTaskContextDefinition(TaskContextDefinition taskContextDefinition);

    EquipmentContextDefinition getEquipmentContextDefinition(String id);

    EnvironmentContextDefinition getEnvironmentContextDefinition(String id);

    TaskContextDefinition getTaskContextDefinition(String id);

    TaskContext createTaskContextFromTaskContextDefinition(String task_context_definition);

}