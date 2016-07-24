/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Usuario
 */
public class Ubicacion {
    //Nueva statement
    Statement stmt = null;
    //Nuevo ResultSet
    ResultSet rs = null;
    private Connection con;
    //PreparedStmt
    PreparedStatement preparedStmt;
    
    private String descripcion;
    private String IdUbicacion;
    
    public Ubicacion(Connection con, String descripcion){
        this.con = con;
        this.descripcion = descripcion;
        IdUbicacion = descripcion_ubicacion();
    }
    
    public Ubicacion(Connection con){
        this.con = con;
    }
    
    public String descripcion_ubicacion(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT idUbicacion FROM Ubicacion WHERE descripcion = '" + descripcion + "'"
                )) {
                rs = stmt.getResultSet();
                rs.next();
                return rs.getString("idUbicacion");
            }
           //No encontro idUicacion
            return "No encontro idUicacion";
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Problema con la bd
        return "";
    }
    
    public String descripcion_ubicacion( String descripcion){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT idUbicacion FROM Ubicacion WHERE descripcion = '" + descripcion + "'"
                )) {
                rs = stmt.getResultSet();
                rs.next();
                return rs.getString("idUbicacion");
            }
           //No encontro idUicacion
            return "No encontro idUicacion";
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Problema con la bd
        return "";
    }
    
    public boolean actualizar_ubicacion(String id, String descripcion){       

        try {
            //Query de update
            String query = "UPDATE ubicacion SET descripcion = ? WHERE idUbicacion = ?";
            //Preparamos el query
            preparedStmt = con.prepareStatement(query);
            //Introducimos las variables
            preparedStmt.setString(1, descripcion);
            preparedStmt.setString(2, id);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Familia.class.getName()).log(Level.SEVERE, null, ex);
        }
        //No se hizo la actualizacion
        return false;
    }

    public boolean insertar_ubicacion(String descripcion, String id){
        this.descripcion = descripcion;
        this.IdUbicacion = id;
        try {
            // the mysql insert statement
              String query = " INSERT INTO ubicacion (descripcion)"
                            + " values (?)";

              // create the mysql insert preparedstatement
               preparedStmt = con.prepareStatement(query); 
              
              preparedStmt.setString (1, this.descripcion);       //descripcion
              
              // execute the preparedstatement
              preparedStmt.execute();

              return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Bien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }    
    
    public ResultSet getAll(){
        try {        
            stmt = con.createStatement();
            if (stmt.execute(
                            "SELECT descripcion FROM ubicacion ORDER BY idUbicacion "
                )) {
                
                rs = stmt.getResultSet();
                
                return rs;
            }
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }    
    
      public ResultSet getAllid(){
        try {        
            stmt = con.createStatement();
            if (stmt.execute(
                            "SELECT idUbicacion FROM ubicacion ORDER BY idUbicacion  "
                )) {
                
                rs = stmt.getResultSet();
                
                return rs;
            }
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }
    
    public ResultSet getUbicacion(String descripcion){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT * FROM ubicacion WHERE descripcion = '" + descripcion + "'"
                )) {
                
                rs = stmt.getResultSet();
                rs.next();
                
                return rs;
            }
           //No encontro odUicacion
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }  
    public String Ubicacion_by_id(int id){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT descripcion FROM inventario.ubicacion WHERE idUbicacion = '" + id + "'"
                )) {
                rs = stmt.getResultSet();
                rs.next();
                System.out.println(id);
                System.out.println(rs.getString("descripcion"));
                return rs.getString("descripcion");
            }
           //No encontro Status
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return null;

    } 
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdUbicacion() {
        return IdUbicacion;
    }

    public void setIdUbicacion(String IdUbicacion) {
        this.IdUbicacion = IdUbicacion;
    }
}
