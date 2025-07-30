package org.acme;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Unremovable
@RequestScoped
public class YResource {

    @GET
    @Path("/subpath")
    public String get() {
        return "y";
    }

    // This endpoint causes that HEAD does not work for the /subpath.
    // When this method is commented or not present (like in XResource), the HEAD method works as expected
    @Path("/zpath")
    public ZResource getAnotherResource() {
        return CDI.current()
                .select(ZResource.class)
                .get();
    }

}
