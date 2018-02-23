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
import org.openape.client.OpenAPEClient;
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
@Path(Urc4eshService.PATH_URC)
@RolesAllowed({ Role.USER, Role.ADMIN })
@Api(value = Urc4eshService.PATH_URC)
public class Urc4eshService implements RESTResource {

    private final Logger logger = LoggerFactory.getLogger(Urc4eshService.class);

    public static final String PATH_URC = "urc4esh";
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

    /*
     * @GET
     *
     * @Path("/{contextId: [a-zA-Z_0-9]*}")
     * // @Path(REST_API.USERCONTEXT_WITH_ID)
     *
     * @ApiOperation(value = "Get all available sitemaps.", response = SitemapDTO.class, responseContainer =
     * "Collection")
     *
     * @ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
     * public Response getEnvironmentContexts(
     *
     * @PathParam("contextId") @ApiParam(value = "context Id", required = true) String contextId) {
     * EnvironmentContextDefinition environmentContextDefinition = contextManager
     * .getEnvironmentContextDefinition(contextId);
     * if (environmentContextDefinition == null) {
     * return Response.noContent().build();
     * }s
     * return Response.ok(environmentContextDefinition).build();
     * }
     */
    @POST
    @Path(Urc4eshRestAapi.LOG_IN)
    public Response login(@QueryParam("username") String username, @QueryParam("password") String password)
            throws URISyntaxException {

        OpenAPEClient client = CommunicationManager.getClient(username, password);

        return Response.seeOther(new URI("/urc4esh/PickAnInterface.html")).header("session", username) // todo better
                                                                                                       // session id
                .build();

    }

}