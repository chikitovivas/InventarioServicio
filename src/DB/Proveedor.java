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
public class Proveedor {
    private int idProveedor;
    private String RIF;
    private String razon_social;
    private String direccion;
    private String telefono_1;
    private String telefono_2;
    private String persona_de_contacto;
    private String email;
    //PreparedStmt
    PreparedStatement preparedStmt;   
    //Nueva statement
    Statement stmt = null;
    //Nuevo ResultSet
    ResultSet rs = null;
    
    private Connection con;
    
    
    public Proveedor(Connection con, String razon_social){
        this.con = con;
        this.razon_social = razon_social;
        System.out.println("Razon social del proveedor: "+ razon_social);
        idProveedor = descripcion_proveedor();
    }
    
    public Proveedor(Connection con){
        this.con = con;
    }
    
    public int descripcion_proveedor(){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT idProveedor FROM proveedor_donante WHERE razon_social = '" + razon_social + "'"
                )) {
                rs = stmt.getResultSet();
                rs.next();
                return rs.getInt("idProveedor");
            }
           //No encontro odUicacion
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return -1;

    }
    
    public int descripcion_proveedor(String razon_social){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT idProveedor FROM proveedor_donante WHERE razon_social = '" + razon_social + "'"
                )) {
                rs = stmt.getResultSet();
                rs.next();
                return rs.getInt("idProveedor");
            }
           //No encontro odUicacion
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Problema con la bd
        return -1;

    }
        
    public ResultSet getProveedor(String razon_social){
        try {        
            stmt = con.createStatement();
            //Buscamos el id de la categoria escogida
            if (stmt.execute(
                            "SELECT * FROM Proveedor_donante WHERE razon_social = '" + razon_social + "'"
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
        
    public ResultSet getAll(){
        try {        
            stmt = con.createStatement();
            if (stmt.execute(
                            "SELECT razon_social FROM proveedor_donante "
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
                            "SELECT idProveedor FROM proveedor_donante "
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
    
    public boolean actualizar_proveedor(String id, String razon_social, String rif, String direccion, String tlf1, String tlf2,
                    String contacto, String email){       

        try {
            //Query de update
            String query = "UPDATE proveedor_donante SET razon_social = ?, rif_cedula = ?, direccion = ?, telefono_1 = ?, telefono_2 = ?, persona_contacto = ?, email = ? WHERE idProveedor = ?";
            //Preparamos el query
            preparedStmt = con.prepareStatement(query);
            //Introducimos las variables
            preparedStmt.setString(1, razon_social);
            preparedStmt.setString(2, rif);
            preparedStmt.setString(3, direccion);
            preparedStmt.setString(4, tlf1);
            preparedStmt.setString(5, tlf2);
            preparedStmt.setString(6, contacto);
            preparedStmt.setString(7, email);
            preparedStmt.setString(8, id);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Familia.class.getName()).log(Level.SEVERE, null, ex);
        }
        //No se hizo la actualizacion
        return false;
    }
    
    public boolean insertar_proveedor(String razon_social, String rif, String direccion, String tlf1, String tlf2,
                    String contacto, String email){
        try {
            // the mysql insert statement
            String query = " INSERT INTO proveedor_donante (razon_social,rif_cedula, direccion, telefono_1, telefono_2,"
                    + "persona_contacto, email)"
                          + " values (?,?,?,?,?,?,?)";

            // create the mysql insert preparedstatement
            preparedStmt = con.prepareStatement(query); 
              
            preparedStmt.setString (1, razon_social);      //razon_social 
            preparedStmt.setString (2, rif);               //rif
            preparedStmt.setString (3, direccion);         //direccion 
            preparedStmt.setString (4, tlf1);              //tlf1
            preparedStmt.setString (5, tlf2);              //tlf2 
            preparedStmt.setString (6, contacto);          //contacto
            preparedStmt.setString (7, email);             //email 
              
            // execute the preparedstatement
            preparedStmt.execute();

              return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Bien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }    
    
    int descripcion_proveedor(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRIF() {
        return RIF;
    }

    public void setRIF(String RIF) {
        this.RIF = RIF;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono_1() {
        return telefono_1;
    }

    public void setTelefono_1(String telefono_1) {
        this.telefono_1 = telefono_1;
    }

    public String getTelefono_2() {
        return telefono_2;
    }

    public void setTelefono_2(String telefono_2) {
        this.telefono_2 = telefono_2;
    }

    public String getPersona_de_contacto() {
        return persona_de_contacto;
    }

    public void setPersona_de_contacto(String persona_de_contacto) {
        this.persona_de_contacto = persona_de_contacto;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
