/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.io.rest.urc.internal;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.eclipse.smarthome.core.auth.Role;
import org.eclipse.smarthome.io.rest.RESTResource;
import org.eclipse.smarthome.urc4esh.api.ContextManager;
import org.eclipse.smarthome.urc4esh.api.contextdefinitions.EnvironmentContextDefinition;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * <p>
 * This class is the central point where all REST endpoints for the URC4ESH API are define
 *
 *
 * @author Lukas Smirek - Initial contribution and API
 *
 *
 */
@Path(UrcResource.PATH_URC)
@RolesAllowed({ Role.USER, Role.ADMIN })
@Api(value = UrcResource.PATH_URC)
public class UrcResource implements RESTResource { // , SitemapSubscriptionCallback, BroadcasterListener<OutboundEvent>
                                                   // {

    private final Logger logger = LoggerFactory.getLogger(UrcResource.class);

    public static final String PATH_URC = "urc";
    private static final String SEGMENT_EVENTS = "events";
    private static final String X_ACCEL_BUFFERING_HEADER = "X-Accel-Buffering";

    private static final long TIMEOUT_IN_MS = 30000;

    @Context
    UriInfo uriInfo;

    @Context
    private HttpServletResponse response;

    @Reference
    private ContextManager contextManager;

    protected void activate() {

        System.out.println("Hello World");
    }

    protected void deactivate() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get all available sitemaps.", response = SitemapDTO.class, responseContainer = "Collection")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
    public Response getSitemaps() {
        logger.debug("Received HTTP GET request at '{}'", uriInfo.getPath());
        Object responseObject = new String("hello world");
        return Response.ok(responseObject).build();
    }

    @GET
    @Path("/{contextId: [a-zA-Z_0-9]*}")
    // @Path(REST_API.USERCONTEXT_WITH_ID)
    @ApiOperation(value = "Get all available sitemaps.", response = SitemapDTO.class, responseContainer = "Collection")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
    public Response getEnvironmentContexts(
            @PathParam("contextId") @ApiParam(value = "context Id", required = true) String contextId) {
        EnvironmentContextDefinition environmentContextDefinition = contextManager
                .getEnvironmentContextDefinition(contextId);
        if (environmentContextDefinition == null) {
            return Response.noContent().build();
        }
        return Response.ok(environmentContextDefinition).build();
    }

}