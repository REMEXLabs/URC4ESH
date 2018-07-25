package org.eclipse.smarthome.urc4esh.api;

public class UiListRequest {
    private String environment_context_definition;

    public String getEnvironment_context_definition() {
        return environment_context_definition;
    }

    public void setEnvironment_context_definition(String environment_context_definition) {
        this.environment_context_definition = environment_context_definition;
    }

    private String equipment_context_definition;
    private String task_context_definition;

    public String getTask_context_definition() {
        return task_context_definition;
    }

    public void setTask_context_definition(String task_context_definition) {
        this.task_context_definition = task_context_definition;
    }
}
