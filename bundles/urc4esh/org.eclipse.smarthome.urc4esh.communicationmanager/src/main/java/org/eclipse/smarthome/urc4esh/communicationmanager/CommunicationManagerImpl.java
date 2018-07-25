package org.eclipse.smarthome.urc4esh.communicationmanager;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.smarthome.urc4esh.api.CommunicationManager;
import org.eclipse.smarthome.urc4esh.api.Communicator;
import org.eclipse.smarthome.urc4esh.api.ContextManager;
import org.eclipse.smarthome.urc4esh.api.UiDescriptor;
import org.eclipse.smarthome.urc4esh.api.UiList;
import org.eclipse.smarthome.urc4esh.api.UiListRequest;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommunicationManagerImpl implements CommunicationManager {
    Logger logger = LoggerFactory.getLogger(CommunicationManagerImpl.class);

    ContextManager contextManager;

    private Map<String, Communicator> clientMap;

    @Override
    public Communicator getCommunicator(String username, String password) {
        logger.info("lusm: Request Communicator");

        Communicator client = null;
        try {

            if (username.equals("test")) {
                client = new FaceClient();
            } else {
                client = new OpenAPECommunicator(username, password);
            }
            clientMap.put(username, client);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return client;
    }

    @Override
    public UiList requestUiList(UiListRequest uiListRequest, String clientId) {
        if (clientId.equals("test")) {
            UiList uiList = new UiList();
            UiDescriptor ui1 = new UiDescriptor();
            ui1.setTitel("Picto Wether Service");
            ui1.setDescription("This wether app shows you the wether forcast for your naighbourhood by using pictures");
            ui1.setType("App");
            UiDescriptor ui2 = new UiDescriptor();
            ui2.setTitel("Roller shutter control");
            ui2.setDescription(
                    "This rule controls your roller shutters and takes the current time and wether situation into account");
            ui2.setType("rule");

            UiList.addUi(ui1);
            UiList.addUi(ui2);
            return uiList;
        } else {
            Communicator client = clientMap.get(clientId);
            TaskContext taskCtx = contextManager
                    .createTaskContextFromTaskContextDefinition(uiListRequest.getTask_context_definition());
            return null;
        }
    }

    public void setContextManager(ContextManager contextManager) {
        this.contextManager = contextManager;
    }

    public void removeContextManager(ContextManager contextManager) {
        this.contextManager = null;
    }

    protected void activate(ComponentContext context) {
        clientMap = new HashMap<String, Communicator>();
    }
}