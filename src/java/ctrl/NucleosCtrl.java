package ctrl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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

@Path("/nucleos")
@Consumes(value= MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class NucleosCtrl {
    
    @GET
    public Response getNucleos() {
        ServiciosBD.conectar();
        return Response.ok(MoldesCtrl.getNucleos()).build();
    }

}