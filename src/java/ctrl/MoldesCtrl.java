
package ctrl;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Molde;
import model.Nucleo;
import model.ServiciosBD;

/**
 *
 * @author juanpchica
 */
public class MoldesCtrl {
 
    /* Retorno una tabla con sus filas y links */
    public static ArrayList<Molde> getMoldes(String id){
        ArrayList<Molde> moldes  = new ArrayList<>();
        Molde molde = new Molde(); 
        String where = (id == null)?"":" where id = "+id;
        
        ServiciosBD.ConsultaGenereal("*","MOLDES", where ,"order by fecha asc,id");
        try {
            while(ServiciosBD.resultado.next()){
                molde = new Molde();
                molde.setID(ServiciosBD.resultado.getInt("ID"));
                molde.setDimensiones(ServiciosBD.resultado.getString("DIMENSIONES"));
                molde.setColumna(ServiciosBD.resultado.getString("COLUMNA"));
                molde.setLado(ServiciosBD.resultado.getString("LADO"));
                molde.setTipo(ServiciosBD.resultado.getString("TIPO"));
                molde.setCantidad(ServiciosBD.resultado.getInt("CANTIDAD"));
                molde.setUbicacion();
                molde.setBoquete(ServiciosBD.resultado.getInt("VOQUETE"));
                molde.setSoporte(ServiciosBD.resultado.getInt("SOPORTE"));
                molde.setEstado(ServiciosBD.resultado.getInt("ESTADO"));
                moldes.add(molde); 
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        
        return moldes;
    }
    
    public static boolean updateMolde(Molde m){
        
        try {
            String q = "Update MOLDES set CANTIDAD="+m.getCantidad()+",COLUMNA='"+m.getColumna()+"',LADO='"+m.getLado()+"',VOQUETE="+m.getBoquete()+",SOPORTE="+m.getSoporte()+",ESTADO="+m.getEstado()+" where ID="+m.getID();
            ServiciosBD.ejecutarConsulta(q);
            ServiciosBD.resultado.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        
        return false;
    }
    
    /* Retorno una tabla con sus filas y links */
    public static ArrayList<Nucleo> getNucleos(){
        ArrayList<Nucleo> nucleos  = new ArrayList<>();
        Nucleo nucleo = new Nucleo(); 
        
        ServiciosBD.ConsultaGenereal("*","NUCLEOS", "" ,"ORDER BY IDNUCLEO DESC");
        try {
            while(ServiciosBD.resultado.next()){
                nucleo = new Nucleo();
                nucleo.setCODIGO(ServiciosBD.resultado.getString("CODIGO"));
                nucleo.setDIAMETROINT(ServiciosBD.resultado.getInt("DIAMETROINT"));
                nucleo.setDIAMETROEXT(ServiciosBD.resultado.getInt("DIAMETROEXT"));
                nucleo.setBI(ServiciosBD.resultado.getDouble("BI"));
                nucleo.setBISIN(ServiciosBD.resultado.getDouble("BISIN"));
                nucleo.setLAMINA(ServiciosBD.resultado.getString("LAMINA"));
                nucleo.setAC(ServiciosBD.resultado.getDouble("AC"));
                nucleo.setBC(ServiciosBD.resultado.getDouble("BC"));
                nucleo.setLN2(ServiciosBD.resultado.getDouble("LN2"));
                nucleo.setAI2(ServiciosBD.resultado.getDouble("AI2"));
                nucleo.setAI2SIN(ServiciosBD.resultado.getDouble("AI2SIN"));
                nucleo.setHN(ServiciosBD.resultado.getDouble("AI2SIN"));
                nucleo.setFP(ServiciosBD.resultado.getDouble("FP"));
                nucleo.setLAMXGRUPO(ServiciosBD.resultado.getString("LAMXGRUPO"));
                nucleo.setPESO(ServiciosBD.resultado.getString("PESO"));
                nucleo.setDISENO(ServiciosBD.resultado.getString("DISENO"));
                nucleo.setVERSION(ServiciosBD.resultado.getString("VERSION"));
               
                nucleos.add(nucleo); 
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        
        return nucleos;
    }
    
}



