
package ctrl;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Molde;
import model.ServiciosBD;

/**
 *
 * @author juanpchica
 */
public class MoldesCtrl {
 
    /* Retorno una tabla con sus filas y links */
    public static ArrayList<Molde> getMoldes(){
        ArrayList<Molde> moldes  = new ArrayList<>();
        Molde molde = new Molde(); 
       
        ServiciosBD.ConsultaGenereal("*","MOLDES", "","");
        try {
            while(ServiciosBD.resultado.next()){
                molde = new Molde();
                molde.setDimensiones(ServiciosBD.resultado.getString("DIMENSIONES"));
                molde.setColumna(ServiciosBD.resultado.getString("COLUMNA"));
                molde.setLado(ServiciosBD.resultado.getString("LADO"));
                molde.setTipo(ServiciosBD.resultado.getString("TIPO"));
                molde.setCantidad(ServiciosBD.resultado.getInt("CANTIDAD"));
                moldes.add(molde); 
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        
        return moldes;
        
    }
  
}



