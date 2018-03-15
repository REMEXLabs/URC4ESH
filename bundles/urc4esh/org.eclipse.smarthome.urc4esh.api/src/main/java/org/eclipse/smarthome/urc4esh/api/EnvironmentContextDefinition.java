package org.eclipse.smarthome.urc4esh.api;

public class EnvironmentContextDefinition implements ContextDefinition {
    private String[] channelUids;

    public String[] getChannelUids() {
        return channelUids;
    }

    public void setChannelUids(String[] channelUids) {
        this.channelUids = channelUids;
    }

}
