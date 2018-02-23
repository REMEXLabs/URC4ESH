package org.eclipse.smarthome.urc4esh.communicationmanager;

import org.eclipse.smarthome.urc4esh.api.CommunicationManager;
import org.openape.client.OpenAPEClient;

public class CommunicationManagerImpl implements CommunicationManager {

    public static OpenAPEClient getClient(String username, String password) {
        return new OpenAPEClient(username, password);
    }

}
