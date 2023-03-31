package py.com.progweb.prueba.rest;


import py.com.progweb.prueba.ejb.ConceptsPointsDAO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("conceptsPoints")
@Consumes("application/json")
@Produces("application/json")
public class ConceptPointsRest {
    @Inject
    ConceptsPointsDAO conceptsPointsDAO;

    @GET
    @Path("/")
    public Response listar(){
        return Response.ok(conceptsPointsDAO.lista()).build();
    }
}
