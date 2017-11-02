package com.moraes;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("status")
@Produces({APPLICATION_JSON})
public class StatusResource {

    @Inject
    private StatusCheckerService checkerService;

    @GET
    public Response check () {
        checkerService.checkNow(StatusCheck.Status.OK);
        return Response.ok("{\"status\": \"ok\"}").build();
    }
}
