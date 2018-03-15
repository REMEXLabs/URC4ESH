package org.eclipse.smarthome.urc4esh.contextmanager.internal;

import java.util.HashMap;

import org.eclipse.smarthome.urc4esh.api.ContextDefinition;
import org.eclipse.smarthome.urc4esh.api.ContextManager;
import org.eclipse.smarthome.urc4esh.api.EnvironmentContextDefinition;
import org.eclipse.smarthome.urc4esh.api.EquipmentContextDefinition;
import org.eclipse.smarthome.urc4esh.api.TaskContextDefinition;
import org.openape.api.environmentcontext.EnvironmentContext;

public class ContextManagerImpl implements ContextManager {

    static HashMap<String, ContextDefinition> equCtxDef = new HashMap<>();

    static HashMap<String, ContextDefinition> envCtxDefMap = new HashMap<String, ContextDefinition>();

    static HashMap<String, ContextDefinition> taskDefMap = new HashMap<String, ContextDefinition>();

    static long lastId;

    @Override
    public String createEnvironmentContextDefinition(EnvironmentContextDefinition environmentContextDefinition) {
        return addContextDefinition(envCtxDefMap, environmentContextDefinition);
    }

    @Override
    public String createEquipmentcontextDefinition(EquipmentContextDefinition equipmentContextDefinition) {
        return addContextDefinition(equCtxDef, equipmentContextDefinition);
    }

    @Override
    public String createTaskContextDefinition(TaskContextDefinition taskContextDefinition) {
        return addContextDefinition(taskDefMap, taskContextDefinition);
    }

    private String addContextDefinition(HashMap<String, ContextDefinition> ctxDefMap, ContextDefinition ctx) {
        String id = getId();
        ctxDefMap.put(id, ctx);
        return id;
    }

    private String getId() {
        long id = System.currentTimeMillis();
        if (id == lastId) {
            return getId();
        }
        return "" + id;
    }

    @Override
    public EquipmentContextDefinition getEquipmentContextDefinition(String id) {
        return (EquipmentContextDefinition) equCtxDef.get(id);
    }

    @Override
    public EnvironmentContextDefinition getEnvironmentContextDEfinition(String id) {
        return (EnvironmentContextDefinition) envCtxDefMap.get(id);
    }

    @Override
    public TaskContextDefinition getTaskContextDefinition(String id) {
        return (TaskContextDefinition) taskDefMap.get(id);
    }

    public EnvironmentContext getEnvCtxFromDefintion(String Id) {
        EnvironmentContext envCtx = new EnvironmentContext();
        for (String key : envCtxDefMap.keySet()) {

        }
        return envCtx;

    }

}