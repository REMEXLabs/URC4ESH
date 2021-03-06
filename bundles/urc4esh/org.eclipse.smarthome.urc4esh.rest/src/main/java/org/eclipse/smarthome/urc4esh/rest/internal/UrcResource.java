/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.urc4esh.rest.internal;

import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.eclipse.smarthome.core.auth.Role;
import org.eclipse.smarthome.io.rest.RESTResource;
import org.eclipse.smarthome.urc4esh.api.CommunicationManager;
import org.eclipse.smarthome.urc4esh.api.ContextManager;
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

    @Reference
    private ContextManager contextManager;

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
    @Produces(MediaType.APPLICATION_JSON)
    @Path(REST_API.UI_LIST)
    public Response requestUiList() {

        UiList uiList;
        Object responseObject = new String("hello world");
        return Response.ok(responseObject).build();
    }

}