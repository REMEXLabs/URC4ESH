package org.eclipse.smarthome.urc4esh.ui;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public class Urc4eshServlet {
    @GET
    @Path("test/urc4esh")
    public String test() {
        return "Hello world";
    }
}
