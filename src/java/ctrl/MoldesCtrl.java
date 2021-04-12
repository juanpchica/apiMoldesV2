
package ctrl;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Log;
import model.Molde;
import model.Nucleo;
import model.ServiciosBD;

/**
 *
 * @author juanpchica
 */
public class MoldesCtrl {
 
    /* Retorno una tabla con sus filas y links */
    public static ArrayList<Molde> getMoldes(String token){
        ArrayList<Molde> moldes  = new ArrayList<>();
        Molde molde = new Molde(); 
         
        ServiciosBD.ConsultaGenereal("*","MOLDES", "" ,"order by fecha desc,id desc");
        try {
            while(ServiciosBD.resultado.next()){ 
                
                if(ServiciosBD.resultado.getString("CODIGO") != null){
                    if(!ServiciosBD.resultado.getString("CODIGO").startsWith("C")){
                        molde = new Molde();
                        molde.setId((token == null || !token.equals("ANcVyuP3"))?0:ServiciosBD.resultado.getInt("ID"));
                        molde.setDimensiones(ServiciosBD.resultado.getString("DIMENSIONES"));
                        molde.setColumna(ServiciosBD.resultado.getString("COLUMNA"));
                        molde.setLado(ServiciosBD.resultado.getString("LADO"));
                        molde.setTipo(ServiciosBD.resultado.getString("TIPO"));
                        molde.setCantidad(ServiciosBD.resultado.getInt("CANTIDAD"));
                        molde.setUbicacion();
                        molde.setBoquete(ServiciosBD.resultado.getString("BOQUETE"));
                        molde.setSoporte(ServiciosBD.resultado.getString("SOPORTE"));
                        molde.setEstado(ServiciosBD.resultado.getString("ESTADO"));
                        molde.setNuevo(ServiciosBD.resultado.getInt("NUEVO"));
                        molde.setCodigo(ServiciosBD.resultado.getString("CODIGO"));
                        moldes.add(molde); 
                    }
                }else{
                    molde = new Molde();
                    molde.setId((token == null || !token.equals("ANcVyuP3"))?0:ServiciosBD.resultado.getInt("ID"));
                    molde.setDimensiones(ServiciosBD.resultado.getString("DIMENSIONES"));
                    molde.setColumna(ServiciosBD.resultado.getString("COLUMNA"));
                    molde.setLado(ServiciosBD.resultado.getString("LADO"));
                    molde.setTipo(ServiciosBD.resultado.getString("TIPO"));
                    molde.setCantidad(ServiciosBD.resultado.getInt("CANTIDAD"));
                    molde.setUbicacion();
                    molde.setBoquete(ServiciosBD.resultado.getString("BOQUETE"));
                    molde.setSoporte(ServiciosBD.resultado.getString("SOPORTE"));
                    molde.setEstado(ServiciosBD.resultado.getString("ESTADO"));
                    molde.setNuevo(ServiciosBD.resultado.getInt("NUEVO"));
                    molde.setCodigo(ServiciosBD.resultado.getString("CODIGO"));
                    moldes.add(molde); 
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        
        return moldes;
    }
    
    /* Retorno una tabla con sus filas y links */
    public static Molde getMolde(String id,String token){
        Molde molde = new Molde(); 
        if(!token.equals("ANcVyuP3")){
            return null;
        }
        ServiciosBD.ConsultaGenereal("*","MOLDES",  "where id = "+id,"");
        try {
            if(ServiciosBD.resultado.next()){
                molde.setId(ServiciosBD.resultado.getInt("ID"));
                molde.setDimensiones(ServiciosBD.resultado.getString("DIMENSIONES"));
                molde.setColumna((ServiciosBD.resultado.getString("COLUMNA") == null)?"":ServiciosBD.resultado.getString("COLUMNA"));
                molde.setLado((ServiciosBD.resultado.getString("LADO") == null)?"":ServiciosBD.resultado.getString("LADO"));
                molde.setTipo(ServiciosBD.resultado.getString("TIPO"));
                molde.setCantidad(ServiciosBD.resultado.getInt("CANTIDAD"));
                molde.setUbicacion();
                molde.setBoquete(ServiciosBD.resultado.getString("BOQUETE"));
                molde.setSoporte(ServiciosBD.resultado.getString("SOPORTE"));
                molde.setEstado(ServiciosBD.resultado.getString("ESTADO"));
                molde.setNuevo(ServiciosBD.resultado.getInt("NUEVO"));
                molde.setCodigo((ServiciosBD.resultado.getString("CODIGO")==null)?"":ServiciosBD.resultado.getString("CODIGO"));
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        
        return molde;
    }
    
    public static boolean updateMolde(Molde m){
        
        try {
            String q = "Update MOLDES set CANTIDAD="+m.getCantidad()+",COLUMNA='"+m.getColumna()+"',LADO='"+m.getLado()+"',BOQUETE='"+m.getBoquete()+"',SOPORTE='"+m.getSoporte()+"',ESTADO='"+m.getEstado()+"',NUEVO=0,TIPO='"+m.getTipo()+"' where ID="+m.getId();
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
    
    /* Obtengo el nombre de la tabla y el id del subgrupo de esta tabla */
    public static Log getLogin(String code, String passwd){
        Log token = new Log("");
        if(code.equals("adm-mol") && passwd.equals("cVtjM5fXU7hRETJ9")){
            token.setStatus("ANcVyuP3");
        }else{
            token.setStatus("Error");
        }
        return token;
    }
    
}



