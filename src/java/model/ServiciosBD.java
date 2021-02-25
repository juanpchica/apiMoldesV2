package model;

import java.sql.*;
import java.util.logging.Level;
import javax.swing.JOptionPane;
        
public class ServiciosBD {

    public static Connection conexion;
    public static Statement sentencia;
    public static Statement sentencia2;
    public static Statement sentencia3;
    public static ResultSet resultado;
    public static ResultSet resultado1;
    static String query = "";
    public static int update=0;
    public static boolean ERROR=true;

    public static Connection con = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;

    public static void conectar(){  
        String ruta = "jdbc:oracle:thin:@200.100.9.180:1521:PRUEBA";
        String usuario = "DISENO";
        String password = "D1I9MAG.";
        
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();  
            conexion = DriverManager.getConnection(ruta, usuario, password);
            sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  
            sentencia2 = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  
            sentencia3 = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("CONEXIÓN CORRECTA!!!");

        }catch(Exception e){ 
            System.out.println(e);
        }  

    }  
    
          
    public static void ejecutarConsulta(String q) {
        query = q;
        try {
            resultado = sentencia.executeQuery(query);
            if(resultado.next()){
                System.out.println("consulta hecha");
            }
            ERROR=false;
        } catch (SQLException e) {            
            ERROR=true;
             System.out.println("NO EJECUTO LA CONSULTA ejecutarConsulta!!");
             System.out.println(e.getMessage());
             if(e.toString().equals("java.sql.SQLException: Debe estar conectado al servidor")){
                 ServiciosBD.conectar();
             }else if(e.toString().equals("java.sql.SQLException: Conexión cerrada")){
                 ServiciosBD.conectar();
             }
        }
    }
        
    //Hacer Select General Con Parametros
    public static void ConsultaGenereal(String Select,String From,String Where, String OrderBy){
        query = "";
        String a = "SELECT " + Select + " FROM " +From + " " + Where + " "+ OrderBy +"";
        query = a;
        try{
            resultado = sentencia.executeQuery(query);
            ERROR=false;
        }catch (SQLException e){
            ERROR=true;
            System.out.println("NO EJECUTO LA CONSULTA ConsultaGenereal!! "+a+"");
            if(e.toString().equals("java.sql.SQLException: Debe estar conectado al servidor")){
                ServiciosBD.conectar();
            }else if(e.toString().equals("java.sql.SQLException: Conexión cerrada")){
                ServiciosBD.conectar();
            }
        }
    }
    
    public static boolean validateColumnExist(String colName, String tableName){
        try{
            resultado = sentencia.executeQuery("SELECT " + colName + " FROM " +tableName);
            if(resultado.next()) {
                return true;
            }
            resultado.close();
        }catch (SQLException e){
            if(e.getErrorCode() == 904){
                return false;
            }
        }
        return false;
    }
    
    public static boolean validateFieldExist(String colName, String tableName, int valueField){
        try{
            resultado = sentencia.executeQuery("SELECT " + colName + " FROM " +tableName+" where "+colName+"="+valueField);
            return resultado.next();
        }catch (SQLException e){
            return false;
        }
    }

}