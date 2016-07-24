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
 * @author Yanir
 */
public class Status {
    
    private int IdStatus;
    private String descripcion;
    //Nueva statement
    Statement stmt = null;
    //PreparedStmt
    PreparedStatement preparedStmt;    
    //Nuevo ResultSet
    ResultSet rs = null;
    
    private Connection con = null;
    
    public Status(Connection con) {
        this.con = con;
    }
    public Status(Connection con, String descrp) {
        this.con = con;
        this.descripcion = descrp;
    } 
    public String Status_fisica_by_id(int id){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT descripcion FROM inventario.estatus_cond_fisica WHERE idEstatus_fisico = '" + id + "'"
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
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return null;

    }  
    public String Status_ubicacion_by_id(int id){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT descripcion FROM inventario.estatus_cond_ubicacion WHERE idEstatus_ubicacion = '" + id + "'"
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
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return null;

    } 
    public int Status_fisica(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT idEstatus_fisico FROM inventario.estatus_cond_fisica WHERE descripcion = '" + this.descripcion + "'"
                )) {
                rs = stmt.getResultSet();
                rs.next();
                return rs.getInt("idEstatus_fisico");
            }
           //No encontro Status
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return -1;

    }
    
    public int Status_ubic(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT idEstatus_ubicacion FROM inventario.estatus_cond_ubicacion WHERE descripcion = '" + this.descripcion + "'"
                )) {
                rs = stmt.getResultSet();
                rs.next();
                return rs.getInt("idEstatus_ubicacion");
            }
           //No encontro Status
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return -1;

    }
    
    public ResultSet get_ubicacion(String descripcion){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT * FROM inventario.estatus_cond_ubicacion WHERE descripcion = '" + descripcion + "'"
                )) {
                rs = stmt.getResultSet();
                rs.next();
                return rs;
            }
           //No encontro Status
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return null;

    }
    public ResultSet get_fisico(String descripcion){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT * FROM inventario.estatus_cond_fisica WHERE descripcion = '" + descripcion + "'"
                )) {
                rs = stmt.getResultSet();
                rs.next();
                return rs;
            }
           //No encontro Status
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return null;

    }
    
    public ResultSet getAll_ubicacion(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT descripcion FROM estatus_cond_ubicacion "
                )) {
                
                rs = stmt.getResultSet();
                
                return rs;
            }
           //No encontro odUicacion
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }
    public ResultSet getAll_fisico(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT descripcion FROM estatus_cond_fisica "
                )) {
                
                rs = stmt.getResultSet();
                
                return rs;
            }
           //No encontro odUicacion
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }
    public boolean actualizar_status_ubicacion(String id, String descripcion){       

        try {
            //Query de update
            String query = "UPDATE estatus_cond_ubicacion SET descripcion = ? WHERE idEstatus_ubicacion = ?";
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
    
    public boolean actualizar_status_fisico(String id, String descripcion){       

        try {
            //Query de update
            String query = "UPDATE estatus_cond_fisica SET descripcion = ? WHERE idEstatus_fisico = ?";
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
    
    public boolean insertar_estatus_ubicacion(String descripcion){
        this.descripcion = descripcion;
        try {
            // the mysql insert statement
              String query = " INSERT INTO estatus_cond_ubicacion (descripcion)"
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
    public boolean insertar_estatus_fisico(String descripcion){
        this.descripcion = descripcion;
        try {
            // the mysql insert statement
              String query = " INSERT INTO estatus_cond_fisica (descripcion)"
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
    public ResultSet getAllid_ubicacion(){
        try {        
            stmt = con.createStatement();
            if (stmt.execute(
                            "SELECT idEstatus_ubicacion FROM estatus_cond_ubicacion ORDER BY idEstatus_ubicacion "
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
    public ResultSet getAllid_fisico(){
        try {        
            stmt = con.createStatement();
            if (stmt.execute(
                            "SELECT idEstatus_fisico FROM estatus_cond_fisica ORDER BY idEstatus_fisico "
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
    public int getIdStatus() {
        return IdStatus;
    }

    public void setIdStatus(int IdStatus) {
        this.IdStatus = IdStatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
            
    
}
