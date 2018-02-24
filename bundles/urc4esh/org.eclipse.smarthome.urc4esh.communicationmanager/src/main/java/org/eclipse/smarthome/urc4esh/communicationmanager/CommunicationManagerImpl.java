package org.eclipse.smarthome.urc4esh.communicationmanager;

import java.net.MalformedURLException;

import org.eclipse.smarthome.urc4esh.api.CommunicationManager;

//@Component(service = org.eclipse.smarthome.urc4esh.api.CommunicationManager.class)
public class CommunicationManagerImpl implements CommunicationManager {

    public static OpenAPEClient getClient(String username, String password) throws MalformedURLException {

        return new OpenAPEClient(username, password);
    }

}
