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
        return Response.ok(MoldesCtrl.getMoldes(id)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Headers","origin, content-type, accept, authorization").header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
    }
    
    @PUT
    @Path("/actualizar")
    @Consumes(value= MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response actualizar(Molde molde){
        
        boolean resp = MoldesCtrl.updateMolde(molde);
        
        if(resp){
            return Response.status(200)
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .header("Access-Control-Allow-Credentials", true)
                .header("Access-Control-Allow-Headers","origin, content-type, accept")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, OPTIONS").build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).entity("User not found").header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Headers","origin, content-type, accept, authorization").header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
        }
    }
}