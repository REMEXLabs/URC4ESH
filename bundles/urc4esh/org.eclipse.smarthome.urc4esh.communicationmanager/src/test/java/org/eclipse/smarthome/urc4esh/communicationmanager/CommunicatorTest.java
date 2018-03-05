package org.eclipse.smarthome.urc4esh.communicationmanager;

import org.eclipse.smarthome.urc4esh.api.CommunicationManager;
import org.eclipse.smarthome.urc4esh.api.Communicator;
import org.openape.api.auth.TokenResponse;

public class CommunicatorTest {
    public static void main(String[] args) {
        new TokenResponse();
        System.out.println("bla");
        try {
            CommunicationManager communicationManager = new CommunicationManagerImpl();

            Communicator client = communicationManager.getCommunicator("daniel", "ich");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}