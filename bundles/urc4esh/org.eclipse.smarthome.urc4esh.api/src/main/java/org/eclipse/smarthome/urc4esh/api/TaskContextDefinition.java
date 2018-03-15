package org.eclipse.smarthome.urc4esh.api;

public class TaskContextDefinition implements ContextDefinition {
    private String[][] definitions;

    public String[][] getDefinitions() {
        return definitions;
    }

    public void setDefinitions(String[][] definitions) {
        this.definitions = definitions;
    }

}
