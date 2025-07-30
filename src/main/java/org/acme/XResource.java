package org.acme;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Unremovable
@RequestScoped
public class XResource {

    @GET
    @Path("/subpath")
    public String get() {
        return "x";
    }

}
