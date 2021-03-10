package ctrl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.ServiciosBD;
import model.Molde;

/**
 *
 * @author juanpchica
 */

@Path("/moldes")
@Consumes(value= MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class MoldesRest {
    
    @GET
    public Response getVista(@QueryParam("id") String id) {
        ServiciosBD.conectar();
        return Response.ok(MoldesCtrl.getMoldes(id)).build();
    }
    
    @PUT
    @Path("/actualizar")
    @Consumes(value= MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response actualizar(Molde molde){
        
        boolean resp = MoldesCtrl.updateMolde(molde);
        
        if(resp){
            return Response.ok(resp).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).entity("User not found").build();
        }
    }
}