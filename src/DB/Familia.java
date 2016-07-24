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
public class Familia {
    private String idFamilia;
    private String descripcion;
    //PreparedStmt
    PreparedStatement preparedStmt;
    
    //Nueva statement
    Statement stmt = null;
    //Nuevo ResultSet
    ResultSet rs = null;
    
    private Connection con = null;
    
    public Familia(Connection con){
        this.con = con;
    }
    
    public Familia(Connection con , String descripcion){
        this.con = con;
        this.descripcion = descripcion;
        idFamilia = getFamilia();
    }
    
    
    public String getFamilia(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            
            if (stmt.execute(
                            "SELECT * FROM familia WHERE descripcion = '" + descripcion + "'"
                )) {
                
                rs = stmt.getResultSet();
                rs.beforeFirst();
                rs.next();
                idFamilia = rs.getString("idFamilia");
            }
           //No encontro odUicacion
            return idFamilia;
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }    
    
    public ResultSet getFamilia ( String descripcion){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT * FROM familia WHERE descripcion = '" + descripcion + "'"
                )) {
                
                rs = stmt.getResultSet();
                rs.beforeFirst();
                rs.next();
                idFamilia = rs.getString("idFamilia");
            }
           //No encontro odUicacion
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;
    }   
    
    public boolean actualizar_familia(String id, String descripcion){       

        try {
            //Query de update
            String query = "UPDATE familia SET descripcion = ? WHERE idFamilia = ?";
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
    
    public ResultSet getAll(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT descripcion FROM familia "
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
    public boolean insertar_familia(String descripcion, String id){
        this.descripcion = descripcion;
        this.idFamilia = id;
        try {
            // the mysql insert statement
              String query = " INSERT INTO familia (idFamilia,descripcion)"
                            + " values (?,?)";

              // create the mysql insert preparedstatement
               preparedStmt = con.prepareStatement(query); 
              
              preparedStmt.setString (1, this.idFamilia);       //idFamilia 
              preparedStmt.setString (2, this.descripcion);       //descripcion
              
              // execute the preparedstatement
              preparedStmt.execute();

              return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Bien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public String getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(String idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
