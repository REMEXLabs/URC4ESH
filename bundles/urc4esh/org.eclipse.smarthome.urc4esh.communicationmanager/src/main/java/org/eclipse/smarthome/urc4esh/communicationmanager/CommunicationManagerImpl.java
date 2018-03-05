package org.eclipse.smarthome.urc4esh.communicationmanager;

import java.net.MalformedURLException;

import org.eclipse.smarthome.urc4esh.api.CommunicationManager;
import org.eclipse.smarthome.urc4esh.api.Communicator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommunicationManagerImpl implements CommunicationManager {
    Logger logger = LoggerFactory.getLogger(CommunicationManagerImpl.class);

    @Override
    public Communicator getCommunicator(String username, String password) {
        logger.info("lusm: Request Communicator");

        try {

            if (username.equals("test")) {
                return new FaceClient();
            } else {
                return new OpenAPECommunicator(username, password);
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

}
