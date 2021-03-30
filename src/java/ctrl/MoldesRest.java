package ctrl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    @Path("/")
    public Response getVista(@QueryParam("token") String token) {
        ServiciosBD.conectar();
        return Response.ok(MoldesCtrl.getMoldes(token)).build();
    }
    
    @GET
    @Path("/molde")
    public Response getVista(@QueryParam("id") String id,@QueryParam("token") String token) {
        ServiciosBD.conectar();
        return Response.ok(MoldesCtrl.getMolde(id,token)).build();
    }
    
    @GET
    @Path("/activar")
    public Response getActivar(@QueryParam("user") String code,@QueryParam("passwd") String passwd) {
        ServiciosBD.conectar();
        return Response.ok(MoldesCtrl.getLogin(code,passwd)).build();
    }
    
    
    @PUT
    @Path("/actualizar") 
    public Response actualizar(Molde molde){
            ServiciosBD.conectar();
            Molde m = molde;
            return Response.ok(MoldesCtrl.updateMolde(m)).build();
       
    }
}