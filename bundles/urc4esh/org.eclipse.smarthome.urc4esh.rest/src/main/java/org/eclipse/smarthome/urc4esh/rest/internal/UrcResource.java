/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.urc4esh.rest.internal;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.eclipse.smarthome.core.auth.Role;
import org.eclipse.smarthome.core.storage.StorageService;
import org.eclipse.smarthome.io.rest.RESTResource;
import org.eclipse.smarthome.urc4esh.api.CommunicationManager;
import org.eclipse.smarthome.urc4esh.api.ContextManager;
import org.eclipse.smarthome.urc4esh.api.EnvironmentContextDefinition;
import org.eclipse.smarthome.urc4esh.api.EquipmentContextDefinition;
import org.eclipse.smarthome.urc4esh.api.TaskContextDefinition;
import org.eclipse.smarthome.urc4esh.api.UiList;
import org.eclipse.smarthome.urc4esh.rest.REST_API;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * <p>
 * This class is the central point where all REST endpoints for the URC4ESH API are defined
 *
 *
 * @author Lukas Smirek - Initial contribution and API
 *
 *
 */
@Path(UrcResource.PATH_URC)
@RolesAllowed({ Role.USER, Role.ADMIN })
@Api(value = UrcResource.PATH_URC)
public class UrcResource implements RESTResource {

    private final Logger logger = LoggerFactory.getLogger(UrcResource.class);

    public static final String PATH_URC = "urc";
    private static final String SEGMENT_EVENTS = "events";
    private static final String X_ACCEL_BUFFERING_HEADER = "X-Accel-Buffering";

    private static final long TIMEOUT_IN_MS = 30000;

    @Context
    UriInfo uriInfo;

    @Context
    // private HttpServletResponse response;

    StorageService storageService;

    @Reference
    private ContextManager contextManager;
    private CommunicationManager communicationManager;

    public CommunicationManager getCommunicationManager(CommunicationManager communicationManager) {
        this.communicationManager = null;
    }

    public void setCommunicationManager(CommunicationManager communicationManager) {
        this.communicationManager = communicationManager;
    }

    protected void activate() {

        System.out.println("Hello World");
    }

    protected void deactivate() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get all available sitemaps.", response = String.class, responseContainer = "Collection")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
    public Response getHelloWorld() {
        logger.debug("Received HTTP GET request at '{}'", uriInfo.getPath());
        Object responseObject = new String("hello world");
        return Response.ok(responseObject).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(REST_API.UI_LIST)
    public Response requestUiList(UiListRequest uiListRequest, String clientId) {

        UiList uiList;
        communicationManager.requestUiList(uiListRequest, clientId);
        Object responseObject = new String("hello world");
        return Response.ok(responseObject).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(REST_API.ENVIRONMENT_CONTEXT_DEFINITION)
    public Response createEnvironmentContextDefinition(String s) {

        EnvironmentContextDefinition envCtxDef = new EnvironmentContextDefinition();
        String[] ss = { s };
        envCtxDef.setChannelUids(ss);

        String id = contextManager.createEnvironmentContextDefinition(envCtxDef);
        return Response.ok(id).build();
    }

    @GET
    @Path(REST_API.ENVIRONMENT_CONTEXT_DEFINITION)
    public Response test() {
        return Response.ok("envCtx").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(REST_API.EQUIPMENT_CONTEXT_DEFINITION)
    public Response createEquipmentContextDefinition(String[] s) {
        EquipmentContextDefinition equCtxDef = new EquipmentContextDefinition();
        equCtxDef.setChannelUids(s);
        String id = contextManager.createEquipmentcontextDefinition(equCtxDef);
        return Response.ok(id).build();
    }

    @POST
    @Path(REST_API.TASK_CONTEXT_DEFINITIONS)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTaskContextDefinition(String[][] s) {
        TaskContextDefinition taskCtxDef = new TaskContextDefinition();
        taskCtxDef.setDefinitions(s);

        String id = contextManager.createTaskContextDefinition(taskCtxDef);
        return Response.ok(id).build();
    }

    public void setContextManager(ContextManager contextManager) {
        this.contextManager = contextManager;
    }

    public void removeContextManager(ContextManager contextManager) {
        this.contextManager = null;
    }
}