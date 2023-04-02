package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.DetailDAO;
import py.com.progweb.prueba.ejb.PointsUseDAO;
import py.com.progweb.prueba.model.Detail;
import py.com.progweb.prueba.model.PointsUse;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("pointsUse")
@Produces("application/json")
@Consumes("application/json")
public class PointUseRest {
    @Inject
    PointsUseDAO pointsUseDAO;
    @Inject
    DetailDAO detailDAO;

    @GET
    @Path("/")
    public Response listar(){
        List<PointsUse> pointsUse =pointsUseDAO.lista();
        return Response.ok(pointsUse).build();
    }

    @POST
    @Path("/")
    public Response agregar(PointsUse pu){
        this.pointsUseDAO.agregar(pu);
        return Response.ok().build();
    }
}
