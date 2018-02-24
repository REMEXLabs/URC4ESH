package org.eclipse.smarthome.urc4esh.communicationmanager;

public class ClientTest {
    public static void main(String[] args) {
        try {
            // CommunicationManagerImpl.getClient("daniel", "ich");
            new OpenAPEClient("daniel", "ich");
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
